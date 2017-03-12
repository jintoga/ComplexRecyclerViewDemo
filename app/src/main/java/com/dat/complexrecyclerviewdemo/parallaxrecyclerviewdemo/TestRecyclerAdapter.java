package com.dat.complexrecyclerviewdemo.parallaxrecyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;
import com.beloo.widget.chipslayoutmanager.SpacingItemDecoration;
import com.dat.complexrecyclerviewdemo.R;
import com.squareup.picasso.Picasso;
import com.yayandroid.parallaxrecyclerview.ParallaxViewHolder;
import java.util.List;

/**
 * Created by yahyabayramoglu on 14/04/15.
 */
public class TestRecyclerAdapter extends RecyclerView.Adapter<TestRecyclerAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;

    private int[] imageIds = new int[] {
        R.drawable.bg1, R.drawable.bg2, R.drawable.bg3, R.drawable.bg4
    };

    /*private String[] imageUrls = new String[] {
        "http://yayandroid.com/data/github_library/parallax_listview/test_image_1.jpg",
        "http://yayandroid.com/data/github_library/parallax_listview/test_image_2.jpg",
        "http://yayandroid.com/data/github_library/parallax_listview/test_image_3.png",
        "http://yayandroid.com/data/github_library/parallax_listview/test_image_4.jpg",
        "http://yayandroid.com/data/github_library/parallax_listview/test_image_5.png",
    };*/

    public TestRecyclerAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        return new ViewHolder(inflater.inflate(R.layout.parallax_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // viewHolder.getBackgroundImage().setImageResource(imageIds[position % imageIds.length]);
        Picasso.with(context)
            .load(imageIds[position % imageIds.length])
            .into(viewHolder.getBackgroundImage());
        viewHolder.getTextView().setText("Row " + position);

        // # CAUTION:
        // Important to call this method
        viewHolder.getBackgroundImage().reuse();
    }

    @Override
    public int getItemCount() {
        return 14;
    }

    /**
     * # CAUTION:
     * ViewHolder must extend from ParallaxViewHolder
     */
    public static class ViewHolder extends ParallaxViewHolder {

        @Bind(R.id.label)
        TextView textView;
        @Bind(R.id.chips)
        RecyclerView chips;
        private IItemsFactory itemsFactory = new ChipsFactory();
        private RecyclerView.Adapter adapter;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            initChipsRV();
        }

        private void initChipsRV() {
            ChipsLayoutManager layoutManager = ChipsLayoutManager.newBuilder(itemView.getContext())
                .setOrientation(ChipsLayoutManager.VERTICAL)
                .setScrollingEnabled(true)
                .setMaxViewsInRow(3)
                .build();
            chips.setLayoutManager(layoutManager);
            chips.setNestedScrollingEnabled(false);
            chips.setAdapter(createAdapter());
            chips.addItemDecoration(new SpacingItemDecoration(
                itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.item_space),
                itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.item_space)));
        }

        @SuppressWarnings("unchecked")
        private RecyclerView.Adapter createAdapter() {

            //        List<String> items = itemsFactory.getDoubleItems();
            List<String> items = itemsFactory.getALotOfItems();

            adapter = itemsFactory.createAdapter(items);
            return adapter;
        }

        @Override
        public int getParallaxImageId() {
            return R.id.backgroundImage;
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
