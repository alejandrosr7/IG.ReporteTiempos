package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mauricio on 8/04/16.
 */
public class Manager {

    /**
     * Permite obtener o establecer  el código del empleado
     */
    @SerializedName("CodigoEmpleado")
    @Expose
    private Integer codeUser;
    
    /**
     * Permite obtener o establecer el nombre del empleado
     */
    @SerializedName("Nombres")
    @Expose
    private String firtNames;

    /**
     * Permite obtener o establecer el apellido del empleado
     */
    @SerializedName("Apellidos")
    @Expose
    private String lastNames;

    /**
     * Permite obtener o establecer el usuario del empleado
     */
    @SerializedName("usuario")
    @Expose
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getCodeUser() {
        return codeUser;
    }

    public String getFirtNames() {
        return firtNames;
    }
    
    public String getLastNames() {
        return lastNames;
    }
}
