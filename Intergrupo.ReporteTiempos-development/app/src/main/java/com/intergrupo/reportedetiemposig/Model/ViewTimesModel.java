package com.intergrupo.reportedetiemposig.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Usuario on 14/05/2016.
 */
public class ViewTimesModel implements Parcelable {

    /**
     * Permite obtener o establecer  código de la actividad
     */
    private Integer CodigoActividad;

    /**
     * Permite obtener o establecer el código del gerente
     */
    private Integer CodigoGerente;

    /**
     * Permite obtener o establecer  el nombre del gerente
     */
    private String NombreGerente;

    /**
     * Permite obtener o establecer  el apellidos
     */
    private String ApellidosGerente;

    /**
     * Permite obtener o establecer  el código proyecto
     */
    private Integer CodigoProyecto;

    /**
     * Permite obtener o establecer  el nombre del proyecto
     */
    private String NombreProyecto;

    /**
     * Permite obtener o establecer código de la funcionalidad
     */
    private Integer CodigoFuncionalidad;

    /**
     * Permite obtener o establecer el nombre de la funcionaidad
     */
    private String NombreFuncionalidad;

    /**
     * Permite obtener o establecer  el código de la disciplina
     */
    private Integer CodigoDisciplina;

    /**
     * Permite obtener o establecer el nombre de la disciplina
     */
    private String NombreDisciplina;

    /**
     * Permite obtener o establecer el descripción
     */
    private String Descripcion;

    /**
     * Permite obtener o establecer el código del tipo de hora
     */
    private Integer CodigoMaestroTipoHora;

    /**
     * Permite obtener o establecer nombre del maestro del tipo hora
     */
    private String NombreMaestroTipoHora;

    /**
     * Permite obtener o establecer código de tipo de hora
     */
    private Integer CodigoTipoHora;

    /**
     * Permite obtener o establecer nombre de tipo de hora
     */
    private String NombreTipoHora;

    /**
     * Permite obtener o establecer la fecha de actividad
     */
    private String FechaActividad;

    /**
     * Permite obtener o establecer las horas
     */
    private Double Horas;

    /**
     * Permite obtener o establecer el código de estado de integración
     */
    private Integer CodigoEstadoIntegracion;

    /**
     * Permite obtener o establecer nombre de estado integración
     */
    private String NombreEstadoIntegracion;

    /**
     * Permite obtener o establecer código de agrupación
     */
    private Integer CodigoAgrupacionActividad;

    /**
     * Permite obtener o establecer el código de empleado
     */
    private Integer CodigoEmpleado;

    /**
     * Permite obtener o establecer  el nombre empleado
     */
    private String NombreEmpleado;

    /**
     * Permite obtener o establecer apellidos de empleado
     */
    private String ApellidoEmpleado;


    /**
     * Permite obtener o establecer usuario aprobación
     */
    private String UsuarioAprobacion;

    /**
     * Permite obtener o establecer  el proyecto se encuentra activa
     */
    private Boolean ProyectoActivo;

    /**
     * Permite obtener o establecer nombre actividad
     */
    private String NombreActividad;

    /**
     * Permite obtener o establecer actividad esta completada
     */
    private Boolean ActividadCompletada;

    /**
     * Permite obtener o establecer el nombre maestro de proceso
     */
    private String NombreMaestroProceso;

    /**
     * Permite obtener o establecer el nombre de la actividad
     */
    private String NombreMaestroActividad;

    /**
     * Permite obtener o establecer el código maestro de la actividad
     */
    private Integer CodigoMaestroActividad;

    public Integer getCodigoActividad() {
        return CodigoActividad;
    }

    public void setCodigoActividad(Integer codigoActividad) {
        CodigoActividad = codigoActividad;
    }

    public String getNombreGerente() {
        return NombreGerente;
    }

    public String getApellidosGerente() {
        return ApellidosGerente;
    }

    public Integer getCodigoProyecto() {
        return CodigoProyecto;
    }

    public void setCodigoProyecto(Integer codigoProyecto) {
        CodigoProyecto = codigoProyecto;
    }

    public String getNombreProyecto() {
        return NombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        NombreProyecto = nombreProyecto;
    }

    public Integer getCodigoFuncionalidad() {
        return CodigoFuncionalidad;
    }

    public String getNombreFuncionalidad() {
        return NombreFuncionalidad;
    }

    public Integer getCodigoDisciplina() {
        return CodigoDisciplina;
    }

