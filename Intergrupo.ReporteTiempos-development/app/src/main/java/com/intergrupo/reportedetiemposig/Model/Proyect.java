package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by mauricio on 9/04/16.
 */
public class Proyect {

    /**
     * Permite obtener o establecer  si el proyecto se encuentra activo
     */
    @SerializedName("Activo")
    @Expose
    private Boolean Activo;

    /**
     * Permite obtener o establecer el código del cliente
     */
    @SerializedName("CodigoCliente")
    @Expose
    private Integer CodigoCliente;

    /**
     * Permite obtener o establecer el código del gerente
     */
    @SerializedName("CodigoGerente")
    @Expose
    private Integer CodigoGerente;

    /**
     * Permite obtener o establecer el código de operación
     */
    @SerializedName("CodigoOperacion")
    @Expose
    private Integer CodigoOperacion;

    /**
     * Permite obtener o establecer el código de la orden de trabajo
     */
    @SerializedName("CodigoOrdenTrabajo")
    @Expose
    private Integer CodigoOrdenTrabajo;

    /**
     * Permite obtener o establecer el código del proyecto
     */
    @SerializedName("CodigoProyecto")
    @Expose
    private Integer CodigoProyecto;

    /**
     * Permite obtener o establecer  el código del tipo de proyecto
     */
    @SerializedName("CodigoTipoProyecto")
    @Expose
    private Integer CodigoTipoProyecto;

    /**
     * Permite obtener o establecer la descripción del proyecto
     */
    @SerializedName("Descripcion")
    @Expose
    private String Descripcion;

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
     * Permite obtener o establecer el nombre del cliente
     */
    @SerializedName("NombreCliente")
    @Expose
    private String NombreCliente;

    /**
     * Permite obtener o establecer la fecha de inicio del proyecto
     */
    @SerializedName("FechaInicio")
    @Expose
    private String fechaInicio;

    /**
     * Permite obtener o establecer la fecha fin del proyecto
     */
    @SerializedName("FechaFin")
    @Expose
    private String fechaFin;

    /**
     * Permite obtener o establecer el código de tipo de estimación
     */
    @SerializedName("CodigoTipoEstimacion")
    @Expose
    private Integer codigoTipoEstimacion;

    /**
     * Permite obtener o establecer  el nombre del tipo de estimación
     */
    @SerializedName("NombreTipoEstimacion")
    @Expose
    private String nombreTipoEstimacion;

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

    /**
     * Permite obtener o establecer el nombre del marco de trabajo
     */
    @SerializedName("NombreMaestroMarcoTrabajo")
    @Expose
    private String nombreMaestroMarcoTrabajo;

    /**
     * Permite obtener o establecer código técnico de la estimación
     */
    @SerializedName("CodigoTecnicaEstimacion")
    @Expose
    private Integer codigoTecnicaEstimacion;

    /**
     * Permite obtener o establecer nombre técnico de la estimación
     */
    @SerializedName("NombreTecnicaEstimacion")
    @Expose
    private String nombreTecnicaEstimacion;

    /**
     * Permite obtener o establecer  la llave técnica de la estimación
     */
    @SerializedName("LlaveTecnicaEstimacion")
    @Expose
    private String llaveTecnicaEstimacion;

    /**
     * Permite obtener o establecer  el nombre del archivo de la estimación
     */
    @SerializedName("NombreArchivoEstimacion")
    @Expose
    private String nombreArchivoEstimacion;

    /**
     * Permite obtener o establecer  el nombre de la operación
     */
    @SerializedName("NombreOperacion")
    @Expose
    private String NombreOperacion;

    /**
     * Permite obtener o establecer  el nombre de la orden de trabajo
     */
    @SerializedName("NombreOrdenTrabajo")
    @Expose
    private String NombreOrdenTrabajo;

