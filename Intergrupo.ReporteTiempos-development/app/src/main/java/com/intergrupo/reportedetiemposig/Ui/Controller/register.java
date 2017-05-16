package com.intergrupo.reportedetiemposig.Ui.Controller;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.intergrupo.reportedetiemposig.Helper.CustomAlertdialog;
import com.intergrupo.reportedetiemposig.Helper.DialogSearch;
import com.intergrupo.reportedetiemposig.Helper.SecurePreferences;
import com.intergrupo.reportedetiemposig.Helper.ValidateInternet;
import com.intergrupo.reportedetiemposig.Helper.Validation;
import com.intergrupo.reportedetiemposig.Model.ActivityDiscipline;
import com.intergrupo.reportedetiemposig.App;
import com.intergrupo.reportedetiemposig.Helper.DateDialog;
import com.intergrupo.reportedetiemposig.Model.ClassificationConceptHour;
import com.intergrupo.reportedetiemposig.Model.ConceptHour;
import com.intergrupo.reportedetiemposig.Model.Discipline;
import com.intergrupo.reportedetiemposig.Model.Login;
import com.intergrupo.reportedetiemposig.Model.Manager;
import com.intergrupo.reportedetiemposig.Model.Proyect;
import com.intergrupo.reportedetiemposig.Model.ReportTime;
import com.intergrupo.reportedetiemposig.Model.ResumTimesForCollaborator;
import com.intergrupo.reportedetiemposig.Model.ViewTimesModel;
import com.intergrupo.reportedetiemposig.Model.functionality;
import com.intergrupo.reportedetiemposig.R;
import com.intergrupo.reportedetiemposig.Util.Constants;

