package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

/**
 * Created by USUARIO on 13/08/2016.
 */
public class ViewTimesManagerDetail {

    /**
     * Permite obtener o establecer nombre completo del gerente
     */
    @SerializedName("NombreCompleto")
    @Expose
    private String CollaboratorName;

    /**
     * Permite obtener o establecer  el numero de horas adminitrativas
     */
    @SerializedName("HorasAdministrativas")
    @Expose
    private Double AdministrativeHour;

    /**
     * Permite obtener o establecer las horas de novedades
     */
    @SerializedName("HorasNovedades")
    @Expose
    private Double newnessHour;

    /**
     * Permite obtener o establecer las horas productivas
     */
    @SerializedName("HorasProductivas")
    @Expose
    private Double ProductiveHour;

    /**
     * Permite obtener o establecer el tiempo
     */
    @SerializedName("TiempoTotal")
    @Expose
    private Double TotalTime;

    public String getCollaboratorName() {
        return CollaboratorName;
    }

    public void setCollaboratorName(String collaboratorName) {
        CollaboratorName = collaboratorName;
    }

    public Double getAdministrativeHour() {
        return AdministrativeHour;
    }

    public void setAdministrativeHour(Double administrativeHour) {
        AdministrativeHour = administrativeHour;
    }

    public Double getNewnessHour() {
        return newnessHour;
    }

    public void setNewnessHour(Double newnessHour) {
        this.newnessHour = newnessHour;
    }

    public Double getProductiveHour() {
        return ProductiveHour;
    }

    public void setProductiveHour(Double productiveHour) {
        ProductiveHour = productiveHour;
    }

    public Double getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(Double totalTime) {
        TotalTime = totalTime;
    }

}

