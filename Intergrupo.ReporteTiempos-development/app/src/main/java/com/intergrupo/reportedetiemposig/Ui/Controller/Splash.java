package com.intergrupo.reportedetiemposig.Ui.Controller;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.intergrupo.reportedetiemposig.Helper.SecurePreferences;
import com.intergrupo.reportedetiemposig.Helper.Validation;
import com.intergrupo.reportedetiemposig.R;
import com.intergrupo.reportedetiemposig.Util.Constants;

import butterknife.ButterKnife;

public class Splash extends AppCompatActivity {

    Validation validation = new Validation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);
        loadConfigurations();

    }

    /*Metodo para validar preferencias en el dispositvo para determinar el inicio de sesión del usuario*/
    public void loadConfigurations() {
        SecurePreferences settings = new SecurePreferences(this);
        String firstTime = settings.getString(Constants.REMEMBER_ACCESS);
        if (!validation.theDataIsNotNull(firstTime)) {
            goToLogin();
        } else {
            goToMenu();
        }
    }

    /*Esta opción se presenta cuando el usuario guardó los datos de ingreso,
      por lo que al iniciar la aplicación si este tiene datos guardados entrará por éste netid*/
    private void goToMenu() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash.this, MenuActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 2500);
    }

    /*Esta opción se presenta si el usuario no recordó datos de ingresos,
      así que ingresará nuevamente al menú*/
    private void goToLogin(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash.this, Login.class);
                startActivity(mainIntent);
                finish();
            }
        }, 2500);
    }


}
