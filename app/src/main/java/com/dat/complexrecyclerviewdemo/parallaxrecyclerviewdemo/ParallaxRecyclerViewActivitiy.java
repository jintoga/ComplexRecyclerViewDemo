package com.dat.complexrecyclerviewdemo.parallaxrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.dat.complexrecyclerviewdemo.R;
import com.yayandroid.parallaxrecyclerview.ParallaxRecyclerView;

/**
 * Created by DAT on 3/12/2017.
 */

public class ParallaxRecyclerViewActivitiy extends AppCompatActivity {
    @Bind(R.id.recyclerView)
    protected ParallaxRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallax_demo);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new TestRecyclerAdapter(this));
    }
}