import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class register extends AppCompatActivity {

    @InjectView(R.id.register_edManager)
    EditText editManager;

    @InjectView(R.id.register_edConceptHour)
    EditText editConceptoHour;

    @InjectView(R.id.register_edClassificationConceptHour)
    EditText editClassificationConceptHour;

    @InjectView(R.id.register_edProyect)
    EditText editProyect;

    @InjectView(R.id.register_edfunctionality)
    EditText editfunctionality;

    @InjectView(R.id.register_edDiscipline)
    EditText editDiscipline;

    @InjectView(R.id.register_edActivity)
    EditText editActivity;

    @InjectView(R.id.edDate)
    EditText edDate;

    @InjectView(R.id.edHour)
    EditText edHour;

    @InjectView(R.id.edDescrptionActivity)
    EditText edDescrptionActivity;

    @InjectView(R.id.btnReportar)
    Button buttonReportar;

    @InjectView(R.id.register_cbxActivity)
    CheckBox checkBoxActivity;


    private ProgressDialog progressDialog;
    private List<Manager> ManagerList;
    private List<ConceptHour> ConceptHourList;
    private List<ClassificationConceptHour> ClassificationConceptHourList;
    private List<Proyect> ProyectList;
    private List<functionality> functionalityList;
    private List<Discipline> DisciplineList;
    private List<ActivityDiscipline> activityList;
    private String codigoUsuario;
    private AlertDialog alertDialog;
    private Integer CodigoActividad;
    private Boolean edit = false;
    private ViewTimesModel viewTimesEdit;
    private ValidateInternet validateInternet = new ValidateInternet(this);
    private LayoutInflater layoutInflater;
    private CustomAlertdialog customAlertdialog;


    Boolean isAdministrative = false;
    Boolean showPopup = true;
    Boolean isUpdate = false;
    Boolean checkbox = false;
    private String userName;
//    Boolean showManagerPopUp = true;

    //Elementos para validar el maximo de horas reportados en una semana, esto luego se eliminara
    // o se mejorara.
    List<ResumTimesForCollaborator> listResumTimesCollaborator = new ArrayList<>();

    Integer currentWeek = null;
    HashMap<Integer, Double> totalWeek = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.inject(this);
        this.customAlertdialog = new CustomAlertdialog();
        initializeVisualElements();
    }


    /**
     * Método encargado de inicializar variables y de
     * añadir propiedades a las mismas una vez es iniciada
     * actividad por primera vez.
     */
    public void onStart() {
        super.onStart();
        editManager.setFocusable(false);
        editManager.setInputType(InputType.TYPE_NULL);

        editConceptoHour.setFocusable(false);
        editConceptoHour.setInputType(InputType.TYPE_NULL);

        editClassificationConceptHour.setFocusable(false);
        editClassificationConceptHour.setInputType(InputType.TYPE_NULL);

        editProyect.setFocusable(false);
        editProyect.setInputType(InputType.TYPE_NULL);

        editfunctionality.setFocusable(false);
        editfunctionality.setInputType(InputType.TYPE_NULL);

        editDiscipline.setFocusable(false);
        editDiscipline.setInputType(InputType.TYPE_NULL);

        editActivity.setFocusable(false);
        editActivity.setInputType(InputType.TYPE_NULL);

        edDescrptionActivity.setFocusable(false);
        edDescrptionActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LayoutInflater inflater = register.this.getLayoutInflater();
                final Window window = register.this.getWindow();
                customAlertdialog.showAlertDialogInputData(window, inflater, register.this, Constants.DESCRIPCION_DE_LA_ACTIVIDAD,
                        edDescrptionActivity, edDescrptionActivity.getText().toString(), 2000);
            }
        });

        edDate.setFocusable(false);
        edDate.setInputType(InputType.TYPE_NULL);
        edDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateDialog dialog = new DateDialog(v);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                dialog.show(ft, Constants.DATE_PICKER);
            }
        });
        DateFormat formatter = new SimpleDateFormat(Constants.DD_MM_YYYY);
        String fecha = formatter.format(new Date());
        edDate.setText(fecha);
    }


    /**
     * Método encargado de establecer informacion en los campos
     * del formulario ya sea por que se editara un reporte o por que
     * se mostrara la información del ultimo reporte
     */
    @Override
    protected void onResume() {
        super.onResume();
        try {
            viewTimesEdit = getIntent().getExtras() != null ? (ViewTimesModel) getIntent()
                    .getExtras().getParcelable(Constants.TIMES) : null;
            if (viewTimesEdit != null && viewTimesEdit.getCodigoActividad() != null) {
                if (validateInternet.isConnected()) {
                    CodigoActividad = viewTimesEdit.getCodigoActividad();
                    editManager.setText((viewTimesEdit.getNombreGerente() + " " + viewTimesEdit
                            .getApellidosGerente()).toUpperCase());
                    editConceptoHour.setText(viewTimesEdit.getNombreTipoHora());
                    editClassificationConceptHour.setText(viewTimesEdit.getNombreMaestroTipoHora());
                    editProyect.setText(viewTimesEdit.getNombreProyecto());
                    editfunctionality.setText(viewTimesEdit.getNombreFuncionalidad());
                    editDiscipline.setText(viewTimesEdit.getNombreMaestroProceso() + " - " +
                            viewTimesEdit.getNombreDisciplina());
                    editActivity.setText(viewTimesEdit.getNombreMaestroActividad());
                    checkBoxActivity.setChecked(viewTimesEdit.getActividadCompletada());
                    edDescrptionActivity.setText(viewTimesEdit.getDescripcion());
                    DateFormat formatter = new SimpleDateFormat(Constants.YYYY_MM_DD);
                    Date fecha = formatter.parse(viewTimesEdit.getFechaActividad());
                    SimpleDateFormat sdf = new SimpleDateFormat(Constants.DD_MM_YYYY);
                    edDate.setText(sdf.format(fecha));
                    edHour.setText(viewTimesEdit.getHoras().toString());
                    edit = true;
                    isUpdate = true;
                    showPopup = false;
                    if (!editConceptoHour.getText().toString().equals(Constants.ADMINISTRATIVA)) {
                        GetManager();
                    } else {
                        editDiscipline.setText(R.string.administrativo);
                        editActivity.setText(R.string.administrativo);
                        editManager.setText(R.string.todos_los_gerentes);
                        editfunctionality.setText(R.string.administrativo);
                        checkBoxActivity.setEnabled(false);
                    }
                    GetConceptHour();
                } else {
                    customAlertdialog.showAlertDialogValidateInternet(userName, R.string
                                    .por_favor_valide_su_conexion_a_internet,
                            register.this);
                }
            } else {
                FileInputStream lastReport = openFileInput(Constants.LAST_REPORT_TXT);
                InputStreamReader isr = new InputStreamReader(lastReport);

                char[] inputBuffer = new char[100];
                String s = "";

                int charRead;
                while ((charRead = isr.read(inputBuffer)) > 0) {
                    // Convertimos los char a String
                    String readString = String.copyValueOf(inputBuffer, 0, charRead);
                    s += readString;

                    inputBuffer = new char[100];
                }
                JSONObject reportJson = new JSONObject(s);

                if (reportJson != null && !reportJson.equals("")) {
                    if (validateInternet.isConnected()) {
                        if (reportJson.get(Constants.CODIGO_USUARIO).toString().equals
                                (codigoUsuario)) {
                            editManager.setText(reportJson.get(Constants.MANAGER).toString());
                            editConceptoHour.setText(reportJson.get(Constants.CONCEPT_HOUR)
                                    .toString());
                            editClassificationConceptHour.setText(reportJson.get(Constants
                                    .CLASSIFICATION_CONCEPT_HOUR).toString());
                            editProyect.setText(reportJson.get(Constants.PROYECT).toString());
                            editfunctionality.setText(reportJson.get(Constants.FUNCTIONALITY)
                                    .toString());
                            editDiscipline.setText(reportJson.get(Constants.DISCIPLINE).toString());
                            edDescrptionActivity.setText(reportJson.get(Constants.DESCRIPTION)
                                    .toString());
                            showPopup = false;
                            isUpdate = true;
                            isr.close();
                            if (!editConceptoHour.getText().toString().equals(Constants
                                    .ADMINISTRATIVA)) {
                                GetManager();
                            } else {
                                editDiscipline.setText(R.string.administrativo);
                                editActivity.setText(R.string.administrativo);
                                editManager.setText(R.string.todos_los_gerentes);
                                editfunctionality.setText(R.string.administrativo);
                                checkBoxActivity.setEnabled(false);
                            }
                            GetConceptHour();
                        }
                    } else {
                        customAlertdialog.showAlertDialogValidateInternet(userName, R.string
                                .por_favor_valide_su_conexion_a_internet, register.this);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initializeVisualElements() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setMessage(Constants.POR_FAVOR_ESPERE);
        this.progressDialog.setCancelable(false);
        SecurePreferences settings = new SecurePreferences(this);
        userName = settings.getString(Constants.USER_NAME);
        codigoUsuario = settings.getString(Constants.USER_CODIGO);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        editClassificationConceptHour.setInputType(InputType.TYPE_NULL);
        editProyect.setInputType(InputType.TYPE_NULL);
        editfunctionality.setInputType(InputType.TYPE_NULL);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        
        return super.onOptionsItemSelected(item);
    }


    /**
     * Método que obtiene la lista de clasificaciones de los conceptos de hora
     * segun el concepto de hora seleccionado
     */
    @OnClick(R.id.register_edClassificationConceptHour)
    public void GetClassificationConceptHour() {
        if (showPopup)
            progressDialog.show();
        int code = 0;
        final int codeTypeHour;
        String conceptHour = editConceptoHour.getText().toString();
        if (ConceptHourList != null) {
            for (Integer i = 0; i < ConceptHourList.size(); i++) {
                if (ConceptHourList.get(i).getName().equals(conceptHour)) {
                    code = ConceptHourList.get(i).getCodeTypeHour();
                }
            }
        }
        try {
            if (validateInternet.isConnected()) {
                codeTypeHour = code;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        ClassificationConceptHourList = App.getInstance()
                                .GetClassificationConceptHour(codeTypeHour);
                        SetClassificationConceptHour();
                    }
                };
                thread.start();
            } else {
                customAlertdialog.showAlertDialogValidateInternet(userName, R.string
                                .por_favor_valide_su_conexion_a_internet,
                        register.this);
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * Método que es llamado por "GetClassificationConceptHour" y este se encarga
     * de establecer la lista de clasificaciones de concepto de hora a la
     * ventana emergente donde se mostraran, para seleccionar de esta la clasificacion
     * deseada la cual se establece en el campo
     */
    private void SetClassificationConceptHour() {
        try {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (showPopup)
                        progressDialog.dismiss();

                    if (ClassificationConceptHourList != null && ClassificationConceptHourList
                            .size() > 0) {
                        final String[] proy = new String[ClassificationConceptHourList.size()];

                        for (Integer i = 0; i < ClassificationConceptHourList.size(); i++) {
                            proy[i] = ClassificationConceptHourList.get(i).getName();
                        }
                        if (!showPopup) {
                            // if(isUpdate)
                            // GetDiscipline();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                            builder.setTitle(Constants
                                    .REGISTER_TITLE_DIALOG_CLASIFICATION_CONCEPT_HOUR);
                            builder.setItems(proy, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    editClassificationConceptHour.setText(proy[which]);
                                }
                            });
                            builder.show();
                        }

                    } else {
                        showPopup(Constants.REGISTER_TITLE_DIALOG_CLASIFICATION_CONCEPT_HOUR,
                                Constants.MESSAGE_NO_FOUND_CLASIFICATION_CONCEPT_HOURS);
                    }


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que obtiene la lista de proyectos
     * segun el gerente seleccionado.
     */
    @OnClick(R.id.register_edProyect)
    public void GetProyect() {
        progressDialog.show();
        final int codeManager;
        String nametoCompare = editManager.getText().toString();
        int code = GetManagerCode(nametoCompare);

        try {
            if (validateInternet.isConnected()) {
                codeManager = code;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        ProyectList = App.getInstance().GetProyect(codeManager);
                        SetProyect();
                    }
                };
                thread.start();
            } else {
                customAlertdialog.showAlertDialogValidateInternet(userName, R.string
                                .por_favor_valide_su_conexion_a_internet,
                        register.this);
                progressDialog.dismiss();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * Método que se encarga de establecer la lista de
     * proyectos a la ventana emergente donde se mostraran,
     * para seleccionar de esta el proyecto deseado el cual
     * se establece en el campo
     */
    private void SetProyect() {
        try {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (showPopup)
                        progressDialog.dismiss();
                    if (ProyectList != null && ProyectList.size() > 0) {
                        final ArrayList<String> proy = new ArrayList<String>();

                        for (Integer i = 0; i < ProyectList.size(); i++) {
                            proy.add(ProyectList.get(i).getNombre());
                        }
                        if (!showPopup) {
                            if (isAdministrative) {
                                if (ProyectList != null && ProyectList.size() > 0) {
                                    editProyect.setText(ProyectList.get(0).getNombre());
                                }
                                //GetDiscipline();
                            }
                            // if(isUpdate){
                            Getfunctionality();
                            //}

                        } else {
                            if (!isAdministrative && ProyectList.get(0).getNombre().equals
                                    (Constants.ADMINISTRATIVO)) {
                                showPopup(Constants.REGISTER_TITLE_DIALOG_PROYECT, Constants
                                        .MESSAGE_NO_FOUND_PROYECTS);
                            } else {
                                DialogSearch dialogSearch = new DialogSearch(register.this, proy,
                                        Constants.REGISTER_TITLE_DIALOG_PROYECT, "", new
                                        DialogSearch.IDialogSelection() {
                                            @Override
                                            public void onResult(ArrayList<String> itemsCopy, int
                                                    position) {
                                                editProyect.setText(itemsCopy.get(position));
                                                editfunctionality.setText("");
                                                editDiscipline.setText("");
                                                editActivity.setText("");
                                            }
                                        });
                                dialogSearch.show();

                            }
                        }
                    } else {
                        showPopup(Constants.REGISTER_TITLE_DIALOG_PROYECT, Constants
                                .MESSAGE_NO_FOUND_PROYECTS);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que obtiene la lista de funcionalidades
     * segun el proyecto seleccionado.
     */
    @OnClick(R.id.register_edfunctionality)
    public void Getfunctionality() {
        progressDialog.show();
        final int codeProyect;
        String nametoCompare = editProyect.getText().toString();
        if (ProyectList == null) {
            GetProyectsList();
        } else {
            int code = GetProyectCode(nametoCompare);
            try {
                if (validateInternet.isConnected()) {
                    codeProyect = code;
                    Thread thread = new Thread() {
                        @Override
                        public void run() {
                            functionalityList = App.getInstance().Getfunctionality(codeProyect);
                            Setfunctionality();
                        }
                    };
                    thread.start();
                } else {
                    customAlertdialog.showAlertDialogValidateInternet(userName, R.string
                                    .por_favor_valide_su_conexion_a_internet,
                            register.this);
                    progressDialog.dismiss();
                }

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    /**
     * Método que se encarga de establecer la lista de
     * funcionalidades a la ventana emergente donde se mostraran,
     * para seleccionar de esta la funcionalidad deseada la cual
     * se establece en el campo.
     */
    private void Setfunctionality() {
        try {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (showPopup)
                        progressDialog.dismiss();
                    if (functionalityList != null && functionalityList.size() > 0) {
                        final String[] proy = new String[functionalityList.size()];
                        for (Integer i = 0; i < functionalityList.size(); i++) {
                            proy[i] = functionalityList.get(i).getNombreFuncionalidad();
                        }
                        if (!showPopup) {
                            //if(isUpdate){
                            GetDiscipline();
                            //}else{
                            if (isAdministrative) {
                                isAdministrative = false;
                                showPopup = true;
                                editfunctionality.setText(R.string.administrativa);
                                progressDialog.dismiss();
                            }
                            //}
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                            builder.setTitle(Constants.REGISTER_TITLE_DIALOG_FUNCTIONALITY);
                            builder.setItems(proy, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    editfunctionality.setText(proy[which]);
                                    editDiscipline.setText("");
                                    editActivity.setText("");
                                }
                            });
                            builder.show();
                        }
                    } else {
                        showPopup(Constants.REGISTER_TITLE_DIALOG_FUNCTIONALITY, Constants
                                .MESSAGE_NO_FOUND_FUNCTIONALITIES);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que obtiene la lista de conceptos de hora.
     */
    @OnClick(R.id.register_edConceptHour)
    public void GetConceptHour() {
        if (showPopup)
            progressDialog.show();
        try {
            if (validateInternet.isConnected()) {
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        ConceptHourList = App.getInstance().GetConceptHour();
                        SetConceptHour(ConceptHourList);
                    }
                };
                thread.start();
            } else {
                customAlertdialog.showAlertDialogValidateInternet(userName, R.string
                                .por_favor_valide_su_conexion_a_internet,
                        register.this);
                progressDialog.dismiss();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * Método que obtiene la lista de gerentes
     */
    //TODO: manager
    @OnClick(R.id.register_edManager)
    public void GetManager() {
        progressDialog.show();
        try {
            if (validateInternet.isConnected()) {
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        ManagerList = App.getInstance().GetManager();
                        setManager(ManagerList);
                    }
                };
                thread.start();
            } else {
                customAlertdialog.showAlertDialogValidateInternet(userName, R.string
                                .por_favor_valide_su_conexion_a_internet,
                        register.this);
                progressDialog.dismiss();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que obtiene la lista de disciplinas segun el
     * proyecto seleccionado
     */
    @OnClick(R.id.register_edDiscipline)
    public void GetDiscipline() {
        progressDialog.show();
        final Proyect proyect;
        String nametoCompare = editProyect.getText().toString();
        proyect = getProyectByName(nametoCompare);
        final Integer codeFuncionality = GetFuncionalityCode(editfunctionality.getText().toString
                ());
        try {
            if (validateInternet.isConnected()) {

                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        if (!editProyect.getText().toString().equals(Constants.ADMINISTRATIVO) &&
                                proyect != null && !proyect.getDescripcionTipoEstimacion().equals
                                (Constants.CASOS)) {
                            DisciplineList = App.getInstance()
                                    .getActivityDisciplineStimationForRegister(codeFuncionality);
                        } else {
                            DisciplineList = App.getInstance().GetDiscipline(proyect != null ?
                                    proyect.getCodigoMaestroMarcoTrabajo() : 0);
                        }

                        setDiscipline();
                    }
                };
                thread.start();
            } else {
                customAlertdialog.showAlertDialogValidateInternet(userName, R.string
                                .por_favor_valide_su_conexion_a_internet,
                        register.this);
                progressDialog.dismiss();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método encargado de buscar un proyecto especifico en la lista de proyectos
     *
     * @param nametoCompare Nombre del proyecto que se desea buscar
     * @return Retorna el proyecto que coincida con el parametro de entrada
     */
    private Proyect getProyectByName(String nametoCompare) {
        if (ProyectList == null) {
            return null;
        } else {
            for (Integer i = 0; i < ProyectList.size(); i++) {
                String fullName = ProyectList.get(i).getNombre();
                if (fullName.equalsIgnoreCase(nametoCompare)) {
                    return ProyectList.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Método que se encarga de establecer la lista de
     * disciplinas a la ventana emergente donde se mostraran,
     * para seleccionar de esta la disciplina deseada la cual
     * se establece en el campo.
     */
    private void setDiscipline() {

        try {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (showPopup)
                        progressDialog.dismiss();
                    if (DisciplineList != null && DisciplineList.size() > 0) {
                        editDiscipline.setFocusable(false);
                        editDiscipline.setInputType(InputType.TYPE_NULL);
                        final String[] proy = new String[DisciplineList.size()];

                        for (Integer i = 0; i < DisciplineList.size(); i++) {
                            proy[i] = DisciplineList.get(i).getNombreMaestroProcesoDisciplina();
                        }
                        if (!showPopup) {

                            if (isAdministrative) {
                                editDiscipline.setText(R.string.administrativo);
                            }
                            // if(isUpdate){
                            getActivity();

                            //}
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                            builder.setTitle(Constants.REGISTER_TITLE_DIALOG_DISCIPLINE);
                            builder.setItems(proy, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    editDiscipline.setText(proy[which]);
                                    editActivity.setText("");
                                }
                            });
                            builder.show();
                        }
//                            }
//                        });
                    } else {
                        showPopup(Constants.REGISTER_TITLE_DIALOG_DISCIPLINE, Constants
                                .MESSAGE_NO_FOUND_DISCIPLINE);
                        progressDialog.dismiss();
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que obtiene la lista de actividades segun la
     * disciplina y/o el codigo seleccionado por el usuario.
     */
    @OnClick(R.id.register_edActivity)
    public void getActivity() {
        progressDialog.show();

        final Proyect proyect;
        String nametoCompareProyect = editProyect.getText().toString();
        proyect = getProyectByName(nametoCompareProyect);
        String nametoCompareDiscipline = editDiscipline.getText().toString();
        final int codeDiscipline = getCodeDiscipline(nametoCompareDiscipline);
        String nameToCompareFuncionality = editfunctionality.getText().toString();
        final int codeFuncionality = GetFuncionalityCode(nameToCompareFuncionality);
        try {
            if (validateInternet.isConnected()) {

                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        if (proyect != null && !proyect.getDescripcionTipoEstimacion().equals
                                (Constants.CASOS)) {
                            activityList = App.getInstance()
                                    .getFuncionalityActivityStimateForRegister(codeDiscipline,
                                            codeFuncionality);
                        } else {
                            activityList = App.getInstance().getActivity(codeDiscipline);
                        }
                        setActivity();
                    }
                };
                thread.start();
            } else {
                customAlertdialog.showAlertDialogValidateInternet(userName, R.string
                                .por_favor_valide_su_conexion_a_internet,
                        register.this);
                progressDialog.dismiss();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método encargado de buscar el codigo de una disciplina especifica
     *
     * @param nametoCompare Nombre de la disciplina que se desea buscar
     * @return Retorna el codigo de la disciplina encontrada
     */
    private int getCodeDiscipline(String nametoCompare) {
        int code = 0;
        if (DisciplineList == null) {
            return 0;
        } else {
            for (Integer i = 0; i < DisciplineList.size(); i++) {
                String fullName = DisciplineList.get(i).getNombreMaestroProcesoDisciplina();
                if (fullName.equalsIgnoreCase(nametoCompare)) {
                    code = DisciplineList.get(i).getCodigoDisciplina();
                }
            }
        }
        return code;
    }

    /**
     * Método que se encarga de establecer la lista de
     * actividades a la ventana emergente donde se mostraran,
     * para seleccionar de esta la actividad deseada la cual
     * se establece en el campo.
     */
    private void setActivity() {

        try {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();

                    if (activityList != null && activityList.size() > 0) {
                        editActivity.setFocusable(false);
                        editActivity.setInputType(InputType.TYPE_NULL);

                        final String[] activity = new String[activityList.size()];

                        for (Integer i = 0; i < activityList.size(); i++) {
                            activity[i] = activityList.get(i).getNombre();
                        }
                        if (!showPopup) {
                            progressDialog.dismiss();
                            if (isAdministrative) {
                                editActivity.setText(R.string.administrativo);

                            }
                            if (isUpdate) {
                                showPopup = true;
                                isUpdate = false;
                                progressDialog.dismiss();
                            }
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                            builder.setTitle(Constants.REGISTER_TITLE_DIALOG_ACTIVITY);
                            builder.setItems(activity, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    editActivity.setText(activity[which]);
                                }
                            });
                            builder.show();
                        }
//                            }
//                        });
                    } else {
                        if (showPopup)
                            showPopup(Constants.REGISTER_TITLE_DIALOG_ACTIVITY, Constants
                                    .MESSAGE_NO_FOUND_ACTIVITY);
                        if (isUpdate) {
                            showPopup = true;
                            isUpdate = false;
                            progressDialog.dismiss();
                        }
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que se encarga de establecer la lista de
     * conoceptos de hora a la ventana emergente donde se mostraran,
     * para seleccionar de esta el concepto de hora deseada el cual
     * se establece en el campo.
     *
     * @param conceptHourList lista de conceptos de hora que se mostraran al
     *                        usuario
     */
    private void SetConceptHour(final List<ConceptHour> conceptHourList) {
        try {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (showPopup)
                        progressDialog.dismiss();

                    if (conceptHourList != null && conceptHourList.size() > 0) {
                        editConceptoHour.setFocusable(false);
                        editConceptoHour.setInputType(InputType.TYPE_NULL);
                        final String[] proy = new String[conceptHourList.size()];

                        for (Integer i = 0; i < conceptHourList.size(); i++) {
                            proy[i] = conceptHourList.get(i).getName();
                        }
                        if (!showPopup) {
                            //  if(isUpdate)
                            GetClassificationConceptHour();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                            builder.setTitle(Constants.REGISTER_TITLE_DIALOG_CONCEPT_HOUR);
                            builder.setItems(proy, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //                                  Se realiza la validación
                                    // para saber si el concepto de hora es administrativa
                                    editConceptoHour.setText(proy[which]);
                                    editClassificationConceptHour.setText("");
                                    if (which == 0) {
                                        CargarReporteAdministrativo();
                                    } else {
                                        checkBoxActivity.setEnabled(true);
                                        checkBoxActivity.setChecked(checkbox);
                                    }
                                }
                            });
                            builder.show();

                        }
//                                }
//                            });
                    } else {
                        showPopup(Constants.REGISTER_TITLE_DIALOG_CONCEPT_HOUR, Constants
                                .MESSAGE_NO_FOUND_CONCEPT_HOURS);
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo orquestador que permite cargar todos los elementos aministrativos
     */
    private void CargarReporteAdministrativo() {
        checkbox = checkBoxActivity.isChecked();
        isAdministrative = true;
        showPopup = true;
        editManager.setText(R.string.todos_los_gerentes);
        editProyect.setText(R.string.administrativo);
        editfunctionality.setText(R.string.administrativo);
        editDiscipline.setText(R.string.administrativo);
        editActivity.setText(R.string.administrativo);
        checkBoxActivity.setEnabled(false);
        checkBoxActivity.setChecked(false);
        GetClassificationConceptHour();
        //GetManager();

    }

    /**
     * Método que se encarga de establecer la lista de
     * gerentes a la ventana emergente donde se mostraran,
     * para seleccionar de esta el gerente deseado el cual
     * se establece en el campo.
     *
     * @param ManagerList lista de gerentes que se mostraran al
     *                    usuario
     */
    public void setManager(final List<Manager> ManagerList) {
        try {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (showPopup)
                        progressDialog.dismiss();
                    if (ManagerList != null && ManagerList.size() > 0) {
                        final String[] proy = new String[ManagerList.size()];

                        for (Integer i = 0; i < ManagerList.size(); i++) {
                            String FullName = (ManagerList.get(i).getFirtNames() + " " +
                                    ManagerList.get(i).getLastNames()).toUpperCase();
                            proy[i] = FullName;
                        }
                        if (!showPopup) {
                            GetProyect();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                            builder.setTitle(Constants.REGISTER_TITLE_DIALOG_DIRECTOR);
                            builder.setItems(proy, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    editManager.setText(proy[which]);
                                    editProyect.setText("");
                                    editfunctionality.setText("");
                                    editDiscipline.setText("");
                                    editActivity.setText("");
                                }
                            });
                            builder.show();

                        }
//                            }
//                        });

                    } else {
                        showPopup(Constants.REGISTER_TITLE_DIALOG_DIRECTOR, Constants
                                .MESSAGE_NO_FOUND_MANAGERS);
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método encargado de buscar el codigo de un proyecto especifico
     *
     * @param nametoCompare Nombre del proyecto que se desea buscar
     * @return Retorna el codigo del proyecto encontrado
     */
    public int GetProyectCode(String nametoCompare) {
        int code = 0;

        if (ProyectList != null) {
            for (Integer i = 0; i < ProyectList.size(); i++) {
                if (ProyectList.get(i).getNombre().equals(nametoCompare)) {
                    code = ProyectList.get(i).getCodigoProyecto();
                }
            }
        }
        return code;
    }

    /**
     * Método encargado de buscar el codigo de un gerente especifico
     *
     * @param nametoCompare Nombre del gerente que se desea buscar
     * @return Retorna el codigo del gerente encontrado
     */
    public int GetManagerCode(String nametoCompare) {
        int code = 0;
        if (ManagerList == null) {
            return 0;
        } else {
            for (Integer i = 0; i < ManagerList.size(); i++) {
                String fullName = ManagerList.get(i).getFirtNames() + " " + ManagerList.get(i)
                        .getLastNames();
                if (fullName.equalsIgnoreCase(nametoCompare)) {
                    code = ManagerList.get(i).getCodeUser();
                }
            }
        }

        return code;
    }

    /**
     * Método encargado de buscar el codigo de una funcionalidad especifica
     *
     * @param nametoCompare Nombre de la funcionalidad que se desea buscar
     * @return Retorna el codigo de la funcionalidad encontrada
     */
    public int GetFuncionalityCode(String nametoCompare) {
        int code = 0;
        if (isAdministrative) {
            return 1;
        }
        if (functionalityList == null) {
            return 0;
        } else {
            for (Integer i = 0; i < functionalityList.size(); i++) {
                if (functionalityList.get(i).getNombreFuncionalidad().equalsIgnoreCase
                        (nametoCompare)) {
                    code = functionalityList.get(i).getCodigoFuncionalidad();
                }
            }
        }
        return code;
    }

    /**
     * Método encargado de buscar el codigo de un concepto de hora especifico
     *
     * @param nametoCompare Nombre del concepto de hora que se desea buscar
     * @return Retorna el codigo del concepto de hora encontrado
     */
    public int GetConceptHourCode(String nametoCompare) {
        int code = 0;
        for (Integer i = 0; i < ConceptHourList.size(); i++) {
            if (ConceptHourList.get(i).getName().equals(nametoCompare)) {
                code = ConceptHourList.get(i).getCodeTypeHour();
            }
        }
        return code;
    }

    /**
     * Método encargado de buscar el codigo de una clasificacion especifica
     *
     * @param nametoCompare Nombre de la clasificacion que se desea buscar
     * @return Retorna el codigo de la clasificacion encontrada
     */
    public int GetClassificationConceptHourCode(String nametoCompare) {
        int code = 0;

        for (Integer i = 0; i < ClassificationConceptHourList.size(); i++) {
            if (ClassificationConceptHourList.get(i).getName().equals(nametoCompare)) {
                code = ClassificationConceptHourList.get(i).getCodeMasterTypeHour();
            }
        }
        return code;
    }

    /**
     * Método encargado de buscar el codigo de una disciplina especifica
     *
     * @param nametoCompare Nombre de la disciplina que se desea buscar
     * @return Retorna el codigo de la disciplina encontrada
     */
    public int GetDisciplineCode(String nametoCompare) {
        int code = 0;
        if (isAdministrative) {
            return 1;
        }
        for (Integer i = 0; i < DisciplineList.size(); i++) {
            if (DisciplineList.get(i).getNombreMaestroProcesoDisciplina().equals(nametoCompare)) {
                code = DisciplineList.get(i).getCodigoDisciplina();
            }
        }
        return code;
    }

    /**
     * Método encargado de buscar el codigo de una actividad especifica
     *
     * @param nametoCompare Nombre de la actividad que se desea buscar
     * @return Retorna el codigo de la actividad encontrada
     */
    public int getActivityMasterCode(String nametoCompare) {
        int code = 0;
        if (activityList != null) {
            for (Integer i = 0; i < activityList.size(); i++) {
                if (activityList.get(i).getNombre().equals(nametoCompare)) {
                    code = activityList.get(i).getCodigoMaestroActividad();
                }
            }
        }
        return code;
    }


    /**
     * Método encargado organizar toda la informacion ingresada por el
     * usuario para finalmente llevare a cabo el reporte
     */
    @OnClick(R.id.btnReportar)
    public void goToRegisterTime() {
        try {
            if (validateInternet.isConnected()) {
                progressDialog.show();

                if (ValidateData()) {

                    ReportTime report = new ReportTime();

                    JSONObject repJson = new JSONObject();


                    int codigoDisciplina;
                    if (DisciplineList == null && edit) {
                        codigoDisciplina = viewTimesEdit.getCodigoDisciplina();
                    } else {
                        codigoDisciplina = GetDisciplineCode(editDiscipline.getText().toString());
                        repJson.put(Constants.DISCIPLINE, editDiscipline.getText().toString());
                    }
                    int codigoActividad;
                    if (edit && editActivity.getText().toString().equals(viewTimesEdit
                            .getNombreMaestroActividad())) {
                        codigoActividad = viewTimesEdit.getCodigoMaestroActividad();
                    } else {
                        codigoActividad = getActivityMasterCode(editActivity.getText().toString());
                    }
                    int codigoFuncionalidad;
                    if (functionalityList == null && edit) {
                        codigoFuncionalidad = viewTimesEdit.getCodigoFuncionalidad();
                    } else {
                        codigoFuncionalidad = GetFuncionalityCode(editfunctionality.getText()
                                .toString());
                        repJson.put(Constants.FUNCTIONALITY, editfunctionality.getText().toString
                                ());
                    }
                    int codigoMaestro;
                    if (ClassificationConceptHourList == null && edit) {
                        codigoMaestro = viewTimesEdit.getCodigoMaestroTipoHora();
                    } else {
                        codigoMaestro = GetClassificationConceptHourCode
                                (editClassificationConceptHour.getText().toString());
                        repJson.put(Constants.CLASSIFICATION_CONCEPT_HOUR,
                                editClassificationConceptHour.getText().toString());
                    }
                    String desripcion = edDescrptionActivity.getText().toString();
                    repJson.put(Constants.DESCRIPTION, desripcion);
                    repJson.put(Constants.MANAGER, editManager.getText().toString());
                    repJson.put(Constants.CONCEPT_HOUR, editConceptoHour.getText().toString());
                    repJson.put(Constants.PROYECT, editProyect.getText().toString());

                    double Horas = Double.valueOf(edHour.getText().toString());
                    String fecha = (edDate.getText().toString());
                    fecha = fecha.replace("-", "/");
                    DateFormat formatter = new SimpleDateFormat(Constants.DD_MM_YYYY_REPORT);
                    Date dateObject = formatter.parse(fecha);


                    report.setCodigoDisciplina(codigoDisciplina);
                    report.setCodigoEmpleado(Integer.parseInt(codigoUsuario));
                    report.setCodigoFuncionalidad(codigoFuncionalidad);
                    report.setCodigoMaestro(codigoMaestro);
                    report.setDescripcion(desripcion);
                    report.setHoras(Horas);
                    report.setCodigoEstadoIntegracion(1);
                    report.setFechaActividad(dateObject);
                    report.setActividadCompletada(checkBoxActivity.isChecked());
                    report.setCodigoMaestroActividad(codigoActividad);
                    repJson.put(Constants.CODIGO_ESTADO_INTEGRACION, 1);
                    repJson.put(Constants.HORAS, Horas);
                    repJson.put(Constants.CODIGO_USUARIO, codigoUsuario);

                    Register(report, repJson);

                } else {
                    progressDialog.dismiss();
                }
            } else {
                //TODO:implementar esconder progress
                customAlertdialog.showAlertDialogValidateInternet(userName, R.string
                                .por_favor_valide_su_conexion_a_internet,
                        register.this);
                progressDialog.dismiss();
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.faltan_campos_por_diligenciar, Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }


    }

    /**
     * Método encargado realizar el reporte o la actualizacion
     * de un reporte previamente cargado si es el caso, adicionalmente
     * guarda el ultimo reporte realizado con el fin de agilizar el proximo
     * reporte del usuario
     */
    private void Register(final ReportTime register, final JSONObject repJson) {
        try {
            final Login login = new Login();
            Thread thread = new Thread() {
                @Override
                public void run() {
                    Boolean tiemposResponse;
                    if (edit) {
                        register.setCodigoActividad(CodigoActividad);
                        tiemposResponse = App.getInstance().EditTimes(register);
                        CodigoActividad = null;
                        Intent intent = new Intent(register.this, ViewTimes.class);
                        intent.putExtra(Constants.USER_CODIGO, codigoUsuario);
                        edit = false;
                        startActivity(intent);
                    } else {
                        //save last time
                        try {

                            FileOutputStream lastRep = openFileOutput(Constants.LAST_REPORT_TXT,
                                    MODE_PRIVATE);
                            OutputStreamWriter osw = new OutputStreamWriter(lastRep);
                            osw.write(repJson.toString());
                            osw.flush();
                            osw.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        tiemposResponse = App.getInstance().Register(register);
                    }
                    validateRegister(tiemposResponse);
                }
            };
            thread.start();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, Constants.ERROR_GENERAL_REPORT, Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Método que valida si el reporte realizado se ha llevado con exito para
     * limpiar los campos de la actividad, de lo contrario, muestra un mensaje
     * de error al usuario
     *
     * @param reg Booleano que determina si el reporte fue llevado a cabo con exito o no
     */
    public void validateRegister(final Boolean reg) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                if (reg != null && reg) {
                    editManager.setText("");
                    editConceptoHour.setText("");
                    editClassificationConceptHour.setText("");
                    editProyect.setText("");
                    editfunctionality.setText("");
                    editDiscipline.setText("");
                    edDate.setText("");
                    edHour.setText("");
                    edDescrptionActivity.setText("");
                    editActivity.setText("");
                    checkBoxActivity.setChecked(false);
                    Toast.makeText(register.this, Constants.REGISTER_SUCCESS, Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(register.this, Constants.REGISTE_ERROR, Toast.LENGTH_SHORT)
                            .show();
                }
            }

        });
    }


    /**
     * Método encargado de validar los campos obligatorios del reporte
     *
     * @return Booleano que determina si los campos obligatorios se ingresaron
     * en su totalidad (true) o no (false).
     */
    private Boolean ValidateData() {

        Validation validator = new Validation();
        String error = "";
        double horas = 0;

        if (TextUtils.isEmpty(editDiscipline.getText().toString().trim())) {
            error += "- " + Constants.REGISTER_TITLE_DIALOG_DISCIPLINE + "\n";
        }
        if (TextUtils.isEmpty(editActivity.getText().toString().trim())) {
            error += "- " + Constants.REGISTER_TITLE_DIALOG_ACTIVITY + "\n";
        }
        if (TextUtils.isEmpty(editfunctionality.getText().toString().trim())) {
            error += "- " + Constants.REGISTER_TITLE_DIALOG_FUNCTIONALITY + "\n";
        }
        if (TextUtils.isEmpty(editClassificationConceptHour.getText().toString().trim())) {
            error += "- " + Constants.REGISTER_TITLE_DIALOG_CLASIFICATION_CONCEPT_HOUR + "\n";
        }
        if (TextUtils.isEmpty(edHour.getText().toString().trim())) {
            error += "- " + Constants.ERROR_SELECT_HOUR + "\n";
        } else {
            horas = Double.valueOf(edHour.getText().toString());
            if (!validator.validateHoursReport(horas)) {
                error += Constants.ERROR_HOUR + "\n";
            }
        }

        if (TextUtils.isEmpty(edDate.getText().toString().trim())) {
            error += Constants.ERROR_SELECT_DATE + "\n";
        }

        if (totalWeek != null && totalWeek.size() > 0 && currentWeek != null && totalWeek.get
                (currentWeek) != null && totalWeek.get(currentWeek) + horas > 55) {
            error += Constants.MESSAGE_HOURS_REPORTED + "\n";
        }

        if (error.equals("")) {
            return true;
        } else {
            showPopup(getResources().getString(R.string.campos_incompletos), error);
            return false;
        }

    }

    /**
     * Método encargado de mostrar un mensaje generico
     *
     * @param title   titulo del mensaje
     * @param message contenido del mensaje
     */
    private void showPopup(String title, String message) {

        AlertDialog.Builder alert = new AlertDialog.Builder(register.this);
        alert.setTitle(title);
        alert.setMessage(message);

        alertDialog = alert.create();
        alertDialog.show();
    }

    /**
     * Metodo encargado de obtener una lista de proyectos que se
     * encuentran asociados a un codigo de gerente especifico
     */
    private void GetProyectsList() {

        final int codeManager;
        String nametoCompare = editManager.getText().toString();
        int code = GetManagerCode(nametoCompare);
        try {
            if (validateInternet.isConnected()) {
                codeManager = code;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        List<Proyect> proyects = App.getInstance().GetProyect(codeManager);
                        if (proyects == null) {
                            progressDialog.dismiss();
                            showPopUpThread(Constants.REGISTER_TITLE_DIALOG_FUNCTIONALITY,
                                    Constants.MESSAGE_ERROR_GET_FUNCTIONALITY);
                        } else {
                            SetProyectsList(proyects);
                        }
                    }
                };
                thread.start();
            } else {
                customAlertdialog.showAlertDialogValidateInternet(userName, R.string
                                .por_favor_valide_su_conexion_a_internet,
                        register.this);
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * Metodo encargado de establecer la lista de proyectos.
     */
    public void SetProyectsList(final List<Proyect> proyects) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ProyectList = proyects;
                Getfunctionality();
            }

        });
    }

    /**
     * Método encargado de mostrar un mensaje generico en finalizacion de un hilo.
     *
     * @param title   titulo del mensaje
     * @param message contenido del mensaje
     */
    public void showPopUpThread(final String title, final String message) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder alert = new AlertDialog.Builder(register.this);
                alert.setTitle(title);
                alert.setMessage(message);

                alertDialog = alert.create();
                alertDialog.show();
            }

        });
    }


}
