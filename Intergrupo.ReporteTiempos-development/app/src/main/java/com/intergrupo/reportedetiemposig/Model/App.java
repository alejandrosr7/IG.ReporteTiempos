package com.intergrupo.reportedetiemposig.Model;

import android.content.Context;

import com.intergrupo.reportedetiemposig.CallBack.Callback;
import com.intergrupo.reportedetiemposig.Repositories.RepositoryLocator;

import java.util.Date;
import java.util.List;

/**
 * Created by mauricio on 1/11/15.
 */
public class App {

    private static App instance;
    private static RepositoryLocator locator;

    //Contexto de la aplicaciòn para poder ser usada en contenedor
    private Context ApplicationContext;

    private App() {
        locator = RepositoryLocator.getInstance();
    }

    public static App getInstance() {

        if (instance == null)
            instance = new App();
        return instance;
    }


    public Context getApplicationContext() {
        return ApplicationContext;
    }

    public void setApplicationContext(Context applicationContext) {
        ApplicationContext = applicationContext;
    }

    /**
     * @param login    Es un modelo que guarda los valores obtenidos de login
     * @param callback Es un objeto que facilita la respuesta del flujo del login
     * @ConsultUser Método que recibe 2 parámetros, los envía al repositorio al método SignIn.
     */


    public void ConsultUser(IGLogin login, final Callback<Boolean> callback) {
        locator.getSecurityRepository().SignIn(login, new Callback<Boolean>() {
            @Override
            public void complete(Boolean data) {
                callback.complete(true);
            }

            @Override
            public void failure(Error error) {
                callback.failure(error);
            }
        });

    }


    public User SingInSincrono(IGLogin igLogin) {
        return locator.getSecurityRepository().SignInSincrono(igLogin);
    }

    public TiemposResponse<List<Manager>> ListProyects() {
        return locator.getReportRepository().ListProyects();
    }

    public TiemposResponse<List<String>> ListActivities() {
        return locator.getReportRepository().ListActivities();
    }

    public Boolean Register(ReportTime register) {
        return locator.getReportRepository().Register(register);
    }


    public List<Manager> GetManager() {
        return locator.getReportRepository().GetManager();
    }

    public List<ConceptHour> GetConceptHour() {
        return locator.getReportRepository().GetConceptHour();
    }

    public List<ClassificationConceptHour> GetClassificationConceptHour(int codeTypeHour) {
        return locator.getReportRepository().GetClassificationConceptHour(codeTypeHour);
    }

    public List<Proyect> GetProyect(int codeManager) {
        return locator.getReportRepository().GetProyect(codeManager);
    }

    public List<functionality> Getfunctionality(int codeProyect) {
        return locator.getReportRepository().Getfunctionality(codeProyect);
    }

    public List<Discipline> GetDiscipline(int codeMaster) {
        return locator.getReportRepository().GetDiscipline(codeMaster);
    }

    public List<Discipline> getActivityDisciplineStimationForRegister(int codeFuncionality) {
        return locator.getReportRepository().getActivityDisciplineStimationForRegister(codeFuncionality);
    }

    public List<ActivityDiscipline> getActivity(int codeDiscipline) {
        return locator.getReportRepository().getActivity(codeDiscipline);
    }

    public List<ActivityDiscipline> getFuncionalityActivityStimateForRegister(int codeDiscipline, int codeFuncionality) {
        return locator.getReportRepository().getFuncionalityActivityStimateForRegister(codeDiscipline, codeFuncionality);
    }

    public List<ViewTimesModel> GetViewTimesForCollaborator(String userCode) {
        return locator.getViewTimesRepository().GetListTimesForCollaborator(userCode);
    }

    public List<ResumTimesForCollaborator> GetResumTimesForCollaborator(String userCode) {
        return locator.getViewTimesRepository().GetResumTimesForCollaborator(userCode);
    }


    public List<TimesForManager> GetTimesForManager(String idManagerCode, Date startDate, Date finishDate) {
        return locator.getTimesForManager().GetTimesForManager(idManagerCode, startDate, finishDate);
    }

    public Boolean DeleteTimes(Object times) {
        return locator.getViewTimesRepository().DeleteTime(times);
    }

    public Boolean EditTimes(ReportTime register) {
        return locator.getReportRepository().EditReport(register);

    }

    public List<ViewTimesManagerDetail> GetTimesManagerDetail(String idManagerCode, Date startDate, Date finishDate) {
        return locator.getTimesManagerDetail().GetTimesManagerDetail(idManagerCode, startDate, finishDate);
    }


}
