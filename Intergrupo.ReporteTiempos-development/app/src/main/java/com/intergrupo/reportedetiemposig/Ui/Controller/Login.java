package com.intergrupo.reportedetiemposig.Ui.Controller;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import com.intergrupo.reportedetiemposig.Helper.CustomAlertdialog;
import com.intergrupo.reportedetiemposig.Helper.IValidateInternet;
import com.intergrupo.reportedetiemposig.Helper.SecurePreferences;
import com.intergrupo.reportedetiemposig.Helper.ValidateInternet;
import com.intergrupo.reportedetiemposig.Helper.Validation;
import com.intergrupo.reportedetiemposig.Model.*;
import com.intergrupo.reportedetiemposig.R;


import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.intergrupo.reportedetiemposig.Util.Constants;

public class Login extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private Validation validation = new Validation();
    private AlertDialog alertDialog;
    private IValidateInternet iValidateInternet;
    private CustomAlertdialog customAlertdialog;

    @InjectView(R.id.Login_edUser)
    EditText EdUser;

    @InjectView(R.id.Login_edPassword)
    EditText EdPassword;

    @InjectView(R.id.Login_btnLogin)
    Button Login_btnLogin;

    @InjectView(R.id.Login_chkRememberData)
    CheckBox Login_chkRememberData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        customAlertdialog = new CustomAlertdialog();
        initializeVisualElemetsAndMethods();
    }

    private void initializeVisualElemetsAndMethods() {
        iValidateInternet = new ValidateInternet(Login.this);

        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setMessage(Constants.POR_FAVOR_ESPERE);
        this.progressDialog.setCancelable(false);
    }


    /*
     * @Login: Toma los valores usuario y contraseña, estos son validados, si no cumple los
     * requisitos necesarios, el sistema
     * arrojará un mensaje negativo y en caso de cumplirlos obtiene la instancia del singleton de
      * la App luego implementa
     * el método consultUser, al cual se le envía 3 parámetros, el retorno de este método
     * determinará cual mensaje será mostrado
     * al usuario.
     */
    @OnClick(R.id.Login_btnLogin)
    public void ConsultUser() {
        Login_btnLogin.setEnabled(false);
        if (ValidateData()) {
            rememberData();
            loginUser(createAndSetUser());
        }
        Login_btnLogin.setEnabled(true);
    }

    private com.intergrupo.reportedetiemposig.Model.Login createAndSetUser() {
        com.intergrupo.reportedetiemposig.Model.Login login = new com.intergrupo.reportedetiemposig.Model.Login();
        login.setUsuario(EdUser.getText().toString());
        login.setContrasena(EdPassword.getText().toString());
        return login;
    }

    private void loginUser(final com.intergrupo.reportedetiemposig.Model.Login login) {
        progressDialog.show();
        Thread thread = new Thread() {
            @Override
            public void run() {
                verifyInternetConnection(login);
            }
        };
        thread.start();

    }

    private void verifyInternetConnection(final com.intergrupo.reportedetiemposig.Model.Login login) {
        if (iValidateInternet.isConnected()) {
            User tiemposResponse = mApp.getInstance().SingInSincrono(login);
            verificarLogin(tiemposResponse);
        } else {
            progressDialog.dismiss();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    customAlertdialog.showAlertDialogValidateInternet(R.string
                                    .apreciado_usuario, R.string
                                    .por_favor_valide_su_conexion_a_internet,
                            Login.this);
                }
            });
        }
    }


    private void rememberData() {
        SecurePreferences settings = new SecurePreferences(this);
        if (Login_chkRememberData.isChecked()) {
            settings.put(Constants.REMEMBER_ACCESS, Constants.TRUE);
        } else {
            settings.put(Constants.REMEMBER_ACCESS, null);
        }
    }


    private void verificarLogin(final User tiemposResponse) {

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                if (tiemposResponse != null && tiemposResponse.getCode() == 9) {
                    startMenuActivity(tiemposResponse);
                } else {
                    if (tiemposResponse != null) {
                        Toast.makeText(Login.this, tiemposResponse.getTexto(), Toast.LENGTH_LONG)
                                .show();
                    } else {
                        Toast.makeText(Login.this, Constants.MESSAGE_USER_ERROR, Toast
                                .LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void startMenuActivity(final User tiemposResponse) {
        createSecuredPreferences(tiemposResponse);
        Intent intent = new Intent(Login.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    private void createSecuredPreferences(final User tiemposResponse) {
        SecurePreferences sharedPreferencesUserData = new SecurePreferences(Login.this);
        sharedPreferencesUserData.put(Constants.USER_NAME, tiemposResponse.getName());
        sharedPreferencesUserData.put(Constants.USER_LASTNAME, tiemposResponse.getLastname());
        sharedPreferencesUserData.put(Constants.URLUSERPHOTO, tiemposResponse.getUrlphoto());
        sharedPreferencesUserData.put(Constants.USER_CODIGO, tiemposResponse.getCodeuser()
                .toString());
        sharedPreferencesUserData.put(Constants.IG_USER, tiemposResponse.getManager().toString());
    }


    /**
     * Valida los campos antes de iniciar sesión
     *
     * @return
     */
    private Boolean ValidateData() {
        return (validateUserField() && validatePasswordField());
    }

    private boolean validatePasswordField() {
        if (TextUtils.isEmpty(EdPassword.getText().toString().trim())) {
            showPopup(getResources().getString(R.string.campos_incompletos), getResources()
                    .getString(R.string.debes_ingresar_una_contrasenia), EdPassword);
            return false;
        }
        return true;
    }

    private Boolean validateUserField() {
        if (TextUtils.isEmpty(EdUser.getText().toString().trim())) {
            showPopup(getResources().getString(R.string.campos_incompletos), getResources()
                    .getString(R.string.debes_ingresar_tu_correo_electronico), EdUser);
            return false;
        }
        if (EdUser.getText().toString().contains("@")) {
            if (validation.isNotCorrectEmail(EdUser.getText().toString().trim())) {
                showPopup(getResources().getString(R.string.campos_incompletos), getResources()
                        .getString(R.string.message_email_invalid), EdUser);
                return false;
            }
        }
        return true;
    }

    /**
     * Permite mostrar un popup informando campos vacíos en el registro.
     *
     * @param message  Mensaje a mostrar en el popup
     * @param editText EditText el cual hará focus donde haya error o esté vacío.
     */
    private void showPopup(String title, String message, final EditText editText) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (editText != null) {
                    editText.requestFocus();
                }
            }
        });
        alertDialog = alert.create();
        alertDialog.show();
    }


}

