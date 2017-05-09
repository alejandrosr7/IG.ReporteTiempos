package com.intergrupo.reportedetiemposig.Ui.Controller;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.intergrupo.reportedetiemposig.Helper.CustomAlertdialog;
import com.intergrupo.reportedetiemposig.Ui.Controller.Adapters.ExpandableListDetailAdapter;
import com.intergrupo.reportedetiemposig.Helper.IValidateInternet;
import com.intergrupo.reportedetiemposig.Helper.SecurePreferences;
import com.intergrupo.reportedetiemposig.Helper.ValidateInternet;
import com.intergrupo.reportedetiemposig.App;
import com.intergrupo.reportedetiemposig.Model.ViewTimesManagerDetail;
import com.intergrupo.reportedetiemposig.R;
import com.intergrupo.reportedetiemposig.Util.Constants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ViewTimesManagerDetailActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private SecurePreferences manager;
    private ExpandableListDetailAdapter expandableListDetailAdapter;
    private ArrayList<ViewTimesManagerDetail> listDetail;
    private ExpandableListView expandableListView;
    private String usercode;
    private IValidateInternet iValidateInternet;
    private CustomAlertdialog customAlertdialog;

    @InjectView(R.id.linear_byDateDetail)
    LinearLayout linear_byDateDetail;
    @InjectView(R.id.linear_weeklyDetail)
    LinearLayout linear_weeklyDetail;
    @InjectView(R.id.linear_monthlyDetail)
    LinearLayout linear_monthlyDetail;
    
    private String userName;


    /**
     * Created by LeidyZuluaga on 13/06/16.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_times_manager_detail);
        customAlertdialog = new CustomAlertdialog();
        initializeVisualElements();

    }

    private void initializeVisualElements() {
        expandableListView = (ExpandableListView) findViewById(R.id.elvCollaborator);
        listDetail = new ArrayList<>();
        expandableListDetailAdapter = new ExpandableListDetailAdapter(this, listDetail);
        expandableListView.setAdapter(expandableListDetailAdapter);
        ButterKnife.inject(this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        progressDialog = new ProgressDialog(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarDetail);
        toolbar.setTitle(R.string.por_colaborador);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        manager = new SecurePreferences(this);
        userName = manager.getString(Constants.USER_NAME);
        usercode = manager.getString(Constants.USER_CODIGO);
        iValidateInternet = new ValidateInternet(ViewTimesManagerDetailActivity.this);
        week();
    }

    /**
     * Método que obtiene la lista de los colaboradores
     * y las horas según el tipo de hora
     *
     * @param idManager  código unico del gerente
     * @param startDate  fecha de inicio para el filtro
     * @param finishDate fecha fin para el filtro
     * @param update     boolean para actualizar la lista
     */
    public void getListDetail(final String idManager, final Date startDate, final Date
            finishDate, final Boolean update) {
        showProgressDialog(Constants.POR_FAVOR_ESPERE);
        Thread thread = new Thread() {
            @Override
            public void run() {
                if (iValidateInternet.isConnected()) {
                    listDetail = (ArrayList<ViewTimesManagerDetail>) App.getInstance()
                            .GetTimesManagerDetail(idManager, startDate, finishDate);
                    if (listDetail == null) {
                        showsublistManager(false, Constants.MESSAGE_ERROR_GET_TIMES, update);
                    } else {

                        if (listDetail.size() > 0) {
                            showsublistManager(true, "", update);
                        } else {
                            listDetail = null;
                            showsublistManager(false, Constants.MESSAGE_MANAGER_WITHOUT_TIMES,
                                    update);
                        }
                    }
                } else {
                    progressDialog.dismiss();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            customAlertdialog.showAlertDialogValidateInternet(userName, R.string
                                            .por_favor_valide_su_conexion_a_internet,
                                    ViewTimesManagerDetailActivity.this);

                        }
                    });
                }

            }


        };
        thread.start();
    }

    /**
     * Método que actualiza el adapter de la lista para
     * mostrar los colaboradores y los reportes según el tipo de horas
     *
     * @param correct boolean que permite mostrar la lista
     * @param error   mensaje para mostrar cuando ha ocurrido un error
     * @param update  boolean que permite actualizar la lista
     */
    public void showsublistManager(final Boolean correct, final String error, final Boolean update) {

        try {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressDialog.cancel();
                    progressDialog.dismiss();
                    if (correct) {
                        ExpandableListView expandableListView = (ExpandableListView) findViewById
                                (R.id.elvCollaborator);
                        expandableListDetailAdapter = new ExpandableListDetailAdapter
                                (ViewTimesManagerDetailActivity.this, listDetail);
                        expandableListView.setAdapter(expandableListDetailAdapter);

                    } else {
                        if (update) {
                            ExpandableListView expandableListView = (ExpandableListView)
                                    findViewById(R.id.elvCollaborator);
                            expandableListDetailAdapter = new ExpandableListDetailAdapter
                                    (ViewTimesManagerDetailActivity.this, new
                                            ArrayList<ViewTimesManagerDetail>());
                            expandableListView.setAdapter(expandableListDetailAdapter);
                        }
                        displayAlertDialog(error);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayAlertDialog(String error) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder
                (ViewTimesManagerDetailActivity.this);
        alertDialogBuilder.setTitle(R.string.advertencia);
        alertDialogBuilder.setMessage(error);
        alertDialogBuilder.setPositiveButton(R.string.aceptar, new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialogBuilder.show();
    }

    /**
     * Método que retorna un Calendar con la fechaa que le envían
     *
     * @param date Date que contiene una fecha
     * @return cal retorna fecha
     */
    public Calendar dateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     * Método que permite ejecutar el filtro semanal
     */
    @OnClick(R.id.linear_weeklyDetail)
    public void week() {

        linear_weeklyDetail.setBackgroundColor(getResources().getColor(R.color.gray));
        linear_monthlyDetail.setBackground(getResources().getDrawable(R.drawable.border));
        linear_byDateDetail.setBackground(getResources().getDrawable(R.drawable.border));

        Calendar calendar = dateToCalendar(new Date());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        Date startdate1 = calendar.getTime();

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        Date finishtdate1 = calendar.getTime();
        getListDetail(usercode, startdate1, finishtdate1, true);

    }

    /**
     * Método que permite ejecutar el filtro mensual
     */
    @OnClick(R.id.linear_monthlyDetail)
    public void month() {
        linear_weeklyDetail.setBackground(getResources().getDrawable(R.drawable.border));
        linear_monthlyDetail.setBackgroundColor(getResources().getColor(R.color.gray));
        linear_byDateDetail.setBackground(getResources().getDrawable(R.drawable.border));
        Calendar calendar = dateToCalendar(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

        Date startdate1 = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date finishtdate1 = calendar.getTime();
        getListDetail(usercode, startdate1, finishtdate1, true);


    }

    /**
     * Método que permite ejecutar el filtro
     * por rango de fechas
     */
    @OnClick(R.id.linear_byDateDetail)
    public void byDate() {

        linear_weeklyDetail.setBackground(getResources().getDrawable(R.drawable.border));
        linear_monthlyDetail.setBackground(getResources().getDrawable(R.drawable.border));
        linear_byDateDetail.setBackgroundColor(getResources().getColor(R.color.gray));
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int
                            dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
                        Date startDate = new Date(year - 1900, monthOfYear, dayOfMonth);
                        Date finishDate = new Date(yearEnd - 1900, monthOfYearEnd, dayOfMonthEnd);
                        getListDetail(usercode, startDate, finishDate, true);

                    }
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setAccentColor(getResources().getColor(R.color.colorPrimary));
        dpd.show(getFragmentManager(), Constants.DATE_PICKER_DIALOG);
    }

    /**
     * Método que permite inflar el toolbar para
     * ejecutar el filtro por palabra
     *
     * @param menu Menu a inflar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view_times, menu);

        MenuItem searchItem = menu.findItem(R.id.search);

        MenuItemCompat menuItem = new MenuItemCompat();


        SearchView searchView = (SearchView) menuItem.getActionView(searchItem);

        // LISTENER PARA EL EDIT TEXT
        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    if (expandableListDetailAdapter != null)
                        expandableListDetailAdapter.filterSearchDetail(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    if (expandableListDetailAdapter != null)
                        expandableListDetailAdapter.filterSearchDetail(newText);
                    return false;
                }
            });
        }

        // LISTENER PARA LA APERTURA Y CIERRE DEL WIDGET
        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat
                .OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Método que permite mostrar un progress dialog
     * con un mensaje
     *
     * @param message String que contiene el mensaje
     *                a mostrar
     */
    public void showProgressDialog(String message) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
}
