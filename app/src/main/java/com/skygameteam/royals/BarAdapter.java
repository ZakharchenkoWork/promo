package com.skygameteam.royals;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static com.skygameteam.royals.BarAdapter.ITEMS.DIAMOND;
import static com.skygameteam.royals.BarAdapter.ITEMS.FIVE;
import static com.skygameteam.royals.BarAdapter.ITEMS.KLEVER;
import static com.skygameteam.royals.BarAdapter.ITEMS.TEN;

/**
 * Created by Konstantyn Zakharchenko on 05.12.2018.
 */

public class BarAdapter extends RecyclerView.Adapter {
    enum ITEMS {DIAMOND, TEN, FIVE, KLEVER}
    private int height;
    private static ITEMS[] items = { FIVE, KLEVER, DIAMOND, TEN,  KLEVER, FIVE, DIAMOND, TEN, KLEVER, FIVE, KLEVER, DIAMOND, TEN, KLEVER, FIVE, DIAMOND, TEN, KLEVER};

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
        return 500;
    }


    public static ITEMS getItem(int position) {
        int positionInList = position % items.length;
        return items[positionInList];
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            RelativeLayout.LayoutParams layoutParams = ((RelativeLayout.LayoutParams)image.getLayoutParams());

            layoutParams.width = height/3 - layoutParams.getMarginStart()*2;
            layoutParams.height = layoutParams.width;
            image.setLayoutParams(layoutParams);
        }
    }
    public @DrawableRes
    int getResource(ITEMS item) {
        switch (item) {
            case KLEVER:
                return R.drawable.drawable_13;
            case DIAMOND:
                return R.drawable.drawable_14;
            case TEN:
                return R.drawable.drawable_15;
            case FIVE:
                return R.drawable.drawable_16;

            default:
                return 0;
        }
    }
}
