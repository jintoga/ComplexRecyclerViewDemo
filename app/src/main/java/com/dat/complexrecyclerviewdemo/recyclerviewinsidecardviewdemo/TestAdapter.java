package com.dat.complexrecyclerviewdemo.recyclerviewinsidecardviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.dat.complexrecyclerviewdemo.R;
import java.util.List;

/**
 * Created by DAT on 2/16/2017.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder>
    implements StickyHeaderAdapter<TestAdapter.HeaderHolder> {
    List<String> data;

    public TestAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public long getHeaderId(int position) {
        return 0;
    }

    @Override
    public HeaderHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_test_header, parent, false);
        return new HeaderHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderHolder viewholder, int position) {

    }

    public void addItem(String item) {
        data.add(item);
        notifyItemRangeInserted(data.size() - 1, data.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (data.get(position) != null) {
            holder.text.setText(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.text)
        TextView text;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class HeaderHolder extends RecyclerView.ViewHolder {
        HeaderHolder(View itemView) {
            super(itemView);
        }
    }
}
