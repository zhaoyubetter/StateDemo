package state.better.statedemo.activity.lazy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyu1 on 2017/7/3.
 */

public class LazyFragmentPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> mFragments;
	private List<CharSequence> mTitles;
	private int mLastPosition = -1;

	public LazyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public LazyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<CharSequence> titles) {
		this(fm);
		this.mFragments = new ArrayList<>();
		this.mTitles = new ArrayList<>();

		mFragments.addAll(fragments);
		mTitles.addAll(titles);

		// 设置Load标记
		if (mFragments.size() > 0) {
			for (Fragment f : mFragments) {
				Bundle bundle = new Bundle();
				bundle.putBoolean("load", false);
				f.setArguments(bundle);
			}
		}

		if (mTitles != null && mTitles.size() != mFragments.size()) {
			throw new IllegalArgumentException("Title size must equals Fragment size");
		}
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return mTitles.get(position);
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

	@Override
	public void setPrimaryItem(ViewGroup container, int position, Object fragment) {
		super.setPrimaryItem(container, position, fragment);
		if (fragment instanceof Fragment) {
			Fragment f = (Fragment) fragment;
			if (f instanceof LazyLoadCallBack && mLastPosition != position
					&& f.isResumed()) {
				mLastPosition = position;
				if (!f.getArguments().getBoolean("load")) {
					f.getArguments().putBoolean("load", true);
					((LazyLoadCallBack) f).onLoad();
				}
			}
		}
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		super.destroyItem(container, position, object);
		if (object instanceof Fragment) {
			Bundle arguments = ((Fragment) object).getArguments();
			if (arguments != null) {
				arguments.remove("load");
			}
		}
	}
}
