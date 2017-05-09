package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mauricio on 9/04/16.
 */
public class ClassificationConceptHour {

    @SerializedName("Nombre")
    @Expose
    private String Name;

    @SerializedName("CodigoMaestroTipoHora")
    @Expose
    private Integer codeMasterTypeHour;

    public Integer getCodeMasterTypeHour() {
        return codeMasterTypeHour;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
