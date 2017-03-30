package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USUARIO on 29/05/2016.
 */
public class TimesForManager {

    public TimesForManager() {
    }

    public String getProyectName() {
        return ProyectName;
    }

    public String getIdCollaboratorName() {
        return IdCollaboratorName;
    }

    public String getIdCollaboratorLast() {
        return IdCollaboratorLast;
    }

    public Double getRedTime() {
        return RedTime;
    }

    public Double getHourActivity() {
        return HourActivity;
    }

    public void setHourActivity(Double hourActivity) {
        HourActivity = hourActivity;
    }

    /**
     * Permite obtener o establecer el nombre del proyecto
     */
    @SerializedName("NombreProyecto")
    @Expose
    private String ProyectName;

    /**
     * Permite obtener o establecer el nombre del colaborador
     */
    @SerializedName("NombreColaborador")
    @Expose
    private String IdCollaboratorName;

    /**
     * Permite obtener o establecer  el apellido del colaborador
     */
    @SerializedName("ApellidosColaborador")
    @Expose
    private String IdCollaboratorLast;

    /**
     * Permite obtener o establecer  las horas de la actividad
     */
    @SerializedName("Horas")
    @Expose
    private Double HourActivity;

    /**
     * Permite obtener o establecer  las horas restantes
     */
    @SerializedName("HorasRestantesProyecto")
    @Expose
    private Double RedTime;
}
