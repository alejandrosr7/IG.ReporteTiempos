package com.intergrupo.reportedetiemposig.Model;

import java.util.Date;

/**
 * Created by Usuario on 20/05/2016.
 */
public class ResumTimesForCollaborator {

    /**
     * Permite obtener o establecer  el nombre
     */
    private Integer Identificador;

    private Integer Año ;

    private Integer Mes;

    private Integer Semana;

    private String NombreSemana;

    private String Funcionalidad;

    private String FechaActividad;

    private Double Lunes;

    private Double Martes;

    private Double Miercoles;

    private Double Jueves;

    private Double Viernes;

    private Double Sabado;

    private Double Domingo;

    public Integer getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(Integer identificador) {
        Identificador = identificador;
    }

    public Integer getAño() {
        return Año;
    }

    public void setAño(Integer año) {
        Año = año;
    }

    public Integer getMes() {
        return Mes;
    }

    public void setMes(Integer mes) {
        Mes = mes;
    }

    public Integer getSemana() {
        return Semana;
    }

    public void setSemana(Integer semana) {
        Semana = semana;
    }

    public String getNombreSemana() {
        return NombreSemana;
    }

    public void setNombreSemana(String nombreSemana) {
        NombreSemana = nombreSemana;
    }

    public String getFuncionalidad() {
        return Funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        Funcionalidad = funcionalidad;
    }

    public String getFechaActividad() {
        return FechaActividad;
    }

    public void setFechaActividad(String fechaActividad) {
        FechaActividad = fechaActividad;
    }

    public Double getLunes() {
        return Lunes;
    }

    public void setLunes(Double lunes) {
        Lunes = lunes;
    }

    public Double getMartes() {
        return Martes;
    }

    public void setMartes(Double martes) {
        Martes = martes;
    }

    public Double getMiercoles() {
        return Miercoles;
    }

    public void setMiercoles(Double miercoles) {
        Miercoles = miercoles;
    }

    public Double getJueves() {
        return Jueves;
    }

    public void setJueves(Double jueves) {
        Jueves = jueves;
    }

    public Double getViernes() {
        return Viernes;
    }

    public void setViernes(Double viernes) {
        Viernes = viernes;
    }

    public Double getSabado() {
        return Sabado;
    }

    public void setSabado(Double sabado) {
        Sabado = sabado;
    }

    public Double getDomingo() {
        return Domingo;
    }

    public void setDomingo(Double domingo) {
        Domingo = domingo;
    }
}
