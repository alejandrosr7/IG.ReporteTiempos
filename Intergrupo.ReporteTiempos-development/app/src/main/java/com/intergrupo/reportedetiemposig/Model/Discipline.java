package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by leidy on 12/11/16.
 */
public class Discipline {

    /**
     * Permite obtener o establecer  el codigo de disciplina
     */
    @SerializedName("CodigoDisciplina")
    @Expose
    private Integer CodigoDisciplina;

    /**
     * Permite obtener o establecer  el código de la funcionalidad
     */
    @SerializedName("CodigoFuncionalidad")
    @Expose
    private Integer codigoFuncionalidad;

    /**
     * Permite obtener o establecer  el código del proceso
     */
    @SerializedName("CodigoMaestroProceso")
    @Expose
    private Integer codigoMaestroProceso;

    /**
     * Permite obtener o establecer  el códugo del proyecto
     */
    @SerializedName("CodigoProyecto")
    @Expose
    private Integer codigoProyecto;

    /**
     * Permite obtener o establecer  las horas ejecutadas de la disciplina
     */
    @SerializedName("HorasEjecutadasDisciplina")
    @Expose
    private int horasEjecutadasDisciplina;

    /**
     * Permite obtener o establecer  las horas ejecutadas de a funcionnalidad
     */
    @SerializedName("HorasEjecutadasFuncionalidad")
    @Expose
    private Integer horasEjecutadasFuncionalidad;

    /**
     * Permite obtener o establecer  las horas estimadas de la disciplina
     */
    @SerializedName("HorasEstimadasDisciplina")
    @Expose
    private Integer horasEstimadasDisciplina;

    /**
     * Permite obtener o establecer  las horas de la funcionalidad
     */
    @SerializedName("HorasFuncionalidad")
    @Expose
    private Integer horasFuncionalidad;

    /**
     * Permite obtener o establecer  las horas restantes de la disciplina
     */
    @SerializedName("HorasRestantesDisciplina")
    @Expose
    private Integer horasRestantesDisciplina;

    /**
     * Permite obtener o establecer  las horas restantes de la funcionaidad
     */
    @SerializedName("HorasRestantesFuncionalidad")
    @Expose
    private Integer horasRestantesFuncionalidad;

    /**
     * Permite obtener o establecer el nombre de la disciplina
     */
    @SerializedName("NombreDisciplina")
    @Expose
    private String nombreDisciplina;

    /**
     * Permite obtener o establecer  el nombre de la funcionalidad
     */
    @SerializedName("NombreFuncionalidad")
    @Expose
    private String nombreFuncionalidad;

    /**
     * Permite obtener o establecer  el nombre del proceso
     */
    @SerializedName("NombreMaestroProceso")
    @Expose
    private String nombreMaestroProceso;

    /**
     * Permite obtener o establecer  el nombre del proceso
     */
    @SerializedName("NombreMaestroProcesoDisciplina")
    @Expose
    private String nombreMaestroProcesoDisciplina;

    /**
     * Permite obtener o establecer  el porcentaje del avance de la disciplina
     */
    @SerializedName("PorcentajeAvanceDisciplina")
    @Expose
    private Double porcentajeAvanceDisciplina;

    /**
     * Permite obtener o establecer el porcetaje del avance de la funcionalidad
     */
    @SerializedName("PorcentajeAvanceFuncionalidad")
    @Expose
    private Double porcentajeAvanceFuncionalidad;

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

    public Integer getHorasEjecutadasDisciplina() {
        return horasEjecutadasDisciplina;
    }

    public void setHorasEjecutadasDisciplina(Integer horasEjecutadasDisciplina) {
        this.horasEjecutadasDisciplina = horasEjecutadasDisciplina;
    }

    public Integer getHorasEjecutadasFuncionalidad() {
        return horasEjecutadasFuncionalidad;
    }

    public void setHorasEjecutadasFuncionalidad(Integer horasEjecutadasFuncionalidad) {
        this.horasEjecutadasFuncionalidad = horasEjecutadasFuncionalidad;
    }

    public Integer getHorasEstimadasDisciplina() {
        return horasEstimadasDisciplina;
    }

    public void setHorasEstimadasDisciplina(Integer horasEstimadasDisciplina) {
        this.horasEstimadasDisciplina = horasEstimadasDisciplina;
    }

    public Integer getHorasFuncionalidad() {
        return horasFuncionalidad;
    }

    public void setHorasFuncionalidad(Integer horasFuncionalidad) {
        this.horasFuncionalidad = horasFuncionalidad;
    }

    public Integer getHorasRestantesDisciplina() {
        return horasRestantesDisciplina;
    }

    public void setHorasRestantesDisciplina(Integer horasRestantesDisciplina) {
        this.horasRestantesDisciplina = horasRestantesDisciplina;
    }

    public Integer getHorasRestantesFuncionalidad() {
        return horasRestantesFuncionalidad;
    }

    public void setHorasRestantesFuncionalidad(Integer horasRestantesFuncionalidad) {
        this.horasRestantesFuncionalidad = horasRestantesFuncionalidad;
    }

    public String getNombreDisciplina() {
        return nombreDisciplina;
    }

    public void setNombreDisciplina(String nombreDisciplina) {
        this.nombreDisciplina = nombreDisciplina;
    }

    public String getNombreFuncionalidad() {
        return nombreFuncionalidad;
    }

    public void setNombreFuncionalidad(String nombreFuncionalidad) {
        this.nombreFuncionalidad = nombreFuncionalidad;
    }

    public String getNombreMaestroProceso() {
        return nombreMaestroProceso;
    }

    public void setNombreMaestroProceso(String nombreMaestroProceso) {
        this.nombreMaestroProceso = nombreMaestroProceso;
    }

    public String getNombreMaestroProcesoDisciplina() {
        return nombreMaestroProcesoDisciplina;
    }

    public void setNombreMaestroProcesoDisciplina(String nombreMaestroProcesoDisciplina) {
        this.nombreMaestroProcesoDisciplina = nombreMaestroProcesoDisciplina;
    }

    public Double getPorcentajeAvanceDisciplina() {
        return porcentajeAvanceDisciplina;
    }

    public void setPorcentajeAvanceDisciplina(Double porcentajeAvanceDisciplina) {
        this.porcentajeAvanceDisciplina = porcentajeAvanceDisciplina;
    }

    public Double getPorcentajeAvanceFuncionalidad() {
        return porcentajeAvanceFuncionalidad;
    }

    public void setPorcentajeAvanceFuncionalidad(Double porcentajeAvanceFuncionalidad) {
        this.porcentajeAvanceFuncionalidad = porcentajeAvanceFuncionalidad;
    }
}
