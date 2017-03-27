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
     * Permite obtener o establecer  el código del proyecto
     */
    @SerializedName("CodigoProyecto")
    @Expose
    private Integer CodigoProyecto;

    /**
     * Permite obtener o establecer la descripción de la funcionalidad
     */
    @SerializedName("DescipcionFuncionalidad")
    @Expose
    private String DescipcionFuncionalidad;

    /**
     * Permite obtener o establecer las horas de la funcionalidad
     */
    @SerializedName("HorasFuncionalidad")
    @Expose
    private double HorasFuncionalidad;

    /**
     * Permite obtener o establecer  el nombre de la funcionalidad
     */
    @SerializedName("NombreFuncionalidad")
    @Expose
    private String NombreFuncionalidad;

    public Integer getCodigoFuncionalidad() {
        return CodigoFuncionalidad;
    }

    public void setCodigoFuncionalidad(Integer codigoFuncionalidad) {
        CodigoFuncionalidad = codigoFuncionalidad;
    }

    public Integer getCodigoProyecto() {
        return CodigoProyecto;
    }

    public void setCodigoProyecto(Integer codigoProyecto) {
        CodigoProyecto = codigoProyecto;
    }

    public String getDescipcionFuncionalidad() {
        return DescipcionFuncionalidad;
    }

    public void setDescipcionFuncionalidad(String descipcionFuncionalidad) {
        DescipcionFuncionalidad = descipcionFuncionalidad;
    }

    public double getHorasFuncionalidad() {
        return HorasFuncionalidad;
    }

    public void setHorasFuncionalidad(double horasFuncionalidad) {
        HorasFuncionalidad = horasFuncionalidad;
    }

    public String getNombreFuncionalidad() {
        return NombreFuncionalidad;
    }

    public void setNombreFuncionalidad(String nombreFuncionalidad) {
        NombreFuncionalidad = nombreFuncionalidad;
    }


}
