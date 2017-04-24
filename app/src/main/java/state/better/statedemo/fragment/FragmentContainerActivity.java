package state.better.statedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import state.better.statedemo.R;


/**
 * Fragment 容器Activity
 * Created by zhaoyu on 2017/4/23.
 */
public class FragmentContainerActivity extends AppCompatActivity {

	public static final String FRAGMENT_NAME = "fg_name";


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_container);
		if (savedInstanceState == null) {
			String fragmentName = getIntent().getStringExtra(FRAGMENT_NAME);
			if (!TextUtils.isEmpty(fragmentName)) {
				Fragment f = Fragment.instantiate(getApplicationContext(), fragmentName);
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager.beginTransaction().add(R.id.container, f, fragmentName).commit();
			}
		}
	}
}
