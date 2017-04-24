package state.better.statedemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;

import state.better.statedemo.R;
import state.better.statedemo.activity.BaseActivity;
import state.better.statedemo.activity.StateActivity1;
import state.better.statedemo.fragment.diff.DetailFragment;
import state.better.statedemo.fragment.diff.FragmentE;
import state.better.statedemo.fragment.diff.FragmentF;

/**
 * 不用的fragment实例，实现相同的fragment状态
 * Created by zhaoyu on 2017/4/24.
 */
public class DiffFragmentStateRestoreActivity extends BaseActivity {

	final String STATE_ = "state_";

	SparseArray<Fragment.SavedState> savedStateSparseArray = new SparseArray<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_state_restore_demo);

		// 恢复
		if (savedInstanceState != null) {
			savedStateSparseArray = savedInstanceState.getSparseParcelableArray(STATE_);
		}

		// 打开其他activity
		findViewById(R.id.button_open_another_activity).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), StateActivity1.class));
			}
		});

		// detail Fragment
		findViewById(R.id.button_add_detail_fragment).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_container, new DetailFragment(), FragmentF.class.getName())
						.addToBackStack(DetailFragment.class.getName())
						.commit();
			}
		});


		findViewById(R.id.tab1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
// save current tab
				Fragment tab2Fragment = getSupportFragmentManager().findFragmentByTag(FragmentF.class.getName());
				if (tab2Fragment != null) {
					// 保存 tab2Fragment的状态
					saveFragmentState(1, tab2Fragment);
				}

				// restore last state, 每次都new
				FragmentE tab1Fragment = new FragmentE();
				restoreFragmentState(0, tab1Fragment);

				// show new tab
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_container, tab1Fragment, FragmentE.class.getName())
						.commit();
			}
		});

		findViewById(R.id.tab2).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Fragment tab1Fragment = getSupportFragmentManager().findFragmentByTag(FragmentE.class.getName());
				if (tab1Fragment != null) {
					saveFragmentState(0, tab1Fragment);
				}

				// 每次都new
				FragmentF tab2Fragment = new FragmentF();
				restoreFragmentState(1, tab2Fragment);

				getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_container, tab2Fragment, FragmentF.class.getName())
						.commit();
			}
		});

	}


	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putSparseParcelableArray(STATE_, savedStateSparseArray);
	}


	/**
	 * 手动存状态
	 *
	 * @param index
	 * @param fragment
	 */
	private void saveFragmentState(int index, Fragment fragment) {
		Fragment.SavedState savedState = getSupportFragmentManager().saveFragmentInstanceState(fragment);
		savedStateSparseArray.put(index, savedState);
	}

	/**
	 * 手动调用 恢复状态
	 *
	 * @param index
	 * @param fragment
	 */
	private void restoreFragmentState(int index, Fragment fragment) {
		Fragment.SavedState savedState = savedStateSparseArray.get(index);
		fragment.setInitialSavedState(savedState);
	}

}