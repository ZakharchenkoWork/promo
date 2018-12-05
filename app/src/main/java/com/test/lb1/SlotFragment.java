package com.test.lb1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Konstantyn Zakharchenko on 05.12.2018.
 */

public class SlotFragment extends Fragment {

    private LayoutInflater inflater;
    private ViewGroup container;
    protected View root;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;

        if (root == null) {
            root = inflater.inflate(R.layout.fragment_slot, null);
        }
        prepareBar(root.findViewById(R.id.bar0));
        prepareBar(root.findViewById(R.id.bar1));
        prepareBar(root.findViewById(R.id.bar2));
        prepareBar(root.findViewById(R.id.bar3));
        prepareBar(root.findViewById(R.id.bar4));


        return root;
    }
    public void prepareBar(RecyclerView bar){
        bar.setLayoutManager(new LinearLayoutManager(getActivity()));
        bar.setAdapter(new BarAdapter());
        bar.getLayoutManager().scrollToPosition(Integer.MAX_VALUE / 2);
    }
}
