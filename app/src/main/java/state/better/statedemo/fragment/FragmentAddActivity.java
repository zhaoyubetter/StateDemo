package state.better.statedemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import state.better.statedemo.R;
import state.better.statedemo.fragment.add.FragmentA;
import state.better.statedemo.fragment.add.FragmentB;

/**
 * 添加类似添加布局一样，原来的一直会显示
 */
public class FragmentAddActivity extends AppCompatActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_add);

		if (savedInstanceState == null) {
			Fragment f = Fragment.instantiate(getApplicationContext(), FragmentA.class.getName());
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction().add(R.id.container, f, FragmentA.class.getName())
					.commit();
		}


		findViewById(R.id.addFragmentB).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				Fragment f = fragmentManager.findFragmentByTag(FragmentB.class.getName());
				if (f == null) {
					f = Fragment.instantiate(getApplicationContext(), FragmentB.class.getName());
				}
				// 如果不添加返回栈，remove() 该fragment实例会销毁的
				fragmentManager.beginTransaction().add(R.id.container, f, FragmentB.class.getName())
						.addToBackStack(null).commit();
			}
		});

		findViewById(R.id.removeFragmentB).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				Fragment f = fragmentManager.findFragmentByTag(FragmentB.class.getName());
				if (f != null) {
					fragmentManager.beginTransaction().remove(f).commit();
					fragmentManager.executePendingTransactions();
				}
			}
		});
	}
}
