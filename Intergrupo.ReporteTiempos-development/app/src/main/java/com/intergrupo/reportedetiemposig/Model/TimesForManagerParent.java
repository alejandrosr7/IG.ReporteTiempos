package com.intergrupo.reportedetiemposig.Model;

/**
 * Created by USUARIO on 30/05/2016.
 */
public class TimesForManagerParent {

    /**
     * Permite obtener o establecer  el nombre del proyecto
     */
    private String proyectM;

    /**
     * Permite obtener o establecer  el tiempo fatante por reportar
     */
    private Double timesRed;

    /**
     * Permite obtener o establecer  el tiempo reportado
     */
    private Double timesGreen;

    public TimesForManagerParent() {
        timesRed = 0d;
        timesGreen = 0d;
    }

    public Double getTimesRed() {
        return timesRed;
    }

    public void setTimesRed(Double timesRed) {
        this.timesRed = timesRed;
    }

    public Double getTimesGreen() {
        return timesGreen;
    }

    public String getProyectM() {
        return proyectM;
    }

    public void setProyectM(String proyectM) {
        this.proyectM = proyectM;
    }

    public void addTimesGreen(Double HourActivity) {

        timesGreen += HourActivity;
        timesRed += HourActivity;

        if (timesRed < 0) {

            timesRed = 0d;

        }

    }

}

