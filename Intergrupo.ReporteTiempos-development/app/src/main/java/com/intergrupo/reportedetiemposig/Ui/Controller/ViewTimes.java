package com.intergrupo.reportedetiemposig.Ui.Controller;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.intergrupo.reportedetiemposig.Helper.ExpandableListAdapter;
import com.intergrupo.reportedetiemposig.Helper.ShowAlertDialogValidateInternet;
import com.intergrupo.reportedetiemposig.Helper.ValidateInternet;
import com.intergrupo.reportedetiemposig.Model.App;
import com.intergrupo.reportedetiemposig.Model.ResumTimesForCollaborator;
import com.intergrupo.reportedetiemposig.Model.ViewTimesModel;
import com.intergrupo.reportedetiemposig.R;
import com.intergrupo.reportedetiemposig.Util.Constants;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.InjectView;

/**
 * Created by Usuario on 1/05/2016.
 */
public class ViewTimes extends AppCompatActivity {
    
    AlertDialog alertDialog;
    ProgressDialog progressDialog;
    ArrayList<HashMap> listProyects = new ArrayList<>();
    HashMap<String, ArrayList<ViewTimesModel>> activityCollection = new HashMap<>();
    
    List<ResumTimesForCollaborator> listResumTimesCollaborator = new ArrayList<>();
    List<ViewTimesModel> listTimesCollaborator = new ArrayList<>();
    
    Integer currentWeek = null;
    Integer currentMonth = null;
    HashMap<Integer, Double> totalWeek = new HashMap<>();
    HashMap<Integer, Double> totalMonth = new HashMap<>();
    
    ExpandableListAdapter expandableListAdapter;
    
    Boolean monthly = false;
    Boolean weekly = true;
    ArrayList<Date> dateFilter = null;
    
    @InjectView(R.id.tvByReport)
    TextView tvByReport;
    
    @InjectView(R.id.tvReported)
    TextView tvReported;
    
    
    @InjectView(R.id.containerListView)
    RelativeLayout containerListView;
    
    @InjectView(R.id.elvProyects)
    ExpandableListView elvProyects;
    
    @InjectView(R.id.linear_byDate)
    LinearLayout linerByDate;
    
    @InjectView(R.id.linear_weekly)
    LinearLayout linear_weekly;
    
    @InjectView(R.id.linear_monthly)
    LinearLayout linear_monthly;
    
