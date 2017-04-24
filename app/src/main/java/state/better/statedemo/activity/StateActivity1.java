package state.better.statedemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import state.better.statedemo.R;


public class StateActivity1 extends BaseActivity {

	// 系统已经帮我们做好了View层面基本的恢复工作

	/**
	 * 自动记录 滚动文字
	 */
	ListView listView;
	/**
	 * 记录内容
	 */
	EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_state1);

		listView = (ListView) findViewById(R.id.list);
		et = (EditText) findViewById(R.id.et_test);

		Log.e(TAG, "onCreate: " + savedInstanceState);

		String[] a = new String[255 - 64 + 1];
		for (int i = 64; i < 255; i++) {
			a[i-64] = ">>>>>" + ((char) i);
		}
		listView.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, a));
	}

	@Override
	protected void onStart() {
		super.onStart();
	}
}
