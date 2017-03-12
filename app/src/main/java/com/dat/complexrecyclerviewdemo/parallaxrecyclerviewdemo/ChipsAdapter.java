package com.dat.complexrecyclerviewdemo.parallaxrecyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.dat.complexrecyclerviewdemo.R;
import java.util.List;

public class ChipsAdapter extends RecyclerView.Adapter<ChipsAdapter.ViewHolder> {

    private List<ChipsEntity> chipsEntities;
    private boolean isShowingPosition;

    public ChipsAdapter(List<ChipsEntity> chipsEntities) {
        this.chipsEntities = chipsEntities;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chip, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindItem(chipsEntities.get(position));
    }

    @Override
    public int getItemCount() {
        return chipsEntities.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tvDescription)
        TextView tvDescription;
        @Bind(R.id.ivPhoto)
        ImageView ivPhoto;
        @Bind(R.id.tvName)
        TextView tvName;
        @Bind(R.id.tvPosition)
        TextView tvPosition;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindItem(ChipsEntity entity) {
            itemView.setTag(entity.getName());
            if (TextUtils.isEmpty(entity.getDescription())) {
                tvDescription.setVisibility(View.GONE);
            } else {
                tvDescription.setVisibility(View.VISIBLE);
                tvDescription.setText(entity.getDescription());
            }

            if (entity.getDrawableResId() != 0) {
                ivPhoto.setVisibility(View.VISIBLE);
                Glide.with(ivPhoto.getContext())
                    .load(entity.getDrawableResId())
                    .transform(new CircleTransform(ivPhoto.getContext()))
                    .into(ivPhoto);
            } else {
                ivPhoto.setVisibility(View.GONE);
            }

            tvName.setText(entity.getName());

            if (isShowingPosition) {
                tvPosition.setText(String.valueOf(getAdapterPosition()));
            }
        }
    }
}