    String userCode;
    ValidateInternet validateInternet = new ValidateInternet(this);
    Integer numberWeek;
    Integer numberMonth;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_times);
        
        initializeVisualElements();
    }
    
    private void initializeVisualElements() {
        userCode = getIntent().getStringExtra(Constants.USER_CODIGO);
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setMessage(Constants.POR_FAVOR_ESPERE);
        this.progressDialog.setCancelable(false);
        
        ButterKnife.inject(this);
        
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    
    
    public void onResume() {
        super.onResume();
        if (validateInternet.isConnected()) {
            getProyectsList(userCode, true);
        } else {
            ShowAlertDialogValidateInternet.showAlertDialogValidateInternet(R.string
                            .apreciado_usuario, R.string.por_favor_valide_su_conexion_a_internet,
                    ViewTimes.this);
        }
        
    }
    
    /**
     * Método encargado de establecer la opcion de busqueda
     * representada como una lupa en la parte superior derecha
     * de la actividad.
     *
     * @param menu Objeto de tipo Menu al que se le asignara
     *             la opción de busqueda.
     */
    
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view_times, menu);
        
        MenuItem searchItem = menu.findItem(R.id.search);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        
        MenuItemCompat menuItem = new MenuItemCompat();
        
        SearchView searchView = (SearchView) menuItem.getActionView(searchItem);
        
        // LISTENER PARA EL EDIT TEXT DE LA BUSQUEDA
        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    if (expandableListAdapter != null)
                        expandableListAdapter.filterData(query, dateFilter, weekly, monthly);
                    return false;
                }
                
                @Override
                public boolean onQueryTextChange(String newText) {
                    if (expandableListAdapter != null)
                        expandableListAdapter.filterData(newText, dateFilter, weekly, monthly);
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
     * Método que obtiene la lista de proyectos con sus
     * respectivas horas reportadas asociados al colaborador en sesion,
     * adicionalmente ordena la lista mencionada anteriormente para su
     * visualizacion.
     *
     * @param userCode Codigo del colaborar.
     * @param update   Booleano para limpiar la informacion y que esta no se
     *                 duplique en caso de haber regresado de una edicion.
     */
    public void getProyectsList(final String userCode, final Boolean update) {
        if (update) {
            listProyects.clear();
            activityCollection.clear();
            expandableListAdapter = null;
        }
        progressDialog.show();
        Thread thread = new Thread() {
            @Override
            public void run() {
                listTimesCollaborator = App.getInstance().GetViewTimesForCollaborator(userCode);
                
                if (listTimesCollaborator == null) {
                    showProyects(false, Constants.MESSAGE_ERROR_GET_TIMES, update);
                } else {
                    
                    if (listTimesCollaborator.size() > 0) {
                        
                        activityCollection = new HashMap<>();
                        Collections.sort(listTimesCollaborator, new Comparator<ViewTimesModel>() {
                            @Override
                            public int compare(ViewTimesModel lhs, ViewTimesModel rhs) {
                                return new Integer(rhs.getCodigoProyecto()).compareTo(new Integer
                                        (lhs.getCodigoProyecto()));
                            }
                        });
                        
                        Integer idProyect = null;
                        Integer idNextProyect;
                        Double sumHours = 0d;
                        ArrayList<HashMap> listProyect = new ArrayList<HashMap>();
                        HashMap<String, Object> proyectMap = new HashMap<>();
                        ;
                        Integer i = 0;
                        
                        ArrayList<ViewTimesModel> timeReportedxProyect = new
                                ArrayList<ViewTimesModel>();
                        //TODO: era un if anidado dentro del otro... entonces se simplificó a uno
                        //TODO: solo con un AND
                        if (listTimesCollaborator.size() == 1 && listTimesCollaborator.get(0).getProyectoActivo()) {
                                proyectMap.put(Constants.ID, listTimesCollaborator.get(0)
                                        .getCodigoProyecto());
                                proyectMap.put(Constants.PROYECT, listTimesCollaborator.get(0)
                                        .getNombreProyecto());
                                proyectMap.put(Constants.TIME, listTimesCollaborator.get(0)
                                        .getHoras());
                                listProyect.add(proyectMap);
                                timeReportedxProyect.add(listTimesCollaborator.get(0));
                                activityCollection.put(listTimesCollaborator.get(0)
                                        .getCodigoProyecto().toString(), timeReportedxProyect);
                            
                        } else {
                            for (ViewTimesModel proyect : listTimesCollaborator) {
                                if (!proyect.getProyectoActivo()) {
                                    i += 1;
                                    continue;
                                }
                                proyectMap = new HashMap<>();
                                if (idProyect == null) {
                                    timeReportedxProyect.add(proyect);
                                    idProyect = proyect.getCodigoProyecto();
                                    sumHours += proyect.getHoras();
                                    try {
                                        idNextProyect = listTimesCollaborator.get(i + 1)
                                                .getCodigoProyecto();
                                    } catch (Exception e) {
                                        idNextProyect = null;
                                    }
                                    
                                    if (!idProyect.equals(idNextProyect)) {
                                        listProyect.add(getProyectMapData(proyectMap, proyect,
                                                sumHours));
                                        activityCollection.put(proyect.getCodigoProyecto()
                                                .toString(), timeReportedxProyect);
                                        sumHours = 0d;
                                        timeReportedxProyect = new ArrayList<>();
                                    }
                                    continue;
                                } else {
                                    i += 1;
                                    if (idProyect.equals(proyect.getCodigoProyecto())) {
                                        sumHours += proyect.getHoras();
                                        timeReportedxProyect.add(proyect);
                                        try {
                                            idNextProyect = listTimesCollaborator.get(i + 1)
                                                    .getCodigoProyecto();
                                        } catch (Exception e) {
                                            idNextProyect = null;
                                        }
                                        
                                        if (!idProyect.equals(idNextProyect)) {
                                            listProyect.add(getProyectMapData(proyectMap,
                                                    proyect, sumHours));
                                            activityCollection.put(proyect.getCodigoProyecto()
                                                    .toString(), timeReportedxProyect);
                                            sumHours = 0d;
                                            timeReportedxProyect = new ArrayList<>();
                                        }
                                    } else {
                                        idProyect = proyect.getCodigoProyecto();
                                        sumHours += proyect.getHoras();
                                        timeReportedxProyect.add(proyect);
                                        try {
                                            idNextProyect = listTimesCollaborator.get(i + 1)
                                                    .getCodigoProyecto();
                                        } catch (Exception e) {
                                            idNextProyect = null;
                                        }
                                        
                                        if (!idProyect.equals(idNextProyect)) {
                                            listProyect.add(getProyectMapData(proyectMap,
                                                    proyect, sumHours));
                                            activityCollection.put(proyect.getCodigoProyecto()
                                                    .toString(), timeReportedxProyect);
                                            sumHours = 0d;
                                            timeReportedxProyect = new ArrayList<>();
                                        }
                                        
                                    }
                                }
                                
                                
                            }
                        }
                        listProyects.addAll(listProyect);
                        showProyects(true, null, update);
                    } else {
                        listProyects = null;
                        showProyects(false, Constants.MESSAGE_COLLABORATOR_WITHOUT_TIMES, update);
                    }
                }
            }
        };
        thread.start();
    }
    
    private HashMap getProyectMapData(HashMap<String, Object> proyectMapMethod, ViewTimesModel
            proyectName, Double sumHoursMethod) {
        proyectMapMethod.put(Constants.ID, proyectName.getCodigoProyecto());
        proyectMapMethod.put(Constants.PROYECT, proyectName.getNombreProyecto());
        proyectMapMethod.put(Constants.TIME, sumHoursMethod);
        
        return proyectMapMethod;
    }
    
    
    /**
     * Método encargado de establecer las listas de los proyectos
     * con sus respectivos reportes en la actividad.
     *
     * @param correct Booleano que determina si las listas mencionadas
     *                en la descripcion se construyeron correctamente.
     * @param error   mensaje de error para mostrar si el parametro anterior
     *                es negativo.
     * @param update  Booleano que determina si se acaba de volver de una
     *                actualizacion.
     */
    private void showProyects(final Boolean correct, final String error, final Boolean update) {
        try {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (correct) {
                        ExpandableListView expandableListView = (ExpandableListView) findViewById
                                (R.id.elvProyects);
                        expandableListAdapter = new ExpandableListAdapter(ViewTimes.this,
                                listProyects, activityCollection);
                        expandableListView.setAdapter(expandableListAdapter);
                        expandableListAdapter.filterData(new String(), null, weekly, monthly);
                        
                    } else {
                        if (update) {
                            ExpandableListView expandableListView = (ExpandableListView)
                                    findViewById(R.id.elvProyects);
                            expandableListAdapter = new ExpandableListAdapter(ViewTimes.this, new
                                    ArrayList<HashMap>(), new HashMap<String,
                                    ArrayList<ViewTimesModel>>());
                            expandableListView.setAdapter(expandableListAdapter);
                        }
                        
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder
                                (ViewTimes.this);
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
                    getResumTimes(userCode);
                    
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        progressDialog.dismiss();
    }
    
    /**
     * Método que obtiene la sumatoria de los reportes de la
     * ultima semana y del ultimo mes y posteriormente los
     * reorganiza.
     *
     * @param userCode Codigo del colaborar.
     */
    public void getResumTimes(final String userCode) {
        
        Thread thread = new Thread() {
            @Override
            public void run() {
                listResumTimesCollaborator = App.getInstance().GetResumTimesForCollaborator
                        (userCode);
                if (listResumTimesCollaborator != null) {
                    Collections.sort(listResumTimesCollaborator, new
                            Comparator<ResumTimesForCollaborator>() {
                                @Override
                                public int compare(ResumTimesForCollaborator lhs,
                                                   ResumTimesForCollaborator rhs) {
                                    return new Integer(rhs.getSemana()).compareTo(new Integer(lhs
                                            .getSemana()));
                                }
                            });
                    Calendar calendarioActual = new GregorianCalendar();
                    numberWeek = calendarioActual.get(Calendar.WEEK_OF_YEAR);
                    if (calendarioActual.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        numberWeek--;
                    }
                    numberMonth = calendarioActual.get(Calendar.MONTH) + 1;
                    totalWeek = new HashMap<>();
                    Double sum;
                    
                    for (ResumTimesForCollaborator resumeTime : listResumTimesCollaborator) {
                        
                        sum = resumeTime.getLunes() + resumeTime.getMartes() + resumeTime
                                .getMiercoles() + resumeTime.getJueves() + resumeTime.getViernes
                                () + resumeTime.getSabado() + resumeTime.getDomingo();
                        
                        if (currentWeek == null) {
                            currentWeek = resumeTime.getSemana();
                        }
                        if (totalWeek.containsKey(resumeTime.getSemana())) {
                            Double last = totalWeek.get(resumeTime.getSemana());
                            totalWeek.put(resumeTime.getSemana(), last + sum);
                        } else {
                            totalWeek.put(resumeTime.getSemana(), sum);
                        }
                        if (currentMonth == null) {
                            currentMonth = resumeTime.getMes();
                        }
                        
                        if (totalMonth.containsKey(resumeTime.getMes())) {
                            Double last = totalMonth.get(resumeTime.getMes());
                            totalMonth.put(resumeTime.getMes(), last + sum);
                        } else {
                            totalMonth.put(resumeTime.getMes(), sum);
                        }
                        
                    }
                    
                    resumTimesFinish();
                }
            }
        };
        thread.start();
    }
    
    /**
     * Método que finaliza el hilo iniciado en el metodo
     * "getResumTimes" y oculta el mensaje de carga
     */
    public void resumTimesFinish() {
        try {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                    WeeklyInfo();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    /**
     * Metodo que establece resumen de horas reportadas semanalmente
     * en la parte superior de la actividad
     */
    @OnClick(R.id.linear_weekly)
    public void WeeklyInfo() {
        
        linear_weekly.setBackgroundColor(getResources().getColor(R.color.gray));
        linear_monthly.setBackground(getResources().getDrawable(R.drawable.border));
        linerByDate.setBackground(getResources().getDrawable(R.drawable.border));
        
        if (numberWeek != null && totalWeek != null && totalWeek.get(numberWeek) != null) {
            
            Double byReported = 45d - totalWeek.get(numberWeek);
            tvByReport.setText(byReported < 0 ? "0" : byReported.toString());
            tvReported.setText(totalWeek.get(numberWeek).toString());
        } else {
            tvByReport.setText(R.string.cuarenta_y_cinco);
            tvReported.setText(R.string.cero);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ViewTimes.this);
            alertDialogBuilder.setTitle(R.string.advertencia);
            alertDialogBuilder.setMessage(Constants.MESSAGE_COLLABORATOR_WITHOUT_TIMES);
            alertDialogBuilder.setPositiveButton(R.string.aceptar, new DialogInterface
                    .OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialogBuilder.show();
        }
        weekly = true;
        monthly = false;
        dateFilter = null;
        if (expandableListAdapter != null) {
            expandableListAdapter.filterData("", null, weekly, monthly);
        }
        
        
    }
    
    /**
     * Metodo que establece resumen de horas reportadas mensualmente
     * en la parte superior de la actividad
     */
    @OnClick(R.id.linear_monthly)
    public void MonthlyInfo() {
        
        linear_weekly.setBackground(getResources().getDrawable(R.drawable.border));
        linear_monthly.setBackgroundColor(getResources().getColor(R.color.gray));
        linerByDate.setBackground(getResources().getDrawable(R.drawable.border));
        if (numberMonth != null && totalMonth.get(numberMonth) != null) {
            Double byReported = 180d - totalMonth.get(numberMonth);
            tvByReport.setText(byReported < 0 ? "0" : byReported.toString());
            tvReported.setText(totalMonth.get(numberMonth).toString());
        } else {
            tvByReport.setText(R.string.ciento_ochenta);
            tvReported.setText(R.string.cero);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ViewTimes.this);
            alertDialogBuilder.setTitle(R.string.advertencia);
            alertDialogBuilder.setMessage(Constants.MESSAGE_COLLABORATOR_WITHOUT_TIMES);
            alertDialogBuilder.setPositiveButton(R.string.aceptar, new DialogInterface
                    .OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialogBuilder.show();
        }
        weekly = false;
        monthly = true;
        dateFilter = null;
        if (expandableListAdapter != null) {
            expandableListAdapter.filterData("", null, weekly, monthly);
        }
        
    }
    
    /**
     * Metodo encargado de mostrar los calendarios para
     * filtrar los reportes por un rango de fechas especifico.
     */
    @OnClick(R.id.linear_byDate)
    public void DateInfo() {
        linear_weekly.setBackground(getResources().getDrawable(R.drawable.border));
        linear_monthly.setBackground(getResources().getDrawable(R.drawable.border));
        linerByDate.setBackgroundColor(getResources().getColor(R.color.gray));
        
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int
                            dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
                        Date startDate = new Date(year - 1900, monthOfYear, dayOfMonth);
                        Date finishDate = new Date(yearEnd - 1900, monthOfYearEnd, dayOfMonthEnd);
                        weekly = false;
                        monthly = false;
                        if (startDate.getTime() > finishDate.getTime()) {
                            Toast.makeText(ViewTimes.this, Constants.MESSAGE_USER_DATE_LESS,
                                    Toast.LENGTH_LONG).show();
                        } else {
                            dateFilter = new ArrayList<Date>();
                            dateFilter.add(startDate);
                            dateFilter.add(finishDate);
                            expandableListAdapter.filterData("", dateFilter, weekly,
                                    monthly);
                        }
                        
                    }
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setAccentColor(getResources().getColor(R.color.colorPrimary));
        dpd.show(getFragmentManager(), Constants.DATE_PICKER_DIALOG);
        dpd.setStartTitle(Constants.FROM);
        dpd.setEndTitle(Constants.to);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(Calendar.WEEK_OF_YEAR, -2);
        dpd.setMinDate(gregorianCalendar);
    }
    
    public void EditTime(ViewTimesModel activity) {
        Intent intent = new Intent(ViewTimes.this, register.class);
        intent.putExtra(Constants.TIMES, activity);
        startActivity(intent);
    }
    
    /**
     * Metodo encargado de mostrar un mensaje de confirmacion al tratar de
     * eliminar un registro de tiempo.
     *
     * @param activity contexto de la actividad ya que este metodo es llamado por
     *                 reflection.
     */
    public void ConfirmationDeleteTime(final ViewTimesModel activity) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ViewTimes.this);
        alert.setTitle(Constants.TITLE_DELETE_TIME);
        alert.setMessage(Constants.DELETE_CONFIRMATION_MESSAGE);
        alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            
            public void onClick(DialogInterface dialog, int whichButton) {
                alertDialog.dismiss();
                ProgressDialog progressDialogdelete = new ProgressDialog(ViewTimes.this);
                progressDialogdelete.show();
                DeleteTime(activity, progressDialogdelete);
                
            }
        });
        alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            
            public void onClick(DialogInterface dialog, int whichButton) {
                alertDialog.dismiss();
                
            }
        });
        alertDialog = alert.create();
        alertDialog.show();
    }
    
    /**
     * Metodo encargado de eliminar un reporte de tiempos luego de
     * confirmar este.
     *
     * @param activity             contexto de la actividad entregado por el metodo
     *                             "ConfirmationDeleteTime"
     * @param progressDialogdelete instancia del progress.
     */
    public void DeleteTime(final ViewTimesModel activity, final ProgressDialog
            progressDialogdelete) {
        
        Thread thread = new Thread() {
            @Override
            public void run() {
                Boolean delete = true;
                try {
                    
                    HashMap<String, ArrayList<HashMap>> timeToDeleted = new HashMap();
                    ArrayList codes = new ArrayList();
                    HashMap activityCode = new HashMap();
                    activityCode.put(Constants.CODIGO, activity.getCodigoActividad());
                    
                    codes.add(activityCode);
                    timeToDeleted.put(Constants.CODIGOS, codes);
                    
                    
                    delete = App.getInstance().DeleteTimes(timeToDeleted);
                } catch (Exception e) {
                    e.printStackTrace();
                    delete = false;
                }
                ConfirmDeletedTimes(delete, progressDialogdelete);
                
                
            }
        };
        thread.start();
    }
    
    /**
     * Metodo encargado de informar si el reporte se elimino correctamente.
     *
     * @param delete               Booleano que determina si la eliminacion del
     *                             reporte se realizo con exito o no
     * @param progressDialogdelete instancia del progress.
     */
    public void ConfirmDeletedTimes(final Boolean delete, final ProgressDialog
            progressDialogdelete) {
        try {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressDialogdelete.dismiss();
                    if (delete) {
                        Toast.makeText(ViewTimes.this, Constants.DELETED_TIME, Toast.LENGTH_LONG)
                                .show();
                        getProyectsList(userCode, true);
                    } else {
                        Toast.makeText(ViewTimes.this, R.string.error_eliminando_tiempo, Toast
                                .LENGTH_LONG).show();
                    }
                    
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void FilterByDate(String date) {
        try {
            DateFormat formatter = new SimpleDateFormat(Constants.DD_MM_YYYY);
            Date fecha = formatter.parse(date);
            if (expandableListAdapter != null) {
                weekly = false;
                monthly = false;
                dateFilter.add(fecha);
                expandableListAdapter.filterData("", dateFilter, weekly, monthly);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
