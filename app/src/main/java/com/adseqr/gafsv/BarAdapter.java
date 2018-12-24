package com.adseqr.gafsv;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static com.adseqr.gafsv.BarAdapter.ITEMS.DIAMOND;
import static com.adseqr.gafsv.BarAdapter.ITEMS.FIVE;
import static com.adseqr.gafsv.BarAdapter.ITEMS.KLEVER;
import static com.adseqr.gafsv.BarAdapter.ITEMS.SHIT;
import static com.adseqr.gafsv.BarAdapter.ITEMS.TEN;

/**
 * Created by Konstantyn Zakharchenko on 05.12.2018.
 */

public class BarAdapter extends RecyclerView.Adapter {
    enum ITEMS {DIAMOND, TEN, FIVE, KLEVER, SHIT}

    private int height;
    private static ITEMS[] items = {FIVE, KLEVER, DIAMOND, SHIT, TEN, KLEVER, FIVE, DIAMOND, TEN,SHIT,  KLEVER, FIVE, KLEVER, DIAMOND,SHIT,  TEN, KLEVER, FIVE, DIAMOND, TEN, SHIT, KLEVER};

    public void setHeight(int height) {
        this.height = height;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bar_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder) viewHolder).image.setImageResource(getResource(getItem(i)));
    }

    @Override
    public int getItemCount() {
        return 5000;
    }


    public static ITEMS getItem(int position) {
        int positionInList = position % items.length;
        positionInList = positionInList < 0 ? -positionInList : positionInList;
        return items[positionInList];
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            RelativeLayout.LayoutParams layoutParams = ((RelativeLayout.LayoutParams) image.getLayoutParams());

            layoutParams.width = height / 3 - layoutParams.getMarginStart() * 2;
            layoutParams.height = layoutParams.width;
            image.setLayoutParams(layoutParams);
        }
    }

    public @DrawableRes
    int getResource(ITEMS item) {
        switch (item) {
            case KLEVER:
                return R.drawable.drawable_4;
            case DIAMOND:
                return R.drawable.drawable_5;
            case TEN:
                return R.drawable.drawable_6;
            case FIVE:
                return R.drawable.drawable_7;
                case SHIT:
                return R.drawable.drawable_8;

            default:
                return 0;
        }
    }
}
