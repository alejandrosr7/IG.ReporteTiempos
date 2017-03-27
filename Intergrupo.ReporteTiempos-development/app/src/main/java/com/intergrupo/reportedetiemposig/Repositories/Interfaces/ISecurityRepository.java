package com.intergrupo.reportedetiemposig.Repositories.Interfaces;


import com.intergrupo.reportedetiemposig.CallBack.Callback;
import com.intergrupo.reportedetiemposig.Model.IGLogin;
import com.intergrupo.reportedetiemposig.Model.ReportTime;
import com.intergrupo.reportedetiemposig.Model.TiemposResponse;
import com.intergrupo.reportedetiemposig.Model.User;

import java.util.List;

/**
 * Created by mauriciocaro on 23/06/15.
 */
public interface ISecurityRepository {

    void SignIn(IGLogin login, Callback<Boolean> callback);

    User SignInSincrono(IGLogin login);


}

