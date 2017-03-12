package com.dat.complexrecyclerviewdemo.parallaxrecyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import com.dat.complexrecyclerviewdemo.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class ChipsFactory implements IItemsFactory<ChipsEntity> {

    @Override
    public List<ChipsEntity> getFewItems() {
        List<ChipsEntity> chipsList = new ArrayList<>();
        chipsList.add(
            ChipsEntity.newBuilder().drawableResId(R.drawable.batman).name("Batman").build());

        chipsList.add(ChipsEntity.newBuilder()
            .drawableResId(R.drawable.batman)
            .name("Veronic Cloyd")
            .build());

        chipsList.add(ChipsEntity.newBuilder()
            .drawableResId(R.drawable.batman)
            .name("Jayne")
            .description("Everyone want to meet Jayne")
            .build());

        chipsList.add(
            ChipsEntity.newBuilder().drawableResId(R.drawable.batman).name("Cat").build());

        chipsList.add(
            ChipsEntity.newBuilder().drawableResId(R.drawable.batman).name("Jess").build());

        chipsList.add(
            ChipsEntity.newBuilder().drawableResId(R.drawable.batman).name("Ann Ackerman").build());

        chipsList.add(ChipsEntity.newBuilder()
            .drawableResId(R.drawable.batman)
            .name("Second Batman")
            .description("Batman is our friend")
            .build());

        chipsList.add(
            ChipsEntity.newBuilder().drawableResId(R.drawable.batman).name("Claudette").build());

        chipsList.add(
            ChipsEntity.newBuilder().drawableResId(R.drawable.batman).name("Karl").build());

        chipsList.add(ChipsEntity.newBuilder()
            .drawableResId(R.drawable.anonymous)
            .name("Very Long Name Anonymous")
            .build());

        return chipsList;
    }

    @Override
    public List<ChipsEntity> getItems() {
        List<ChipsEntity> chipsEntities = getFewItems();

        List<ChipsEntity> secondPortion = getFewItems();
        Collections.reverse(secondPortion);
        chipsEntities.addAll(secondPortion);
        chipsEntities.addAll(getFewItems());
        chipsEntities.addAll(getFewItems());

        for (int i = 0; i < chipsEntities.size(); i++) {
            ChipsEntity chipsEntity = chipsEntities.get(i);
            chipsEntity.setName(chipsEntity.getName() + " " + i);
        }

        return chipsEntities;
    }

    @Override
    public List<ChipsEntity> getDoubleItems() {
        List<ChipsEntity> chipsEntities = getFewItems();

        List<ChipsEntity> secondPortion = getFewItems();
        Collections.reverse(secondPortion);
        chipsEntities.addAll(secondPortion);
        return chipsEntities;
    }

    @Override
    public List<ChipsEntity> getALotOfItems() {
        List<ChipsEntity> entities = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            entities.addAll(getItems());
        }
        return entities;
    }

    @Override
    public List<ChipsEntity> getALotOfRandomItems() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public ChipsEntity createOneItemForPosition(int position) {
        return ChipsEntity.newBuilder()
            .name("Newbie " + position)
            .drawableResId(R.drawable.anonymous)
            .build();
    }

    @Override
    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> createAdapter(
        List<ChipsEntity> chipsEntities) {
        return new ChipsAdapter(chipsEntities);
    }
}
