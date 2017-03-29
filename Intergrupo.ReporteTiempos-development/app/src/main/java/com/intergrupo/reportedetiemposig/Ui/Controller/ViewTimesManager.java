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
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.intergrupo.reportedetiemposig.Helper.ExpandableListAdapterM;
import com.intergrupo.reportedetiemposig.Helper.IValidateInternet;
import com.intergrupo.reportedetiemposig.Helper.SecurePreferences;
import com.intergrupo.reportedetiemposig.Helper.ShowAlertDialogValidateInternet;
import com.intergrupo.reportedetiemposig.Helper.ValidateInternet;
import com.intergrupo.reportedetiemposig.Model.App;
import com.intergrupo.reportedetiemposig.Model.TimesForManager;
import com.intergrupo.reportedetiemposig.Model.TimesForManagerParent;
import com.intergrupo.reportedetiemposig.R;
import com.intergrupo.reportedetiemposig.Util.Constants;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class ViewTimesManager extends AppCompatActivity {
    ProgressDialog progressDialog;
    SecurePreferences manager;
    ExpandableListAdapterM expandableListAdapterM;
    ArrayList<TimesForManager> listTimesGerent;

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    ArrayList<TimesForManagerParent> expandableListTitle;
    HashMap<String, ArrayList<TimesForManager>> expandableListDetail;
    IValidateInternet iValidateInternet;
    String usercode;
    @InjectView(R.id.linear_weeklyg)
    LinearLayout linear_weekyg;
    @InjectView(R.id.linear_monthlyg)
    LinearLayout linear_monthlyg;
    @InjectView(R.id.linear_byDate)
    LinearLayout linear_bydate;

    @Override

    /**
     * Created by LeidyZuluaga on 24/05/16.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_view_times_manager);

        initializeVisualElementsAndResources();
    }

    private void initializeVisualElementsAndResources() {
        expandableListView = (ExpandableListView) findViewById(R.id.elvProyectg);
        expandableListDetail = new HashMap<>();
        expandableListTitle = new ArrayList<>();
        expandableListAdapter = new ExpandableListAdapterM(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        ButterKnife.inject(this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        progressDialog = new ProgressDialog(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarM);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        iValidateInternet = new ValidateInternet(ViewTimesManager.this);
        manager = new SecurePreferences(this);
        usercode = manager.getString(Constants.USER_CODIGO);
        week();
    }

    /**
     * Método que permite ir atrás
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * Método que obtiene la lista de proyectos asociados a un gerente
     * y muestra el proyecto y el detalle son los colaboradores
     *
     * @param idManager  código unico del gerente
     * @param startDate  fecha de inicio para el filtro
     * @param finishDate fecha fin para el filtro
     * @param update     boolean para actualizar la lista
     */
    public void getlistManager(final String idManager, final Date startDate, final Date finishDate, final Boolean update) {
        showProgressDialog(Constants.POR_FAVOR_ESPERE);
        Thread thread = new Thread() {
            @Override
            public void run() {
                if (iValidateInternet.isConnected()) {
                    listTimesGerent = (ArrayList<TimesForManager>) App.getInstance().GetTimesForManager(idManager, startDate, finishDate);

                    if (listTimesGerent == null) {
                        showSublistManager(false, Constants.MESSAGE_ERROR_GET_TIMES, update);


                    } else {

                        if (listTimesGerent.size() > 0) {

                            HashMap<String, ArrayList<TimesForManager>> list = new HashMap<>();
                            HashMap<String, TimesForManagerParent> proyectGMap = new HashMap<>();
                            for (TimesForManager collaborator : listTimesGerent) {
                                if (proyectGMap.containsKey(collaborator.getProyectName())) {

                                    TimesForManagerParent tfgp = proyectGMap.get(collaborator.getProyectName());

                                    tfgp.addTimesGreen(collaborator.getHourActivity());


                                } else {

                                    TimesForManagerParent timesForManagerParent = new TimesForManagerParent();
                                    timesForManagerParent.setProyectM(collaborator.getProyectName());
                                    timesForManagerParent.setTimesRed(collaborator.getRedTime());
                                    timesForManagerParent.addTimesGreen(collaborator.getHourActivity());
                                    proyectGMap.put(collaborator.getProyectName(), timesForManagerParent);

                                }

                                if (list.containsKey(collaborator.getProyectName())) {

                                    List<TimesForManager> list1 = list.get(collaborator.getProyectName());
                                    boolean found = false;
                                    for (TimesForManager collaboratoritem : list1) {
                                        String collaboratorname = collaboratoritem.getIdCollaboratorName() + "" + collaboratoritem.getIdCollaboratorLast();
                                        String collaboratorcopy = collaborator.getIdCollaboratorName() + "" + collaborator.getIdCollaboratorLast();
                                        if (collaboratorname.equals(collaboratorcopy)) {
                                            collaboratoritem.setHourActivity(collaboratoritem.getHourActivity() + collaborator.getHourActivity());
                                            found = true;
                                            break;
                                        }
                                    }
                                    if (!found) {
                                        list1.add(collaborator);
                                    }


                                } else {
                                    ArrayList<TimesForManager> list2 = new ArrayList<>();
                                    list2.add(collaborator);

                                    list.put(collaborator.getProyectName(), list2);


                                }
                            }
                            expandableListDetail = list;
                            expandableListTitle = new ArrayList<>(proyectGMap.values());
                            showSublistManager(true, "", update);


                        } else {
                            listTimesGerent = null;
                            showSublistManager(false, Constants.MESSAGE_MANAGER_WITHOUT_TIMES, update);
                        }
                    }

                } else {
                    progressDialog.dismiss();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ShowAlertDialogValidateInternet.showAlertDialogValidateInternet(R.string.apreciado_usuario, R.string.por_favor_valide_su_conexion_a_internet, ViewTimesManager.this);

                        }
                    });
                }
            }

        };

        thread.start();

    }

    /**
     * Método que actualiza el adapter de la lista para
     * mostrar los proyectos
     *
     * @param correct boolean que permite mostrar la lista
     * @param error   mensaje para mostrar cuando ha ocurrido un error
     * @param update  boolean que permite actualizar la lista
     */
    public void showSublistManager(final Boolean correct, final String error, final Boolean update) {

        try {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    progressDialog.cancel();
                    progressDialog.dismiss();
                    if (correct) {
                        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.elvProyectg);
                        expandableListAdapterM = new ExpandableListAdapterM(ViewTimesManager.this, expandableListTitle, expandableListDetail);
                        expandableListView.setAdapter(expandableListAdapterM);

                    } else {
                        if (update) {
                            ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.elvProyectg);
                            expandableListAdapterM = new ExpandableListAdapterM(ViewTimesManager.this, new ArrayList<TimesForManagerParent>(), new HashMap<String, ArrayList<TimesForManager>>());
                            expandableListView.setAdapter(expandableListAdapterM);
                        }
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ViewTimesManager.this);
                        alertDialogBuilder.setTitle(R.string.advertencia);
                        alertDialogBuilder.setMessage(error);
                        alertDialogBuilder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        alertDialogBuilder.show();
                    }
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
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
    @OnClick(R.id.linear_weeklyg)
    public void week() {

        linear_weekyg.setBackgroundColor(getResources().getColor(R.color.gray));
        linear_monthlyg.setBackground(getResources().getDrawable(R.drawable.border));
        linear_bydate.setBackground(getResources().getDrawable(R.drawable.border));

        Calendar calendar = dateToCalendar(new Date());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        Date startdate1 = calendar.getTime();

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        Date finishtdate1 = calendar.getTime();
        getlistManager(usercode, startdate1, finishtdate1, true);

    }

    /**
     * Método que permite ejecutar el filtro mensual
     */
    @OnClick(R.id.linear_monthlyg)
    public void month() {

        linear_weekyg.setBackground(getResources().getDrawable(R.drawable.border));
        linear_monthlyg.setBackgroundColor(getResources().getColor(R.color.gray));
        linear_bydate.setBackground(getResources().getDrawable(R.drawable.border));
        Calendar calendar = dateToCalendar(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

        Date startdate1 = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date finishtdate1 = calendar.getTime();
        getlistManager(usercode, startdate1, finishtdate1, true);

    }

    /**
     * Método que permite ejecutar el filtro
     * por rango de fechas
     */
    @OnClick(R.id.linear_byDate)
    public void byDate() {

        linear_weekyg.setBackground(getResources().getDrawable(R.drawable.border));
        linear_monthlyg.setBackground(getResources().getDrawable(R.drawable.border));
        linear_bydate.setBackgroundColor(getResources().getColor(R.color.gray));
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
                        Date startDate = new Date(year - 1900, monthOfYear, dayOfMonth);
                        Date finishDate = new Date(yearEnd - 1900, monthOfYearEnd, dayOfMonthEnd);
                        getlistManager(usercode, startDate, finishDate, true);

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
        getMenuInflater().inflate(R.menu.menu_view_times_manager, menu);

        MenuItem searchItem = menu.findItem(R.id.search);

        MenuItemCompat menuItem = new MenuItemCompat();

        SearchView searchView = (SearchView) menuItem.getActionView(searchItem);

        // LISTENER PARA EL EDIT TEXT
        if (searchView != null) {

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    if (expandableListAdapterM != null)
                        expandableListAdapterM.filterSearch(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    if (expandableListAdapterM != null)
                        expandableListAdapterM.filterSearch(newText);
                    return false;
                }
            });
        }

        // LISTENER PARA LA APERTURA Y CIERRE DEL WIDGET
        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
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

