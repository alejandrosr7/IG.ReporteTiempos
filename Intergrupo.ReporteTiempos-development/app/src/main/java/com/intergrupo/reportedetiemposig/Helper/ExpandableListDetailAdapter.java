package com.intergrupo.reportedetiemposig.Helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.intergrupo.reportedetiemposig.Model.ViewTimesManagerDetail;
import com.intergrupo.reportedetiemposig.R;
import com.intergrupo.reportedetiemposig.Ui.Controller.ViewTimesManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by USUARIO on 13/08/2016.
 */
public class ExpandableListDetailAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<ViewTimesManagerDetail> expandableListTitleOriginal;
    private ArrayList<ViewTimesManagerDetail> expandableListTitleCopy;

    public ExpandableListDetailAdapter(Context context, ArrayList<ViewTimesManagerDetail> expandableListTitleOriginal) {

        this.context = context;
        this.expandableListTitleOriginal = expandableListTitleOriginal;
        expandableListTitleCopy = (ArrayList<ViewTimesManagerDetail>) this.expandableListTitleOriginal.clone();

    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListTitleCopy.get(listPosition);

    }

    @Override
    public long getChildId(int listPosition, int expandableListPosition) {
        return expandableListPosition;

    }

    @Override
    public View getChildView(int listPosition, int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final ViewTimesManagerDetail viewTimesManagerDetail = (ViewTimesManagerDetail) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item_detail, null);
        }
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.expandedListItemDetail);
        TextView numbergreen = (TextView) convertView.findViewById(R.id.tvgreenDetail);
        switch (expandedListPosition) {
            case 0:
                expandedListTextView.setText(R.string.administrativas);
                numbergreen.setText(viewTimesManagerDetail.getAdministrativeHour()+"");
                break;
            case 1:
                expandedListTextView.setText(R.string.novedades);
                numbergreen.setText(viewTimesManagerDetail.getNewnessHour()+"");
                break;
            case 2:
                expandedListTextView.setText(R.string.productivas);
                numbergreen.setText(viewTimesManagerDetail.getProductiveHour()+"");
                break;
        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return 3;
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitleCopy.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitleCopy.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        ViewTimesManagerDetail listDetail = (ViewTimesManagerDetail) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_view_detail, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitleDetail);
        listTitleTextView.setText(listDetail.getCollaboratorName());
        TextView numbergreen = (TextView) convertView.findViewById(R.id.tvGreenDetail);
        numbergreen.setText(listDetail.getTotalTime() + "");

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }

    public void filterSearchDetail(String query) {

        query = query.toLowerCase();

          this.expandableListTitleCopy.clear();
//        this._listDataChild.clear();


        if (query.isEmpty()) {

            expandableListTitleCopy = (ArrayList<ViewTimesManagerDetail>) expandableListTitleOriginal.clone();

        } else {

            for (ViewTimesManagerDetail parent : this.expandableListTitleOriginal) {
                if (parent.getCollaboratorName().toLowerCase().contains(query)) {
                    expandableListTitleCopy.add(parent);

                }

            }
        }

        notifyDataSetChanged();

    }
}
