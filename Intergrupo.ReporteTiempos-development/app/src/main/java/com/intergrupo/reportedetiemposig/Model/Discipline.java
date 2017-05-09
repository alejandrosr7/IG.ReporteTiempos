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


    public Integer getCodigoDisciplina() {
        return CodigoDisciplina;
    }

    public String getNombreMaestroProcesoDisciplina() {
        return nombreMaestroProcesoDisciplina;
    }


}
