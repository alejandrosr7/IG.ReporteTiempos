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
public class ReportRepository implements IReportRepository {
    
    
    @Override
    public Boolean Register(ReportTime register) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            return client.Register(register);
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
            return false;
        }
    }
    
    @Override
    public List<Manager> GetManager() {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            return client.getManager();
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }
    
    @Override
    public List<ConceptHour> GetConceptHour() {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            return client.GetConceptHour();
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }
    
    @Override
    public List<ClassificationConceptHour> GetClassificationConceptHour(int codeTypeHour) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            return client.GetClassificationConceptHour(codeTypeHour);
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }
    
    @Override
    public List<Proyect> GetProyect(int codeManager) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            return client.GetProyect(codeManager);
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
            return client.Getfunctionality(codeProyect, soloActivos, IdFuncionalidadActual);
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }
    
    @Override
    public List<Discipline> GetDiscipline(int codeMaster) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            return client.GetDiscipline(codeMaster);
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }
    
    @Override
    public List<Discipline> getActivityDisciplineStimationForRegister(int codeFuncionality) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            return client.getActivityDisciplineStimationForRegister(codeFuncionality);
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }
    
    
    @Override
    public List<ActivityDiscipline> getActivity(int codeDiscipline) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            return client.getActivity(codeDiscipline);
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }
    
    @Override
    public List<ActivityDiscipline> getFuncionalityActivityStimateForRegister(int codeDiscipline,
                                                                              int codeFuncionality) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            return client.getFuncionalityActivityStimateForRegister(codeDiscipline,
                    codeFuncionality);
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }
        return null;
    }
    
    
    @Override
    public Boolean EditReport(ReportTime register) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        try {
            return client.EditTimes(register);
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
            return false;
        }
    }
    
}
