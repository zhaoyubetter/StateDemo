package state.better.statedemo.activity.lazy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import state.better.statedemo.R;
import state.better.statedemo.fragment.BaseFragment;

/**
 * Created by zhaoyu1 on 2017/7/3.
 */

public class LazyFragment1 extends BaseFragment implements LazyLoadCallBack {

    final String TAG = "better_lazy";

    TextView title;

    public static Fragment getInstance(String title) {
        LazyFragment1 fragment1 = new LazyFragment1();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment1.setArguments(bundle);
        return fragment1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lazy, container, false);
        title = (TextView) view.findViewById(R.id.title);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title.setText("我是 fragment ： " + getArguments().getString("title"));


    }

    /**
     * 在这里实现加载数据逻辑，实现延迟加载
     */
    @Override
    public void onLoad() {
        Log.e(TAG, this.toString() + " 假设在这里进行网络请求数据。。。");
    }
}
