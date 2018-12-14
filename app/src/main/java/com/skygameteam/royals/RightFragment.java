package com.skygameteam.royals;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Konstantyn Zakharchenko on 29.11.2018.
 */

public class RightFragment extends Fragment {
    private LayoutInflater inflater;
    private ViewGroup container;
    protected View root;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;

        if (root == null) {
            root = inflater.inflate(R.layout.fragment_right, null);
        }

        ImageView arrowLeft = root.findViewById(R.id.arrowLeft);
        arrowLeft.setOnClickListener(v->onArrowClickedListener.onArrow());
        return root;
    }
    private OnArrowClickedListener onArrowClickedListener = ()->{};

    public Fragment setOnArrowClickedListener(OnArrowClickedListener onArrowClickedListener) {
        this.onArrowClickedListener = onArrowClickedListener;
        return this;
    }

    public interface OnArrowClickedListener{
        void onArrow();
}
}
