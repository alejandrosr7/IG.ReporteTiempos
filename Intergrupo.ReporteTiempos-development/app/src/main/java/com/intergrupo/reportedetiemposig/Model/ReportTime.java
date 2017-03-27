package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by yo on 24/11/15.
 */
public class ReportTime {

    /**
     * Permite obtener o establecer  el código de la actividad
     */
    @SerializedName("CodigoActividad")
    @Expose
    private Integer CodigoActividad;

    /**
     * Permite obtener o establecer si es actividad completa
     */
    @SerializedName("ActividadCompletada")
    @Expose
    private Boolean actividadCompletada;

    /**
     * Permite obtener o establecer  el código de la disciplina
     */
    @SerializedName("CodigoDisciplina")
    @Expose
    private Integer CodigoDisciplina;

    /**
     * Permite obtener o establecer  el código del empleado
     */
    @SerializedName("CodigoEmpleado")
    @Expose
    private Integer codigoEmpleado;

    /**
     * Permite obtener o establecer  el código de estado de integración
     */
    @SerializedName("CodigoEstadoIntegracion")
    @Expose
    private Integer codigoEstadoIntegracion;

    /**
     * Permite obtener o establecer  el código de la funcionaidad
     */
    @SerializedName("CodigoFuncionalidad")
    @Expose
    private Integer CodigoFuncionalidad;

    /**
     * Permite obtener o establecer  el código maestro
     */
    @SerializedName("CodigoMaestro")
    @Expose
    private Integer codigoMaestro;

    /**
     * Permite obtener o establecer  el código de maestro de actividad
     */
    @SerializedName("CodigoMaestroActividad")
    @Expose
    private Integer codigoMaestroActividad;

    /**
     * Permite obtener o establecer  el descripción
     */
    @SerializedName("Descripcion")
    @Expose
    private String Descripcion;

    /**
     * Permite obtener o establecer  el fecha de actividad
     */
    @SerializedName("FechaActividad")
    @Expose
    private Date FechaActividad;

    /**
     * Permite obtener o establecer  el nombre de horas
     */
    @SerializedName("Horas")
    @Expose
    private double Horas;

    public Integer getCodigoActividad() {
        return CodigoActividad;
    }

    public void setCodigoActividad(Integer codigoActividad) {
        CodigoActividad = codigoActividad;
    }

    public Boolean getActividadCompletada() {
        return actividadCompletada;
    }

    public void setActividadCompletada(Boolean actividadCompletada) {
        this.actividadCompletada = actividadCompletada;
    }

    public Integer getCodigoDisciplina() {
        return CodigoDisciplina;
    }

    public void setCodigoDisciplina(Integer codigoDisciplina) {
        CodigoDisciplina = codigoDisciplina;
    }

    public Integer getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Integer codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public Integer getCodigoEstadoIntegracion() {
        return codigoEstadoIntegracion;
    }

    public void setCodigoEstadoIntegracion(Integer codigoEstadoIntegracion) {
        this.codigoEstadoIntegracion = codigoEstadoIntegracion;
    }

    public Integer getCodigoFuncionalidad() {
        return CodigoFuncionalidad;
    }

    public void setCodigoFuncionalidad(Integer codigoFuncionalidad) {
        CodigoFuncionalidad = codigoFuncionalidad;
    }

    public Integer getCodigoMaestro() {
        return codigoMaestro;
    }

    public void setCodigoMaestro(Integer codigoMaestro) {
        this.codigoMaestro = codigoMaestro;
    }

    public Integer getCodigoMaestroActividad() {
        return codigoMaestroActividad;
    }

    public void setCodigoMaestroActividad(Integer codigoMaestroActividad) {
        this.codigoMaestroActividad = codigoMaestroActividad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Date getFechaActividad() {
        return FechaActividad;
    }

    public void setFechaActividad(Date fechaActividad) {
        FechaActividad = fechaActividad;
    }

    public double getHoras() {
        return Horas;
    }

    public void setHoras(double horas) {
        Horas = horas;
    }
}
