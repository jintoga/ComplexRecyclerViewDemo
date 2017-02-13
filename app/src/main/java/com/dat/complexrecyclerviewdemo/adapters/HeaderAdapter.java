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
    AbstractHeaderFooterWrapperAdapter<RecyclerView.ViewHolder, HeaderAdapter.FooterViewHolder> {
    List<String> headers;
    private static final int HEADER_TYPE_1 = 1;
    private static final int HEADER_TYPE_2 = 2;
    private static final int HEADER_TYPE_3 = 3;

    public HeaderAdapter(RecyclerView.Adapter adapter, List<String> headers) {
        setAdapter(adapter);
        this.headers = headers;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderItemViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == HEADER_TYPE_1) {
            view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.header_type_1, parent, false);
            HeaderType1ViewHolder viewHolder = new HeaderType1ViewHolder(view);
            return viewHolder;
        } else {
            view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.header_item, parent, false);
            HeaderViewHolder viewHolder = new HeaderViewHolder(view);
            return viewHolder;
        }
    }

    @Override
    public int getHeaderItemViewType(int localPosition) {
        switch (localPosition) {
            case 0:
                return HEADER_TYPE_1;
            case 1:
                return HEADER_TYPE_2;
            case 2:
                return HEADER_TYPE_3;
        }
        return super.getHeaderItemViewType(localPosition);
    }

    @Override
    public FooterViewHolder onCreateFooterItemViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindHeaderItemViewHolder(RecyclerView.ViewHolder holder, int localPosition) {
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).textView.setText(headers.get(localPosition));
        }
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

    static class HeaderType1ViewHolder extends RecyclerView.ViewHolder {

        HeaderType1ViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {
        FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
