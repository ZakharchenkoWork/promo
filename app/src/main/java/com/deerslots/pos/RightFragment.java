package com.deerslots.pos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Konstantyn Zakharchenko on 29.11.2018.
 */

public class RightFragment extends BasePageFragment {


    @Override
    public int layoutId() {
        return R.layout.fragment_right;
    }

    @Override
    public void prepareViews(View root) {
        root.findViewById(R.id.game3).setOnClickListener(v->goToGame("keks"));
        root.findViewById(R.id.game4).setOnClickListener(v->goToGame("lucky_ladys_charm"));
        root.findViewById(R.id.game5).setOnClickListener(v->goToGame("pharaohs_gold_ii"));
    }


}

