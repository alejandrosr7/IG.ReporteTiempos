package com.intergrupo.reportedetiemposig.Helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by USUARIO on 16/10/2016.
 */

public class ValidateInternet implements IValidateInternet {

    private Context context;

    public ValidateInternet(Context context) {
        this.context = context;
    }

    /**
     * Método que valida la conexión
     * a internet
     * @return networkInfo
     */
    @Override
    public boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting() && networkInfo.isAvailable() && networkInfo.isConnected();
    }
}
