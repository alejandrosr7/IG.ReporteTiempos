package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USUARIO on 15/01/2016.
 */
public class User {


    public User() {
    }

    /**
     * Permite obtener o establecer  el código de empleado
     */
    @SerializedName("CodigoEmpleado")
    @Expose
    private Integer codeuser;

    /**
     * Permite obtener o establecer  el texto
     */
    @SerializedName("Texto")
    @Expose
    private String Texto;

    /**
     * Permite obtener o establecer  el cédula
     */
    @SerializedName("Cedula")
    @Expose
    private Integer cedula;

    /**
     * Permite obtener o establecer  el nombres
     */
    @SerializedName("Nombres")
    @Expose
    private String name;

    /**
     * Permite obtener o establecer  el apellidos
     */
    @SerializedName("Apellidos")
    @Expose
    private String lastname;

    /**
     * Permite obtener o establecer  el usuario
     */
    @SerializedName("Usuario")
    @Expose
    private String user;

    /**
     * Permite obtener o establecer  el gerente
     */
    @SerializedName("Gerente")
    @Expose
    private Boolean manager;

    /**
     * Permite obtener o establecer  el codigo
     */
    @SerializedName("Codigo")
    @Expose
    private Integer code;

    /**
     * Permite obtener o establecer la url de la foto
     */
    @SerializedName("UrlFoto")
    @Expose
    private String urlphoto;

    /**
     * Permite obtener o establecer  el correo
     */
    @SerializedName("Correo")
    @Expose
    private String mail;

    public Integer getCodeuser() {
        return codeuser;
    }

    public void setCodeuser(Integer codeuser) {
        this.codeuser = codeuser;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getManager() {
        return manager;
    }

    public void setManager(Boolean manager) {
        this.manager = manager;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getUrlphoto() {
        return urlphoto;
    }

    public void setUrlphoto(String urlphoto) {
        this.urlphoto = urlphoto;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }
}




