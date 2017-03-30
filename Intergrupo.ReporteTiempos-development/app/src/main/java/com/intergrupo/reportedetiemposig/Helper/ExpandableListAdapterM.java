package com.intergrupo.reportedetiemposig.Helper;

/**
 * Created by USUARIO on 23/05/2016.
 */


import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.intergrupo.reportedetiemposig.Model.TimesForManager;
import com.intergrupo.reportedetiemposig.Model.TimesForManagerParent;
import com.intergrupo.reportedetiemposig.R;


public class ExpandableListAdapterM extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<TimesForManagerParent> expandableListTitleOriginal;
    private ArrayList<TimesForManagerParent> expandableListTitleCopy;
    private HashMap<String, ArrayList<TimesForManager>> expandableListDetailOriginal;
    private HashMap<String, ArrayList<TimesForManager>> expandableListDetailCopy;

    public ExpandableListAdapterM(Context context, ArrayList<TimesForManagerParent>
            expandableListTitleOriginal, HashMap<String, ArrayList<TimesForManager>>
            expandableListDetailOriginal) {

        this.context = context;
        this.expandableListTitleOriginal = expandableListTitleOriginal;
        this.expandableListDetailOriginal = expandableListDetailOriginal;
        this.expandableListDetailCopy = (HashMap<String, ArrayList<TimesForManager>>) this
                .expandableListDetailOriginal.clone();
        this.expandableListTitleCopy = (ArrayList<TimesForManagerParent>)
                expandableListTitleOriginal.clone();

    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetailCopy.get(this.expandableListTitleCopy.get(listPosition)
                .getProyectM()).get(expandedListPosition);

    }

    @Override
    public long getChildId(int listPosition, int expandableListPosition) {
        return expandableListPosition;

    }

    @Override
    public View getChildView(int listPosition, int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final TimesForManager timesForManager = (TimesForManager) getChild(listPosition,
                expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_itemg, null);
        }
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.expandedListItemg);
        TextView numbergreen = (TextView) convertView.findViewById(R.id.tvgreen);
        numbergreen.setText(timesForManager.getHourActivity().toString());
        expandedListTextView.setText(timesForManager.getIdCollaboratorName() + " " +
                timesForManager.getIdCollaboratorLast());
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetailCopy.get(this.expandableListTitleCopy.get(listPosition)
                .getProyectM())
                .size();
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
        TimesForManagerParent listTitle = (TimesForManagerParent) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_view_proyectg, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);
        listTitleTextView.setText(listTitle.getProyectM());
        TextView numbered = (TextView) convertView.findViewById(R.id.tvred);
        numbered.setText(listTitle.getTimesRed() + "");
        TextView numbergreen = (TextView) convertView.findViewById(R.id.tvgreen);
        numbergreen.setText(listTitle.getTimesGreen() + "");

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

    public void filterSearch(String query) {

        query = query.toLowerCase();

        this.expandableListTitleCopy.clear();
        this.expandableListDetailCopy.clear();


        if (query.isEmpty()) {

            this.expandableListTitleCopy = (ArrayList<TimesForManagerParent>)
                    expandableListTitleOriginal.clone();
            this.expandableListDetailCopy = (HashMap<String, ArrayList<TimesForManager>>) this
                    .expandableListDetailOriginal.clone();
        } else {

            for (TimesForManagerParent parent : this.expandableListTitleOriginal) {
                ArrayList<TimesForManager> newList = new ArrayList<>();
                ArrayList<TimesForManager> alllist = this.expandableListDetailOriginal.get(parent
                        .getProyectM());

                for (TimesForManager activity : alllist) {
                    if (activity.getProyectName().toLowerCase().contains(query) ||
                            activity.getIdCollaboratorName().toLowerCase().contains(query) ||
                            activity.getIdCollaboratorLast().toLowerCase().contains(query)) {
                        newList.add(activity);


                    }

                }
                expandableListDetailCopy.put(parent.getProyectM(), newList);
                if (newList.size() > 0) {
                    expandableListTitleCopy.add(parent);

                }

            }
        }

        notifyDataSetChanged();
    }
}