    public String getNombreDisciplina() {
        return NombreDisciplina;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Integer getCodigoMaestroTipoHora() {
        return CodigoMaestroTipoHora;
    }

    public String getNombreMaestroTipoHora() {
        return NombreMaestroTipoHora;
    }

    public String getNombreTipoHora() {
        return NombreTipoHora;
    }

    public String getFechaActividad() {
        return FechaActividad;
    }

    public Double getHoras() {
        return Horas;
    }

    public void setHoras(Double horas) {
        Horas = horas;
    }

    public Boolean getProyectoActivo() {
        return ProyectoActivo;
    }

    public Boolean getActividadCompletada() {
        return ActividadCompletada;
    }

    public String getNombreMaestroProceso() {
        return NombreMaestroProceso;
    }

    public String getNombreMaestroActividad() {
        return NombreMaestroActividad;
    }

    public Integer getCodigoMaestroActividad() {
        return CodigoMaestroActividad;
    }

    public ViewTimesModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.CodigoActividad);
        dest.writeInt(this.CodigoGerente);
        dest.writeString(this.NombreGerente);
        dest.writeString(this.ApellidosGerente);
        dest.writeInt(this.CodigoProyecto);
        dest.writeString(this.NombreProyecto);
        dest.writeInt(this.CodigoFuncionalidad);
        dest.writeString(this.NombreFuncionalidad);
        dest.writeInt(this.CodigoDisciplina);
        dest.writeString(this.NombreDisciplina);
        dest.writeString(this.Descripcion);
        dest.writeInt(this.CodigoMaestroTipoHora);
        dest.writeString(this.NombreMaestroTipoHora);
        dest.writeInt(this.CodigoTipoHora);
        dest.writeString(this.NombreTipoHora);
        dest.writeString(this.FechaActividad);
        dest.writeDouble(this.Horas);
        dest.writeInt(this.CodigoEstadoIntegracion);
        dest.writeString(this.NombreEstadoIntegracion);
        dest.writeInt(this.CodigoAgrupacionActividad == null ? 0 : this.CodigoAgrupacionActividad);
        dest.writeInt(this.CodigoEmpleado);
        dest.writeString(this.NombreEmpleado);
        dest.writeString(this.ApellidoEmpleado);
        dest.writeString(this.UsuarioAprobacion == null ? "" : this.UsuarioAprobacion);
        dest.writeInt(this.CodigoActividad);
        dest.writeString(this.NombreActividad);
        dest.writeInt(this.ActividadCompletada ? 1 : 0);
        dest.writeString(this.NombreMaestroProceso);
        dest.writeString(this.NombreMaestroActividad);
        dest.writeInt(this.CodigoMaestroActividad);
    }

    public ViewTimesModel(Parcel in) {
        CodigoActividad = in.readInt();
        CodigoGerente = in.readInt();
        NombreGerente = in.readString();
        ApellidosGerente = in.readString();
        CodigoProyecto = in.readInt();
        NombreProyecto = in.readString();
        CodigoFuncionalidad = in.readInt();
        NombreFuncionalidad = in.readString();
        CodigoDisciplina = in.readInt();
        NombreDisciplina = in.readString();
        Descripcion = in.readString();
        CodigoMaestroTipoHora = in.readInt();
        NombreMaestroTipoHora = in.readString();
        CodigoTipoHora = in.readInt();
        NombreTipoHora = in.readString();
        FechaActividad = in.readString();
        Horas = in.readDouble();
        CodigoEstadoIntegracion = in.readInt();
        NombreEstadoIntegracion = in.readString();
        CodigoAgrupacionActividad = in.readInt();
        CodigoEmpleado = in.readInt();
        NombreEmpleado = in.readString();
        ApellidoEmpleado = in.readString();
        UsuarioAprobacion = in.readString();
        CodigoActividad = in.readInt();
        NombreActividad = in.readString();
        ActividadCompletada = in.readInt() == 1;
        NombreMaestroProceso = in.readString();
        NombreMaestroActividad = in.readString();
        CodigoMaestroActividad = in.readInt();
    }

    public static final Creator<ViewTimesModel> CREATOR = new Creator<ViewTimesModel>() {
        @Override
        public ViewTimesModel createFromParcel(Parcel in) {
            return new ViewTimesModel(in);
        }

        @Override
        public ViewTimesModel[] newArray(int size) {
            return new ViewTimesModel[size];
        }
    };

}
