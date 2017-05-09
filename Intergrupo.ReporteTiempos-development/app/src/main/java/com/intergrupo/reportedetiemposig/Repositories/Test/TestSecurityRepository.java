package com.intergrupo.reportedetiemposig.Repositories.Test;

import com.intergrupo.reportedetiemposig.CallBack.Callback;
import com.intergrupo.reportedetiemposig.Model.*;
import com.intergrupo.reportedetiemposig.Model.Error;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.ISecurityRepository;

/**
 * Created by mauriciocaro on 23/06/15.
 */
public class TestSecurityRepository implements ISecurityRepository {


    @Override
    public void SignIn(Login login, Callback<Boolean> callback) {
        Login loginTest = new Login("leidy", "123");
        if (login.getUsuario().equals(loginTest.getUsuario()) && login.getContrasena().equals(loginTest.getContrasena())) {
            callback.complete(true);
        } else {
            Error error = null;
            callback.failure(error);
        }
    }

    @Override
    public User SignInSincrono(Login login) {

        User tiemposResponse = new User();
        Login loginTest = new Login("123@abc.com", "123");
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