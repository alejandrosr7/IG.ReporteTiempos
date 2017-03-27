package com.intergrupo.reportedetiemposig.Repositories.Production;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.intergrupo.reportedetiemposig.CallBack.Callback;
import com.intergrupo.reportedetiemposig.Model.IGLogin;
import com.intergrupo.reportedetiemposig.Model.ReportTime;
import com.intergrupo.reportedetiemposig.Model.TiemposResponse;
import com.intergrupo.reportedetiemposig.Model.User;
import com.intergrupo.reportedetiemposig.Model.UserError;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.ISecurityRepository;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by mauriciocaro on 23/06/15.
 */

public class SecurityRepository implements ISecurityRepository {

    public void SignIn(String user, String password, Callback<Boolean> callback) {

    }

    @Override
    public void SignIn(IGLogin login, Callback<Boolean> callback) {

    }

    @Override
    public User SignInSincrono(IGLogin login) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        User usuario = new User();
        try {
            Object user = client.User(login);
            if (user == null) {
                return null;
            } else {
                Gson gson = new Gson();
                String jsonInString = gson.toJson(user);
                try {
                    usuario = gson.fromJson(jsonInString, User.class);
                } catch (Exception ex) {
                    Type listType = new TypeToken<ArrayList<UserError>>() {
                    }.getType();
                    List<UserError> usuarioError = gson.fromJson(jsonInString, listType);
                    usuario.setCode(usuarioError.get(0).getCodigo());
                    usuario.setTexto(usuarioError.get(0).getTexto());
                }
            }
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
            return null;
        }

        return usuario;
    }
}
