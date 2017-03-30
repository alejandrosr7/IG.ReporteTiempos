package com.intergrupo.reportedetiemposig.Repositories.Interfaces;

import com.intergrupo.reportedetiemposig.Model.ActivityDiscipline;
import com.intergrupo.reportedetiemposig.Model.ClassificationConceptHour;
import com.intergrupo.reportedetiemposig.Model.ConceptHour;
import com.intergrupo.reportedetiemposig.Model.Discipline;
import com.intergrupo.reportedetiemposig.Model.IGLogin;
import com.intergrupo.reportedetiemposig.Model.Manager;
import com.intergrupo.reportedetiemposig.Model.Proyect;
import com.intergrupo.reportedetiemposig.Model.ReportTime;
import com.intergrupo.reportedetiemposig.Model.TiemposResponse;
import com.intergrupo.reportedetiemposig.Model.functionality;

import java.util.List;

/**
 * Created by yo on 28/11/15.
 */
public interface IReportRepository {

    TiemposResponse<List<Manager>> ListProyects();

    TiemposResponse<List<String>> ListActivities();

    Boolean Register(ReportTime register);

    List<Manager> GetManager();

    List<ConceptHour> GetConceptHour();

    List<ClassificationConceptHour> GetClassificationConceptHour(int codeTypeHour);

    List<Proyect> GetProyect(int codeManager);

    List<functionality> Getfunctionality(int codeProyect);

    List<Discipline> GetDiscipline(int codeMaster);

    List<Discipline> getActivityDisciplineStimationForRegister(int codeFuncionality);


    List<ActivityDiscipline> getActivity(int codeDiscipline);

    List<ActivityDiscipline> getFuncionalityActivityStimateForRegister(int codeDiscipline, int
            codeFuncionality);


    Boolean EditReport(ReportTime register);
}
