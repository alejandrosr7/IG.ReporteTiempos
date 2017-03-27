package com.intergrupo.reportedetiemposig.Repositories.Test;

import com.intergrupo.reportedetiemposig.Model.ActivityDiscipline;
import com.intergrupo.reportedetiemposig.Model.ClassificationConceptHour;
import com.intergrupo.reportedetiemposig.Model.ConceptHour;
import com.intergrupo.reportedetiemposig.Model.Discipline;
import com.intergrupo.reportedetiemposig.Model.IGLogin;
import com.intergrupo.reportedetiemposig.Model.Manager;
import com.intergrupo.reportedetiemposig.Model.Proyect;
import com.intergrupo.reportedetiemposig.Model.ReportTime;
import com.intergrupo.reportedetiemposig.Model.TiemposResponse;
import com.intergrupo.reportedetiemposig.Model.User;
import com.intergrupo.reportedetiemposig.Model.functionality;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.IReportRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yo on 28/11/15.
 */
public class TestReportRepository implements IReportRepository {


    @Override
    public TiemposResponse<List<Manager>> ListProyects() {
        return null;
    }

    @Override
    public TiemposResponse<List<String>> ListActivities() {
        return null;
    }

    @Override
    public Boolean Register(ReportTime register) {
      /*  TiemposResponse<Boolean> response = new TiemposResponse<Boolean>();
        if (register.getProyect() == null || register.getProyect().equals("")) {
            response.setData(false);
            return response;
        }
        if (register.getActivity() == null || register.getActivity().equals("")) {
            response.setData(false);
            return response;
        }
        if (register.getDate() == null || register.getDate().equals("")) {
            response.setData(false);
            return response;
        }
        if (register.getHour() == 0) {
            response.setData(false);
            return response;
        }
        if (register.getActivityDescription() == null || register.getActivityDescription().equals("")) {
            response.setData(false);
            return response;
        }
        if (register.getRequirements() == null || register.getRequirements().equals("")) {
            response.setData(false);
            return response;
        }
        response.setData(true);*/
        return null;
    }

    @Override
    public List<Manager> GetManager() {
        return null;
    }

    @Override
    public List<ConceptHour> GetConceptHour() {
        return null;
    }

    @Override
    public List<ClassificationConceptHour> GetClassificationConceptHour(int codeTypeHour) {
        return null;
    }

    @Override
    public List<Proyect> GetProyect(int codeManager) {
        return null;
    }

    @Override
    public List<functionality> Getfunctionality(int codeProyect) {
        return null;
    }

    @Override
    public List<Discipline> GetDiscipline(int codeMaster) {
        return null;
    }

    @Override
    public List<ActivityDiscipline> getActivity(int codeDiscipline) {
        return null;
    }

    @Override
    public List<ActivityDiscipline> getFuncionalityActivityStimateForRegister(int codeDiscipline, int codeFuncionality) {
        return null;
    }

    @Override
    public List<Discipline> getActivityDisciplineStimationForRegister(int codeFuncionality) {
        return null;
    }

    @Override
    public Boolean EditReport(ReportTime register) {
        return null;
    }

}

