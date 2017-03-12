package com.dat.complexrecyclerviewdemo.parallaxrecyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import java.util.List;

/**
 * Created by DAT on 3/12/2017.
 */

public interface IItemsFactory<ChipsEntity> {
    List<ChipsEntity> getFewItems();

    List<ChipsEntity> getItems();

    List<ChipsEntity> getDoubleItems();

    List<ChipsEntity> getALotOfItems();

    List<ChipsEntity> getALotOfRandomItems();

    ChipsEntity createOneItemForPosition(int position);

    RecyclerView.Adapter<? extends RecyclerView.ViewHolder> createAdapter(List<ChipsEntity> items);
}
