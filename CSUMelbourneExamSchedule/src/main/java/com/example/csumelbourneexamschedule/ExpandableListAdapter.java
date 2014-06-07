package com.example.csumelbourneexamschedule;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> listChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this.context = context;
        this.listHeader = listDataHeader;
        this.listChild = listChildData;
    }

    @Override
    public Object getChild(int headerPosition, int childPosititon) {
        return this.listChild.get(this.listHeader.get(headerPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int headerPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int headerPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(headerPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflatorData = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflatorData.inflate(R.layout.list_item, null);
        }

        TextView childTextList = (TextView) convertView
                .findViewById(R.id.lblListItem);

        childTextList.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int headerPosition) {
        return this.listChild.get(this.listHeader.get(headerPosition))
                .size();
    }

    @Override
    public Object getGroup(int headerPosition) {
        return this.listHeader.get(headerPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listHeader.size();
    }

    @Override
    public long getGroupId(int headerPosition) {
        return headerPosition;
    }

    @Override
    public View getGroupView(int headerPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(headerPosition);
        if (convertView == null) {
            LayoutInflater inflatorData = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflatorData.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int headerPosition, int childPosition) {
        return true;
    }
}