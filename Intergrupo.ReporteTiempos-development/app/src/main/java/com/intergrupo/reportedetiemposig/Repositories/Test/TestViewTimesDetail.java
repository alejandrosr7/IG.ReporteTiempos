package com.intergrupo.reportedetiemposig.Repositories.Test;

import com.intergrupo.reportedetiemposig.Model.ViewTimesManagerDetail;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.IViewTimesManagerDetail;

import java.util.Date;
import java.util.List;

/**
 * Created by USUARIO on 14/08/2016.
 */
public class TestViewTimesDetail implements IViewTimesManagerDetail {
    @Override
    public List<ViewTimesManagerDetail> GetTimesManagerDetail(String idGerentCode, Date
            fechaInicio, Date fechaFin) {
        return null;
    }
}
