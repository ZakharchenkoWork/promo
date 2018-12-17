package com.anexgamean.ex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    RelativeLayout mainHolder;
    TextView leftFieldData;
    int usersMoney = (int) (Math.random() * 5_000_000);
    int userExperiencePercent = 50;
    TextView rightFieldStarsNumber;
    ImageView rightFieldFill;
    ImageView rightField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mainHolder = findViewById(R.id.mainHolder);

        leftFieldData = findViewById(R.id.leftFieldData);
        leftFieldData.setText(prepareMoney(usersMoney));
        rightFieldStarsNumber = (TextView) findViewById(R.id.rightFieldStarsNumber);
        rightFieldStarsNumber.setText("" + (userExperiencePercent / 100));
        rightField = (ImageView) findViewById(R.id.rightField);
        rightFieldFill = (ImageView) findViewById(R.id.rightFieldFill);
        rightField.post(() -> prepareExp(userExperiencePercent));
    }

    void prepareExp(int exp) {
        rightFieldStarsNumber.setText("" + (userExperiencePercent / 100));
        ViewGroup.LayoutParams layoutParams = rightFieldFill.getLayoutParams();
        layoutParams.width = (rightField.getWidth() / 100) * (exp % 100);
        rightFieldFill.setLayoutParams(layoutParams);
    }

    private String prepareMoney(int usersMoney) {
        if (usersMoney > 1_000_000) {
            int millions = (int) (usersMoney / 1_000_000);
            int thousands = usersMoney % 1_000_000;
            return millions + "." + prepare3digits((int) (thousands / 1000)) + "." + prepare3digits(thousands % 1000);
        } else if (usersMoney > 1_000) {
            return (int) (usersMoney / 1000) + "." + prepare3digits(usersMoney % 1000);
        } else {
            return "" + usersMoney;
        }
    }

    private String prepare3digits(int number) {
        if (number < 10) {
            return "00" + number;
        } else if (number < 100) {
            return "0" + number;
        } else {
            return "" + number;
        }
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
                return new LeftFragment().setOnArrowClickedListener(() -> pager.setCurrentItem(1)).setOnClickListener(v -> {
                    SlotFragment fragment = new SlotFragment();
                    fm.beginTransaction().replace(R.id.mainHolder, fragment).commit();
                    fragment.setOnSpinListener(result -> {

                        leftFieldData.setText(prepareMoney(usersMoney += result));
                        if (result < 0) {
                            prepareExp(userExperiencePercent += 1);
                        } else {
                            prepareExp(userExperiencePercent += result / 10);
                        }
                    });
                });
            } else {
                return new RightFragment().setOnArrowClickedListener(() -> pager.setCurrentItem(0));
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