    public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean activo) {
        Activo = activo;
    }

    public Integer getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        CodigoCliente = codigoCliente;
    }

    public Integer getCodigoGerente() {
        return CodigoGerente;
    }

    public void setCodigoGerente(Integer codigoGerente) {
        CodigoGerente = codigoGerente;
    }

    public Integer getCodigoOperacion() {
        return CodigoOperacion;
    }

    public void setCodigoOperacion(Integer codigoOperacion) {
        CodigoOperacion = codigoOperacion;
    }

    public Integer getCodigoOrdenTrabajo() {
        return CodigoOrdenTrabajo;
    }

    public void setCodigoOrdenTrabajo(Integer codigoOrdenTrabajo) {
        CodigoOrdenTrabajo = codigoOrdenTrabajo;
    }

    public Integer getCodigoProyecto() {
        return CodigoProyecto;
    }

    public void setCodigoProyecto(Integer codigoProyecto) {
        CodigoProyecto = codigoProyecto;
    }

    public Integer getCodigoTipoProyecto() {
        return CodigoTipoProyecto;
    }

    public void setCodigoTipoProyecto(Integer codigoTipoProyecto) {
        CodigoTipoProyecto = codigoTipoProyecto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
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

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getCodigoTipoEstimacion() {
        return codigoTipoEstimacion;
    }

    public void setCodigoTipoEstimacion(Integer codigoTipoEstimacion) {
        this.codigoTipoEstimacion = codigoTipoEstimacion;
    }

    public String getNombreTipoEstimacion() {
        return nombreTipoEstimacion;
    }

    public void setNombreTipoEstimacion(String nombreTipoEstimacion) {
        this.nombreTipoEstimacion = nombreTipoEstimacion;
    }

    public String getDescripcionTipoEstimacion() {
        return descripcionTipoEstimacion;
    }

    public void setDescripcionTipoEstimacion(String descripcionTipoEstimacion) {
        this.descripcionTipoEstimacion = descripcionTipoEstimacion;
    }

    public Integer getCodigoMaestroMarcoTrabajo() {
        return codigoMaestroMarcoTrabajo;
    }

    public void setCodigoMaestroMarcoTrabajo(Integer codigoMaestroMarcoTrabajo) {
        this.codigoMaestroMarcoTrabajo = codigoMaestroMarcoTrabajo;
    }

    public String getNombreMaestroMarcoTrabajo() {
        return nombreMaestroMarcoTrabajo;
    }

    public void setNombreMaestroMarcoTrabajo(String nombreMaestroMarcoTrabajo) {
        this.nombreMaestroMarcoTrabajo = nombreMaestroMarcoTrabajo;
    }

    public Integer getCodigoTecnicaEstimacion() {
        return codigoTecnicaEstimacion;
    }

    public void setCodigoTecnicaEstimacion(Integer codigoTecnicaEstimacion) {
        this.codigoTecnicaEstimacion = codigoTecnicaEstimacion;
    }

    public String getNombreTecnicaEstimacion() {
        return nombreTecnicaEstimacion;
    }

    public void setNombreTecnicaEstimacion(String nombreTecnicaEstimacion) {
        this.nombreTecnicaEstimacion = nombreTecnicaEstimacion;
    }

    public String getLlaveTecnicaEstimacion() {
        return llaveTecnicaEstimacion;
    }

    public void setLlaveTecnicaEstimacion(String llaveTecnicaEstimacion) {
        this.llaveTecnicaEstimacion = llaveTecnicaEstimacion;
    }

    public String getNombreArchivoEstimacion() {
        return nombreArchivoEstimacion;
    }

    public void setNombreArchivoEstimacion(String nombreArchivoEstimacion) {
        this.nombreArchivoEstimacion = nombreArchivoEstimacion;
    }

    public String getNombreOperacion() {
        return NombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        NombreOperacion = nombreOperacion;
    }

    public String getNombreOrdenTrabajo() {
        return NombreOrdenTrabajo;
    }

    public void setNombreOrdenTrabajo(String nombreOrdenTrabajo) {
        NombreOrdenTrabajo = nombreOrdenTrabajo;
    }
}