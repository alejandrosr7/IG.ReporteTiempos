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

    /**
     * Permite obtener o establecer  si es facturable el tipo de hora
     */
    @SerializedName("Facturable")
    @Expose
    private boolean isFacturable;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCodeTypeHour() {
        return codeTypeHour;
    }

    public void setCodeTypeHour(Integer codeTypeHour) {
        this.codeTypeHour = codeTypeHour;
    }

    public boolean isFacturable() {
        return isFacturable;
    }

    public void setIsFacturable(boolean isFacturable) {
        this.isFacturable = isFacturable;
    }


}
