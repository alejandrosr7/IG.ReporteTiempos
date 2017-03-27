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

    @SerializedName("CodigoTipoHora")
    @Expose
    private Integer codeTypeHour;

    public Integer getCodeMasterTypeHour() {
        return codeMasterTypeHour;
    }

    public void setCodeMasterTypeHour(Integer codeMasterTypeHour) {
        this.codeMasterTypeHour = codeMasterTypeHour;
    }

    public Integer getCodeTypeHour() {
        return codeTypeHour;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCodeTypeHour(Integer codeTypeHour) {
        this.codeTypeHour = codeTypeHour;
    }
}
