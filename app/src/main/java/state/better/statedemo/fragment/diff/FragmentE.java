package state.better.statedemo.fragment.diff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import state.better.statedemo.R;
import state.better.statedemo.fragment.BaseFragment;

/**
 * Created by zhaoyu on 2017/4/24.
 */

public class FragmentE extends BaseFragment {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_e, container, false);
	}
}
