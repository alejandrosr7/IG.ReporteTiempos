package com.intergrupo.reportedetiemposig.Repositories.Test;

import com.intergrupo.reportedetiemposig.Model.ActivityDiscipline;
import com.intergrupo.reportedetiemposig.Model.ClassificationConceptHour;
import com.intergrupo.reportedetiemposig.Model.ConceptHour;
import com.intergrupo.reportedetiemposig.Model.Discipline;
import com.intergrupo.reportedetiemposig.Model.Manager;
import com.intergrupo.reportedetiemposig.Model.Proyect;
import com.intergrupo.reportedetiemposig.Model.ReportTime;
import com.intergrupo.reportedetiemposig.Model.functionality;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.IReportRepository;

import java.util.List;

/**
 * Created by yo on 28/11/15.
 */
public class TestReportRepository implements IReportRepository {

    @Override
    public Boolean Register(ReportTime register) {
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

