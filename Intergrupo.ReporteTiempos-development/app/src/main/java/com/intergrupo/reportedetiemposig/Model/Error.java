package com.intergrupo.reportedetiemposig.Model;

import android.util.Log;

import com.intergrupo.reportedetiemposig.Util.Constants;

import retrofit.RetrofitError;

/**
 * Created by mauriciocaro on 23/06/15.
 */
public class Error {

    /**
     * Permite obtener o establecer el nombre de la descripción
     */
    private String description;

    /**
     * Permite obtener o establecer el código
     */
    private String code;


    //TODO definir errores de conexiones y errores internos

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Error(RetrofitError error) {
        if(error.getResponse() != null){

            Log.d("Status del error:", String.valueOf(error.getResponse().getStatus()));
        }
        if (error.isNetworkError()) {
            this.setCode(Constants.NETWORK_ERROR_CODE);
            this.setDescription(Constants.NETWORK_ERROR_MESSAGE);
        }
    }

    public Error(Exception error) {
        this.description = error.getMessage();
    }
}
