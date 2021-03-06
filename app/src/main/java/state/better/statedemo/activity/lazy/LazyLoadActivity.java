package state.better.statedemo.activity.lazy;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import state.better.statedemo.R;

public class LazyLoadActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<CharSequence> titles;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy_load);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        initData();
        PagerAdapter adapter = new LazyFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles);
        //PagerAdapter adapter = new LazyFragmentStatePagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initData() {
        titles = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            titles.add("页面" + i);
        }

        fragments = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            fragments.add(LazyFragment1.getInstance("" + i));
        }
    }
}
