package com.intergrupo.reportedetiemposig.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mauricio on 9/04/16.
 */
public class ConceptHour {

    /**
     * Permite obtener o establecer  el código de tipo de hora
     */
    @SerializedName("CodigoTipoHora")
    @Expose
    private Integer codeTypeHour;

    /**
     * Permite obtener o establecer  el nombre del tipo de hora
     */
    @SerializedName("Nombre")
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCodeTypeHour() {
        return codeTypeHour;
    }
}
