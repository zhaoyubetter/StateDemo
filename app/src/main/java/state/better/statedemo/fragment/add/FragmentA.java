package state.better.statedemo.fragment.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import state.better.statedemo.R;
import state.better.statedemo.fragment.BaseFragment;

/**
 * Created by zhaoyu on 2017/4/23.
 */

public class FragmentA extends BaseFragment {

	EditText et;
	CheckBox cb;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_a, container, false);
		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		et = (EditText) view.findViewById(R.id.et_test);
		cb = (CheckBox) view.findViewById(R.id.chk);
	}
}
