package com.intergrupo.reportedetiemposig.Repositories.Interfaces;

import com.intergrupo.reportedetiemposig.Model.TimesForManager;

import java.util.Date;
import java.util.List;

/**
 * Created by USUARIO on 29/05/2016.
 */
public interface IViewTimesMRepository {

    List<TimesForManager> GetTimesForManager(String idGerentCode, Date fechaInicio, Date fechaFin);
}
