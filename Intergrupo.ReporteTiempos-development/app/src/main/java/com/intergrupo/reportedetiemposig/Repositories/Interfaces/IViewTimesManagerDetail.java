package com.intergrupo.reportedetiemposig.Repositories.Interfaces;


import com.intergrupo.reportedetiemposig.Model.ViewTimesManagerDetail;

import java.util.Date;
import java.util.List;

/**
 * Created by USUARIO on 13/08/2016.
 */
public interface IViewTimesManagerDetail {
    List<ViewTimesManagerDetail> GetTimesManagerDetail(String idGerentCode, Date fechaInicio,
                                                       Date fechaFin);

}
