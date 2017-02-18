package com.dat.complexrecyclerviewdemo.recyclerviewinsidecardviewdemo;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.dat.complexrecyclerviewdemo.R;
import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    protected Toolbar toolbar;
    @Bind(R.id.recyclerView)
    protected RecyclerView recyclerView;
    private TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        init();
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(
            new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        setCardViewBackgroundToRecyclerView(recyclerView);

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            data.add("Item " + i);
        }
        adapter = new TestAdapter(data);
        recyclerView.addItemDecoration(new StickyHeaderDecoration(adapter));
        recyclerView.setAdapter(adapter);
    }

    private void setCardViewBackgroundToRecyclerView(RecyclerView recyclerView) {
        CardView cardView = new CardView(this);
        cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        cardView.setUseCompatPadding(true);
        cardView.setPreventCornerOverlap(false);
        cardView.setRadius(0);
        int cardShadow = (int) cardView.getCardElevation();
        recyclerView.setPadding(cardView.getContentPaddingLeft() + cardShadow,
            cardView.getContentPaddingTop() + cardShadow + 3,
            cardView.getContentPaddingRight() + cardShadow,
            cardView.getContentPaddingBottom() + cardShadow + 3);
        ViewCompat.setElevation(recyclerView, cardView.getCardElevation());
        recyclerView.setBackground(cardView.getBackground());
    }
}
