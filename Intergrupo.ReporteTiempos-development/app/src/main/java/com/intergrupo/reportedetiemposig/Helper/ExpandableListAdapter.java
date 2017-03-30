package com.intergrupo.reportedetiemposig.Helper;

/**
 * Created by Usuario on 5/05/2016.
 */

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.intergrupo.reportedetiemposig.Model.ViewTimesModel;
import com.intergrupo.reportedetiemposig.R;
import com.intergrupo.reportedetiemposig.Ui.Controller.ViewTimes;
import com.intergrupo.reportedetiemposig.Util.Constants;


public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private ArrayList<HashMap> _listDataHeader;
    private ArrayList<HashMap> _listDataHeaderOriginal;// header titles
    // child data in format of header title, child title
    private HashMap<String, ArrayList<ViewTimesModel>> _listDataChild;
    private HashMap<String, ArrayList<ViewTimesModel>> _listDataChildOriginal;

    public ExpandableListAdapter(Context context, ArrayList<HashMap> listDataHeader,
                                 HashMap<String, ArrayList<ViewTimesModel>> listChildData) {
        this._context = context;
        this._listDataHeaderOriginal = new ArrayList<>();
        this._listDataHeaderOriginal = listDataHeader;
        this._listDataHeader = new ArrayList<>();
        this._listDataHeader = (ArrayList<HashMap>) this._listDataHeaderOriginal.clone();
        this._listDataChildOriginal = new HashMap<>();
        this._listDataChildOriginal = listChildData;
        this._listDataChild = new HashMap<>();
        this._listDataChild = (HashMap<String, ArrayList<ViewTimesModel>>) this
                ._listDataChildOriginal.clone();
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition).get(Constants.ID)
                .toString()).get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {

        final ViewTimesModel childText = (ViewTimesModel) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item_times, null);
        }

        TextView tvTimeItem = (TextView) convertView
                .findViewById(R.id.tvTimeItem);

        tvTimeItem.setText(childText.getDescripcion());
        tvTimeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog;
                alertDialog = new AlertDialog.Builder(_context);
                alertDialog.setTitle(Constants.REPORT);
                alertDialog.setMessage(childText.getDescripcion());
                alertDialog.setPositiveButton(R.string.aceptar, new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();

            }
        });

        ImageView ivEdit = (ImageView) convertView.findViewById(R.id.ivEdit);

        ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class[] listClass = new Class[1];
                listClass[0] = ViewTimesModel.class;
                try {
                    Method MethodPrueba = ViewTimes.class.getMethod(Constants.EDIT_TIME, listClass);
                    MethodPrueba.invoke(v.getContext(), childText);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        ImageView ivDelete = (ImageView) convertView.findViewById(R.id.ivDelete);

        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class[] listClass = new Class[1];
                listClass[0] = ViewTimesModel.class;
                try {
                    Method MethodPrueba = ViewTimes.class.getMethod(Constants
                            .CONFIRMATION_DELETE_TIME, listClass);
                    MethodPrueba.invoke(v.getContext(), childText);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        System.out.println(this._listDataChild.get(this._listDataHeader.get(groupPosition).get
                (Constants.ID).toString()).size());
        return this._listDataChild.get(this._listDataHeader.get(groupPosition).get(Constants.ID)
                .toString()).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup
            parent) {
        HashMap headerTitle = (HashMap) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_view_proyects, null);
        }

        TextView proyectName = (TextView) convertView.findViewById(R.id.tvNameProyectItem);
        proyectName.setText(headerTitle.get(Constants.PROYECT).toString());
        TextView proyectTimes = (TextView) convertView.findViewById(R.id.tvHoursItem);
        proyectTimes.setText(headerTitle.get(Constants.TIME).toString());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query, ArrayList<Date> fecha, Boolean weekly, Boolean monthly) {

        query = query.toLowerCase();

        this._listDataHeader.clear();
        this._listDataChild.clear();


        Date fromDate = new Date();
        Date toDate = new Date();
        Calendar calendarioActual = new GregorianCalendar();
        calendarioActual.setTime(new Date());
        calendarioActual.set(Calendar.HOUR_OF_DAY, 0);
        calendarioActual.set(Calendar.MINUTE, 0);
        calendarioActual.set(Calendar.SECOND, 0);
        calendarioActual.set(Calendar.MILLISECOND, 0);
        if (weekly) {
            if (calendarioActual.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                calendarioActual.add(Calendar.DAY_OF_YEAR, -7);
            }
            calendarioActual.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            fromDate = calendarioActual.getTime();
            calendarioActual.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            calendarioActual.add(Calendar.DAY_OF_YEAR, 1);
            toDate = calendarioActual.getTime();
        } else if (monthly) {
            calendarioActual.set(Calendar.HOUR_OF_DAY, 0);
            calendarioActual.set(Calendar.DAY_OF_MONTH, calendarioActual.getActualMinimum
                    (Calendar.DAY_OF_MONTH));
            fromDate = calendarioActual.getTime();
            calendarioActual.set(Calendar.DAY_OF_MONTH, calendarioActual.getActualMaximum
                    (Calendar.DAY_OF_MONTH));
            toDate = calendarioActual.getTime();
        }


        if (query.isEmpty() && fecha == null && !weekly && !monthly) {
            this._listDataHeader = (ArrayList<HashMap>) this._listDataHeaderOriginal.clone();
            this._listDataChild = (HashMap<String, ArrayList<ViewTimesModel>>) this
                    ._listDataChildOriginal.clone();
        } else {

            for (HashMap proyect : this._listDataHeaderOriginal) {
                ArrayList<ViewTimesModel> activityList = this._listDataChildOriginal.get(proyect
                        .get(Constants.ID).toString());

                DateFormat formatter = new SimpleDateFormat(Constants.YYYY_MM_DD);
                Date fechaList;
                String dateString;

                ArrayList<ViewTimesModel> newList = new ArrayList<>();
                for (ViewTimesModel activity : activityList) {


                    try {
                        dateString = activity.getFechaActividad();
                        fechaList = formatter.parse(dateString);
                        if (!query.isEmpty() && fecha != null) {
                            if ((activity.getDescripcion().toString().toLowerCase().contains
                                    (query) || activity.getCodigoActividad().toString()
                                    .toLowerCase().contains(query)) && (fechaList.getTime() >=
                                    fecha.get(0).getTime() && fechaList.getTime() <= fecha.get(1)
                                    .getTime())) {
                                newList.add(activity);
                            }


                        } else if (!query.isEmpty()) {
                            if ((activity.getDescripcion().toString().toLowerCase().contains
                                    (query) || activity.getCodigoActividad().toString()
                                    .toLowerCase().contains(query)) && (fechaList.getTime()
                                    >= fromDate.getTime() && fechaList.getTime() <= toDate
                                    .getTime())) {
                                newList.add(activity);
                            }

                        } else if (weekly) {
                            if (fechaList.getTime() >= fromDate.getTime() && fechaList
                                    .getTime() <= toDate.getTime()) {
                                newList.add(activity);
                            }
                        } else if (monthly) {
                            if (fechaList.getTime() >= fromDate.getTime() && fechaList
                                    .getTime() <= toDate.getTime()) {
                                newList.add(activity);
                            }
                        } else {
                            try {
                                dateString = activity.getFechaActividad();
                                fechaList = formatter.parse(dateString);
                                if (fechaList.getTime() >= fecha.get(0).getTime() &&
                                        fechaList.getTime() <= fecha.get(1).getTime()) {
                                    newList.add(activity);
                                }
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
                _listDataChild.put(proyect.get(Constants.ID).toString(), newList);
                if (newList.size() > 0) {
                    _listDataHeader.add(proyect);
                }
            }
        }

        notifyDataSetChanged();

    }

}