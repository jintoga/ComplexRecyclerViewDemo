package com.dat.complexrecyclerviewdemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dat.complexrecyclerviewdemo.R;
import com.h6ah4i.android.widget.advrecyclerview.headerfooter.AbstractHeaderFooterWrapperAdapter;
import java.util.List;

/**
 * Created by DAT on 2/13/2017.
 */

public class HeaderAdapter extends
    AbstractHeaderFooterWrapperAdapter<HeaderAdapter.HeaderViewHolder, HeaderAdapter.FooterViewHolder> {
    List<String> headers;

    public HeaderAdapter(RecyclerView.Adapter adapter, List<String> headers) {
        setAdapter(adapter);
        this.headers = headers;
    }

    @Override
    public HeaderViewHolder onCreateHeaderItemViewHolder(ViewGroup parent, int viewType) {
        View v =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item, parent, false);
        HeaderViewHolder vh = new HeaderViewHolder(v);
        return vh;
    }

    @Override
    public FooterViewHolder onCreateFooterItemViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindHeaderItemViewHolder(HeaderViewHolder holder, int localPosition) {
        holder.textView.setText(headers.get(localPosition));
    }

    @Override
    public void onBindFooterItemViewHolder(FooterViewHolder holder, int localPosition) {

    }

    @Override
    public int getHeaderItemCount() {
        return headers.size();
    }

    @Override
    public int getFooterItemCount() {
        return 0;
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        HeaderViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.header);
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {
        FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
