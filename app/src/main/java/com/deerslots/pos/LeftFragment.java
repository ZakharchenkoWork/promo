package com.deerslots.pos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.deerslots.pos.R;
import com.deerslots.pos.WebViewActivity;

/**
 * Created by Konstantyn Zakharchenko on 29.11.2018.
 */

public class LeftFragment extends BasePageFragment {
    @Override
    public int layoutId() {
        return R.layout.fragment_left;
    }

    @Override
    public void prepareViews(View root) {
        root.findViewById(R.id.game0).setOnClickListener(v->goToGame("bananas_go_bahamas"));
        root.findViewById(R.id.game1).setOnClickListener(v->goToGame("beetle_mania_deluxe"));
        root.findViewById(R.id.game2).setOnClickListener(v->goToGame("just_jewels_deluxe"));
    }

}
