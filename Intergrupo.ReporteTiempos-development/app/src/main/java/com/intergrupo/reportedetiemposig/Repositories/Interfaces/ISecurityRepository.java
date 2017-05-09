package com.intergrupo.reportedetiemposig.Repositories.Interfaces;


import com.intergrupo.reportedetiemposig.CallBack.Callback;
import com.intergrupo.reportedetiemposig.Model.Login;
import com.intergrupo.reportedetiemposig.Model.User;

/**
 * Created by mauriciocaro on 23/06/15.
 */
public interface ISecurityRepository {

    void SignIn(Login login, Callback<Boolean> callback);

    User SignInSincrono(Login login);


}

