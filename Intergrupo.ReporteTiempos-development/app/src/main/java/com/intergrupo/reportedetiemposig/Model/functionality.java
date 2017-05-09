package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mauricio on 9/04/16.
 */
public class functionality {

    /**
     * Permite obtener o establecer  el código de la funcionalidad
     */
    @SerializedName("CodigoFuncionalidad")
    @Expose
    private Integer CodigoFuncionalidad;

    /**
     * Permite obtener o establecer  el nombre de la funcionalidad
     */
    @SerializedName("NombreFuncionalidad")
    @Expose
    private String NombreFuncionalidad;

    public Integer getCodigoFuncionalidad() {
        return CodigoFuncionalidad;
    }

    public String getNombreFuncionalidad() {
        return NombreFuncionalidad;
    }
}
