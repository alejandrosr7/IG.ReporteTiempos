package com.intergrupo.reportedetiemposig.Repositories.Production;

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

import java.util.List;

import retrofit.RetrofitError;

/**
 * Created by yo on 28/11/15.
 */
public class ReportRepository implements IReportRepository{


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
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            boolean respuesta = client.Register(register);
            return respuesta;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
            return false;
        }
    }

    @Override
    public List<Manager> GetManager() {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            List<Manager> managerList = client.getManager();
            return managerList;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }

    @Override
    public List<ConceptHour> GetConceptHour() {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            List<ConceptHour> conceptHourList = client.GetConceptHour();
            return conceptHourList;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }

    @Override
    public List<ClassificationConceptHour> GetClassificationConceptHour(int codeTypeHour) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            List<ClassificationConceptHour> ClassificationConceptHourList = client.GetClassificationConceptHour(codeTypeHour);
            return ClassificationConceptHourList;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }

    @Override
    public List<Proyect> GetProyect(int codeManager) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            List<Proyect> ProyectList = client.GetProyect(codeManager);
            return ProyectList;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }

    @Override
    public List<functionality> Getfunctionality(int codeProyect) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            int soloActivos = 1;
            int IdFuncionalidadActual = -1;
            List<functionality> functionalityList = client.Getfunctionality(codeProyect, soloActivos, IdFuncionalidadActual );
            return functionalityList;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }

    @Override
    public List<Discipline> GetDiscipline(int codeMaster) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            List<Discipline> DisciplinelityList = client.GetDiscipline(codeMaster);
            return DisciplinelityList;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }

    @Override
    public List<Discipline> getActivityDisciplineStimationForRegister(int codeFuncionality) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            List<Discipline> DisciplinelityList = client.getActivityDisciplineStimationForRegister(codeFuncionality);
            return DisciplinelityList;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }


    @Override
    public List<ActivityDiscipline> getActivity(int codeDiscipline) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            List<ActivityDiscipline> activityList = client.getActivity(codeDiscipline);
            return activityList;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }

    @Override
    public List<ActivityDiscipline> getFuncionalityActivityStimateForRegister(int codeDiscipline, int codeFuncionality) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            List<ActivityDiscipline> activityList = client.getFuncionalityActivityStimateForRegister(codeDiscipline,codeFuncionality);
            return activityList;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }




    @Override
    public Boolean EditReport(ReportTime register) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            Boolean edit = client.EditTimes(register);
            return edit;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
            return false;
        }
    }

}
