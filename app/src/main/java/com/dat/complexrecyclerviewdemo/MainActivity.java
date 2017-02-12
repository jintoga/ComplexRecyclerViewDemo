package com.dat.complexrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.dat.complexrecyclerviewdemo.adapters.ExpandableItemAdapter;
import com.dat.complexrecyclerviewdemo.adapters.HeaderAdapter;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        // Setup expandable feature and RecyclerView
        RecyclerViewExpandableItemManager expandableItemManager =
            new RecyclerViewExpandableItemManager(null);
        RecyclerView.Adapter adapter;
        adapter = new ExpandableItemAdapter();
        adapter = expandableItemManager.createWrappedAdapter(adapter);
        List<String> headers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            headers.add("Header " + i);
        }
        adapter = new HeaderAdapter(adapter, headers);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // NOTE: need to disable change animations to ripple effect work properly
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        expandableItemManager.attachRecyclerView(recyclerView);
    }
}
