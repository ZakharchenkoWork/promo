package com.test.lb1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        return root;
    }
}
