package com.intergrupo.reportedetiemposig.Repositories.Test;

import android.widget.Toast;

import com.intergrupo.reportedetiemposig.CallBack.Callback;
import com.intergrupo.reportedetiemposig.Model.*;
import com.intergrupo.reportedetiemposig.Model.Error;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.ISecurityRepository;
import com.intergrupo.reportedetiemposig.Util.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit.RetrofitError;

/**
 * Created by mauriciocaro on 23/06/15.
 */
public class TestSecurityRepository implements ISecurityRepository {


    @Override
    public void SignIn(IGLogin login, Callback<Boolean> callback) {
        IGLogin loginTest = new IGLogin("leidy", "123");
        if (login.getUsuario().equals(loginTest.getUsuario()) && login.getContrasena().equals(loginTest.getContrasena())) {
            callback.complete(true);
        } else {
            Error error = null;
            callback.failure(error);
        }
    }

    @Override
    public User SignInSincrono(IGLogin login) {

        User tiemposResponse = new User();
        IGLogin loginTest = new IGLogin("123@abc.com", "123");
        if (login.getUsuario().equals(loginTest.getUsuario()) && login.getContrasena().equals(loginTest.getContrasena())) {
            User usert = new User();
            tiemposResponse.setCodeuser(168);
            tiemposResponse.setCedula(71557225);
            tiemposResponse.setMail("Jquinterov@intergrupo.com");
            tiemposResponse.setManager(false);
            tiemposResponse.setName("Juan Felipe");
            tiemposResponse.setLastname("Quintero Villada");
            tiemposResponse.setCode(9);
            tiemposResponse.setUrlphoto("http://fotosdefloresyanimales.com/wp-content/uploads/2015/11/gatos-tiernos-fotos-videos.jpg");
        } else {
            return null;
        }
        return tiemposResponse;
    }
}