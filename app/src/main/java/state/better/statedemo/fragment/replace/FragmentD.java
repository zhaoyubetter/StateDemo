package state.better.statedemo.fragment.replace;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import state.better.statedemo.R;
import state.better.statedemo.fragment.BaseFragment;

/**
 * Created by zhaoyu on 2017/4/23.
 */

public class FragmentD extends BaseFragment {

	TextView tv;
	private List<String> data;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_d, container, false);


		// 调用 remove 的时候，fragment 对应的view被销毁了，但是实例变量依然存在的
		// 但是，如果是系统回收时，这些成员变量是被回收的，还是可以通过 savedInstanceState 来实现恢复；
		// 如果是返回键，则该fragment直接destroy了，成员变量没有，恢复也不行了（跟Activity类似）
		if (data == null) {
			data = new ArrayList<>(100);
			for (int i = 0; i < 100; i++) {
				data.add("ABC " + i);
			}
		}
		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		tv = (TextView) view.findViewById(R.id.tv);
	}
}
