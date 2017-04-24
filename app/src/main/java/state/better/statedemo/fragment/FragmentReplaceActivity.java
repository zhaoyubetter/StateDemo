package state.better.statedemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import state.better.statedemo.R;
import state.better.statedemo.fragment.replace.FragmentC;
import state.better.statedemo.fragment.replace.FragmentD;

/**
 * 添加类似添加布局一样，原来的一直会显示
 */
public class FragmentReplaceActivity extends AppCompatActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_replace);

		if (savedInstanceState == null) {

		}

		findViewById(R.id.addFragmentC).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				Fragment f = fragmentManager.findFragmentByTag(FragmentC.class.getName());
				if (f == null) {
					f = Fragment.instantiate(getApplicationContext(), FragmentC.class.getName());
				}
				fragmentManager.beginTransaction().replace(R.id.container, f, FragmentC.class.getName())
						.commit();
			}
		});


		findViewById(R.id.addFragmentD).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				Fragment f = fragmentManager.findFragmentByTag(FragmentD.class.getName());
				if (f == null) {
					f = Fragment.instantiate(getApplicationContext(), FragmentD.class.getName());
				}
				fragmentManager.beginTransaction().replace(R.id.container, f, FragmentD.class.getName())
						.commit();
			}
		});



		findViewById(R.id.removeFragmentD).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				Fragment f = fragmentManager.findFragmentByTag(FragmentD.class.getName());
				if (f != null) {
					fragmentManager.beginTransaction().remove(f).commit();
				}
			}
		});
	}
}
