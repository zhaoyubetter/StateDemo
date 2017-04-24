package state.better.statedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import state.better.statedemo.activity.StateActivity1;
import state.better.statedemo.fragment.DiffFragmentStateRestoreActivity;
import state.better.statedemo.fragment.FragmentAddActivity;
import state.better.statedemo.fragment.FragmentReplaceActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// activity
		findViewById(R.id.activity_).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), StateActivity1.class);
				startActivity(intent);
			}
		});

		findViewById(R.id.fragment_add).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), FragmentAddActivity.class);
				startActivity(intent);
			}
		});

		findViewById(R.id.fragment_replace).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), FragmentReplaceActivity.class);
				startActivity(intent);
			}
		});

		findViewById(R.id.fragment_diff).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), DiffFragmentStateRestoreActivity.class);
				startActivity(intent);
			}
		});

	}
}
