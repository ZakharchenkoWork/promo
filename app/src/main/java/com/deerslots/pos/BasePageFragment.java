package com.deerslots.pos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Konstantyn Zakharchenko on 12.12.2018.
 */

public abstract class BasePageFragment extends Fragment {
    private LayoutInflater inflater;
    private ViewGroup container;
    protected View root;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;

        if (root == null) {
            root = inflater.inflate(layoutId(), null);
        }
        prepareViews(root);
        return root;
    }
    protected void goToGame(String name){
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra(WebViewActivity.GAME_NAME, name);
        startActivity(intent);
    }
    public abstract int layoutId();
    public abstract void prepareViews(View root);


}
