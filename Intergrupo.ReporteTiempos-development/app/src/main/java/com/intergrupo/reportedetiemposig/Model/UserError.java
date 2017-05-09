package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mauriciocarogutierrez on 10/21/16.
 * Entidad que permite capturar el error de autenticaciòn al iniciar sesiòn
 */

public class UserError {

    /**
     * Obtener o establecer el còdigo
     */
    @SerializedName("Codigo")
    @Expose
    private int Codigo;

    /**
     * Obtener o establecer el texto
     */
    @SerializedName("Texto")
    @Expose
    public String Texto;

    public int getCodigo() {
        return Codigo;
    }

    public String getTexto() {
        return Texto;
    }
}
