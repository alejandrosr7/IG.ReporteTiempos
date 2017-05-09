package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by mauricio on 9/04/16.
 */
public class Proyect {

    /**
     * Permite obtener o establecer el código del proyecto
     */
    @SerializedName("CodigoProyecto")
    @Expose
    private Integer CodigoProyecto;

    /**
     * Permite obtener o establecer las horas del proyecto
     */
    @SerializedName("Horas")
    @Expose
    private double Horas;

    /**
     * Permite obtener o establecer el nombre del proyecto
     */
    @SerializedName("Nombre")
    @Expose
    private String Nombre;

    /**
     * Permite obtener o establecer la descripción del tipo de estimación
     */
    @SerializedName("DescripcionTipoEstimacion")
    @Expose
    private String descripcionTipoEstimacion;

    /**
     * Permite obtener o establecer  el código del marco del trabajo
     */
    @SerializedName("CodigoMaestroMarcoTrabajo")
    @Expose
    private Integer codigoMaestroMarcoTrabajo;


    public Integer getCodigoProyecto() {
        return CodigoProyecto;
    }

    public double getHoras() {
        return Horas;
    }

    public void setHoras(double horas) {
        Horas = horas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcionTipoEstimacion() {
        return descripcionTipoEstimacion;
    }

    public Integer getCodigoMaestroMarcoTrabajo() {
        return codigoMaestroMarcoTrabajo;
    }
}