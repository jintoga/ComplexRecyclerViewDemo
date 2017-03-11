package com.dat.complexrecyclerviewdemo.recyclerviewinsidecardviewdemo;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by DAT on 2/20/2017.
 */

public class MyDecor extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
        RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position

        if (position == 0) {
            outRect.top =  -4;
        }
    }
}
