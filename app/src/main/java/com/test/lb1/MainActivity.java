package com.test.lb1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    RelativeLayout mainHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mainHolder = findViewById(R.id.mainHolder);



    }
    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private FragmentManager fm;
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm;
        }
        @Override
        public Fragment getItem(int position) {

            if (position == 0) {
                return new LeftFragment().setOnArrowClickedListener(()->pager.setCurrentItem(1)).setOnClickListener(v->{
                    fm.beginTransaction().replace(R.id.mainHolder, new SlotFragment()).commit();
                });
            }else {
                return new RightFragment().setOnArrowClickedListener(()->pager.setCurrentItem(1));
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
