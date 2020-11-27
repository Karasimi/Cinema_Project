package com.example.doanrapphim.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.doanrapphim.R;
import com.example.doanrapphim.activity_chitiet.group;
import com.example.doanrapphim.activity_chitiet.item;

import java.util.List;
import java.util.Map;

public class listadapter  extends BaseExpandableListAdapter {
    private List<group> listgroup;
    private Map<group, List<item>> listitem;

    public listadapter(List<group> listgroup, Map<group, List<item>> listitem) {
        this.listgroup = listgroup;
        this.listitem = listitem;
    }

    @Override
    public int getGroupCount() {
        if (listgroup != null)
            return listgroup.size();
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (listitem != null && listgroup != null)
            return listitem.get(listgroup.get(groupPosition)).size();
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listgroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listitem.get(listgroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        group g = listgroup.get(groupPosition);
        return  g.getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return  0;

    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_group, parent, false);
        }
        TextView tvGroup = convertView.findViewById(R.id.tv);
        group groupitem = listgroup.get(groupPosition);
        tvGroup.setText(groupitem.getName().toUpperCase());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        }
        TextView tvItem = convertView.findViewById(R.id.tvitem);
        item ltitem = listitem.get(listgroup.get(groupPosition)).get(childPosition);
        tvItem.setText(ltitem.getName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
