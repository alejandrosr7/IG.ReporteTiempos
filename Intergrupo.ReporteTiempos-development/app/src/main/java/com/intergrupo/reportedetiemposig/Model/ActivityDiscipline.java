package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.intergrupo.reportedetiemposig.Util.Constants;

/**
 * Created by leidy on 12/11/2016.
 */

public class ActivityDiscipline {

    /**
     * Permite obtener o establecer  el código de la actividad
     */
    @SerializedName(Constants.CODIGO_ACTIVIDAD)
    @Expose
    private Integer codigoActividad;

    /**
     * Permite obtener o establecer  el codigo de la disciplina
     */
    @SerializedName(Constants.CODIGO_DISCIPLINA)
    @Expose
    private Integer CodigoDisciplina;

    /**
     * Permite obtener o establecer  el código de la funcionalidad
     */
    @SerializedName("CodigoFuncionalidad")
    @Expose
    private Integer codigoFuncionalidad;

    /**
     * Permite obtener o establecer  el codigo de maestro de la actividad
     */
    @SerializedName("CodigoMaestroActividad")
    @Expose
    private Integer codigoMaestroActividad;

    /**
     * Permite obtener o establecer  el codigo del maestro del proceso
     */
    @SerializedName("CodigoMaestroProceso")
    @Expose
    private Integer codigoMaestroProceso;

    /**
     * Permite obtener o establecer  el código del proyecto
     */
    @SerializedName("CodigoProyecto")
    @Expose
    private Integer codigoProyecto;

    /**
     * Permite obtener o establecer  el nombre
     */
    @SerializedName("Nombre")
    @Expose
    private String nombre;

    public Integer getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(Integer codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public Integer getCodigoDisciplina() {
        return CodigoDisciplina;
    }

    public void setCodigoDisciplina(Integer codigoDisciplina) {
        CodigoDisciplina = codigoDisciplina;
    }

    public Integer getCodigoFuncionalidad() {
        return codigoFuncionalidad;
    }

    public void setCodigoFuncionalidad(Integer codigoFuncionalidad) {
        this.codigoFuncionalidad = codigoFuncionalidad;
    }

    public Integer getCodigoMaestroActividad() {
        return codigoMaestroActividad;
    }

    public void setCodigoMaestroActividad(Integer codigoMaestroActividad) {
        this.codigoMaestroActividad = codigoMaestroActividad;
    }

    public Integer getCodigoMaestroProceso() {
        return codigoMaestroProceso;
    }

    public void setCodigoMaestroProceso(Integer codigoMaestroProceso) {
        this.codigoMaestroProceso = codigoMaestroProceso;
    }

    public Integer getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(Integer codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
