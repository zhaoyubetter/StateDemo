package state.better.statedemo.activity.lazy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

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
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
