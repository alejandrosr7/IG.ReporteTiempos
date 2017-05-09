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

    private Integer Año;

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

    public String getNombreSemana() {
        return NombreSemana;
    }

    public String getFuncionalidad() {
        return Funcionalidad;
    }

    public String getFechaActividad() {
        return FechaActividad;
    }

    public Double getLunes() {
        return Lunes;
    }

    public Double getMartes() {
        return Martes;
    }

    public Double getMiercoles() {
        return Miercoles;
    }

    public Double getJueves() {
        return Jueves;
    }

    public Double getViernes() {
        return Viernes;
    }

    public Double getSabado() {
        return Sabado;
    }

    public Double getDomingo() {
        return Domingo;
    }
}
