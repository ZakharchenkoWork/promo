package com.daferslot.facel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by Konstantyn Zakharchenko on 05.12.2018.
 */

public class SlotFragment extends Fragment {

    private LayoutInflater inflater;
    private ViewGroup container;
    protected View root;
    RecyclerView bar0;
    RecyclerView bar1;
    RecyclerView bar2;
    RecyclerView bar3;
    RecyclerView bar4;
    LinearLayout winFirstThree;
    LinearLayout winSecondThree;
    LinearLayout winLastThree;
    LinearLayout winFirstFour;
    LinearLayout winLastFour;
    LinearLayout winAll;
    TextView win;
    Animation animation;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;


        if (root == null) {
            root = inflater.inflate(R.layout.fragment_slot, null);
        }
        animation = AnimationUtils.loadAnimation(root.getContext(), R.anim.blinking_animation);
        win = root.findViewById(R.id.win);
        prepareBar(bar0 = root.findViewById(R.id.bar0));

        prepareBar(bar1 = root.findViewById(R.id.bar1));

        prepareBar(bar2 = root.findViewById(R.id.bar2));

        prepareBar(bar3 = root.findViewById(R.id.bar3));

        prepareBar(bar4 = root.findViewById(R.id.bar4));

        winFirstThree = root.findViewById(R.id.winFirstThree);
        winSecondThree = root.findViewById(R.id.winSecondThree);
        winLastThree = root.findViewById(R.id.winLastThree);
        winFirstFour = root.findViewById(R.id.winFirstFour);
        winLastFour = root.findViewById(R.id.winLastFour);
        winAll = root.findViewById(R.id.winAll);

        LinearLayout touchBlocker = root.findViewById(R.id.touchBlocker);
        touchBlocker.setOnTouchListener((v, d) -> true);
        ImageView spin = root.findViewById(R.id.spin);
        spin.setOnClickListener(new Spiner());
        win.setText("");
        return root;
    }

    public static final int bet = 10;
    public static final int allWin = bet * 5;
    public static final int fourWin = bet * 4;
    public static final int threeWin = bet * 3;

    class Spiner implements View.OnClickListener {
        int previousPosition0 = 5000;
        int previousPosition1 = 5000;
        int previousPosition2 = 5000;
        int previousPosition3 = 5000;
        int previousPosition4 = 5000;

        @Override
        public void onClick(View v) {
            win.setText("");
            onSpinListener.onResult(-bet);

            winFirstThree.clearAnimation();

            winSecondThree.clearAnimation();

            winLastThree.clearAnimation();

            winFirstFour.clearAnimation();
            winLastFour.clearAnimation();
            winAll.clearAnimation();


            winFirstThree.setVisibility(View.GONE);
            winSecondThree.setVisibility(View.GONE);
            winLastThree.setVisibility(View.GONE);
            winFirstFour.setVisibility(View.GONE);
            winLastFour.setVisibility(View.GONE);
            winAll.setVisibility(View.GONE);

            int position0 = generatePosition(previousPosition0);
            int position1 = generatePosition(previousPosition1);
            int position2 = generatePosition(previousPosition2);
            int position3 = generatePosition(previousPosition3);
            int position4 = generatePosition(previousPosition4);

            bar0.smoothScrollToPosition(position0);
            bar1.smoothScrollToPosition(position1);
            bar2.smoothScrollToPosition(position2);
            bar3.smoothScrollToPosition(position3);
            bar4.smoothScrollToPosition(position4);

            BarAdapter.ITEMS value0 = normalizePosition(previousPosition0, position0);
            BarAdapter.ITEMS value1 = normalizePosition(previousPosition1, position1);
            BarAdapter.ITEMS value2 = normalizePosition(previousPosition2, position2);
            BarAdapter.ITEMS value3 = normalizePosition(previousPosition3, position3);
            BarAdapter.ITEMS value4 = normalizePosition(previousPosition4, position4);


            if (value0 == value1 && value1 == value2 && value2 == value3 && value3 == value4) {
                winAll.setVisibility(View.VISIBLE);
                winAll.startAnimation(animation);
                onSpinListener.onResult(bet*5);
                win.setText(getString(R.string.win, bet*5));
            } else if (value0 == value1 && value1 == value2 && value2 == value3) {
                winFirstFour.setVisibility(View.VISIBLE);
                winFirstFour.startAnimation(animation);
                onSpinListener.onResult(bet*4);
                win.setText(getString(R.string.win, bet*4));
            } else if (value1 == value2 && value2 == value3 && value3 == value4) {
                winLastFour.setVisibility(View.VISIBLE);
                winLastFour.startAnimation(animation);
                onSpinListener.onResult(bet*4);
                win.setText(getString(R.string.win, bet*4));
            } else if (value0 == value1 && value1 == value2) {
                winFirstThree.setVisibility(View.VISIBLE);
                winFirstThree.startAnimation(animation);
                onSpinListener.onResult(bet*3);
                win.setText(getString(R.string.win, bet*3));
            } else if (value1 == value2 && value2 == value3) {
                winSecondThree.setVisibility(View.VISIBLE);
                winSecondThree.startAnimation(animation);

                onSpinListener.onResult(bet*3);
                win.setText(getString(R.string.win, bet*3));
            } else if (value2 == value3 && value3 == value4) {
                winLastThree.setVisibility(View.VISIBLE);
                winLastThree.startAnimation(animation);
                onSpinListener.onResult(bet*3);
                win.setText(getString(R.string.win, bet*3));
            }

            previousPosition0 = position0;
            previousPosition1 = position1;
            previousPosition2 = position2;
            previousPosition3 = position3;
            previousPosition4 = position4;


        }

        private BarAdapter.ITEMS normalizePosition(int previousPosition, int position) {
            if (position > previousPosition) {
                return BarAdapter.getItem(position - 1);
            } else if (position == previousPosition) {
                return BarAdapter.getItem(position);
            } else {
                return BarAdapter.getItem(position + 1);
            }

        }
    }

    public void setOnSpinListener(OnSpinListener onSpinListener) {
        this.onSpinListener = onSpinListener;
    }

    private OnSpinListener onSpinListener = v -> {
    };

    public interface OnSpinListener {
        void onResult(int win);
    }

    private int generatePosition(int previousPosition) {
        double random = Math.random();
        int newPosition = (random > 0.5 ? +40 : -40) + (int) (random * 20f - 10) + previousPosition;
        return previousPosition == newPosition ? generatePosition(previousPosition) : newPosition;
    }

    public void prepareBar(RecyclerView bar) {
        bar.setLayoutManager(new LinearLayoutManager(getActivity()));
        bar.post(()->{
            BarAdapter adapter = new BarAdapter();
            adapter.setHeight(bar.getHeight());
            bar.setAdapter(adapter);

            bar.getLayoutManager().scrollToPosition(5000);
        });


    }
}
