package com.intergrupo.reportedetiemposig.Helper;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.intergrupo.reportedetiemposig.Model.ViewTimesModel;
import com.intergrupo.reportedetiemposig.R;
import com.intergrupo.reportedetiemposig.Ui.Controller.ViewTimes;

import java.lang.reflect.Method;
import java.util.Calendar;

import butterknife.InjectView;


@SuppressLint("ValidFragment")
public class DateDialogByDate extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @InjectView(R.id.linear_byDate)
    LinearLayout linear_byDate;
    View v;

    String dateSelected = new String();
    public DateDialogByDate(View view){
        linear_byDate=(LinearLayout) view;
        v = view;
    }
    public Dialog onCreateDialog(Bundle savedInstanceState) {


// Use the current date as the default date in the dialog
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        // Create a new instance of DatePickerDialog and return it
//        dateSelected.setText(day+"/"+month+"/"+"/"+year);

        return new DatePickerDialog(getActivity(), this, year, month, day);

    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        //show to the selected date in the text box
        String date=day+"-"+(month+1)+"-"+year;
        dateSelected = date;
        Class[] listClass = new Class[1];
        listClass[0] = String.class;
        try {
            Method MethodPrueba = ViewTimes.class.getMethod("FilterByDate", listClass );
            MethodPrueba.invoke(v.getContext(), dateSelected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
