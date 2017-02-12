package com.dat.complexrecyclerviewdemo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dat.complexrecyclerviewdemo.R;
import com.dat.complexrecyclerviewdemo.model.MyGroupItem;
import com.dat.complexrecyclerviewdemo.model.MyItem;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAT on 2/13/2017.
 */

public class ExpandableItemAdapter extends
    AbstractExpandableItemAdapter<ExpandableItemAdapter.GroupViewHolder, ExpandableItemAdapter.ChildViewHolder> {
    List<MyGroupItem> groups;

    public ExpandableItemAdapter() {
        setHasStableIds(true); // this is required for expandable feature.
        groups = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyGroupItem groupItem = new MyGroupItem(i, "GROUP " + i);
            for (int j = 0; j < 5; j++) {
                groupItem.children.add(new MyItem(j, "child " + j));
            }
            groups.add(groupItem);
        }
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildCount(int groupPosition) {
        return groups.get(groupPosition).children.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groups.get(groupPosition).getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // This method need to return unique value within the group.
        return groups.get(groupPosition).children.get(childPosition).getId();
    }

    @Override
    public GroupViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
        GroupViewHolder vh = new GroupViewHolder(v);
        return vh;
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item, parent, false);
        ChildViewHolder vh = new ChildViewHolder(v);
        return vh;
    }

    @Override
    public void onBindGroupViewHolder(GroupViewHolder holder, int groupPosition, int viewType) {
        MyGroupItem group = groups.get(groupPosition);
        holder.textView.setText(group.getText());
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int groupPosition, int childPosition,
        int viewType) {
        MyItem child = groups.get(groupPosition).children.get(childPosition);
        holder.textView.setText(child.getText());
    }

    @Override
    public boolean onCheckCanExpandOrCollapseGroup(GroupViewHolder holder, int groupPosition, int x,
        int y, boolean expand) {
        return true;
    }

    static class GroupViewHolder extends AbstractExpandableItemViewHolder {
        TextView textView;

        GroupViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }

    static class ChildViewHolder extends AbstractExpandableItemViewHolder {
        TextView textView;

        ChildViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
