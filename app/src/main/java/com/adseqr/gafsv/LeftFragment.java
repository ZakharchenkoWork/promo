package com.adseqr.gafsv;

import android.content.Intent;
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

public class LeftFragment extends Fragment {
    private LayoutInflater inflater;
    private ViewGroup container;
    protected View root;
    private View.OnClickListener listener;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;

        if (root == null) {
            root = inflater.inflate(R.layout.fragment_left, null);
        }
        //ImageView arrowRight = root.findViewById(R.id.arrowRight);
        //arrowRight.setOnClickListener(v -> onArrowClickedListener.onArrow());
        ImageView game0 = root.findViewById(R.id.game0);
        game0.setOnClickListener(listener);
     /*   ImageView game1 = root.findViewById(R.id.game1);
        game1.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.putExtra(WebViewActivity.GAME_NAME, "bananas_go_bahamas");
            startActivity(intent);
        });*/

        return root;
    }

    public LeftFragment setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
        return this;
    }

    private OnArrowClickedListener onArrowClickedListener = () -> {
    };

    public LeftFragment setOnArrowClickedListener(OnArrowClickedListener onArrowClickedListener) {
        this.onArrowClickedListener = onArrowClickedListener;
        return this;
    }

    public interface OnArrowClickedListener {
        void onArrow();
    }
}
