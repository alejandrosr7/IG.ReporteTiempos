package com.intergrupo.reportedetiemposig.Repositories.Production;

import com.intergrupo.reportedetiemposig.Model.ActivityDiscipline;
import com.intergrupo.reportedetiemposig.Model.ClassificationConceptHour;
import com.intergrupo.reportedetiemposig.Model.ConceptHour;
import com.intergrupo.reportedetiemposig.Model.Discipline;
import com.intergrupo.reportedetiemposig.Model.IGLogin;
import com.intergrupo.reportedetiemposig.Model.Manager;
import com.intergrupo.reportedetiemposig.Model.Proyect;
import com.intergrupo.reportedetiemposig.Model.ReportTime;
import com.intergrupo.reportedetiemposig.Model.ResumTimesForCollaborator;
import com.intergrupo.reportedetiemposig.Model.TimesForManager;
import com.intergrupo.reportedetiemposig.Model.User;
import com.intergrupo.reportedetiemposig.Model.ViewTimesManagerDetail;
import com.intergrupo.reportedetiemposig.Model.ViewTimesModel;
import com.intergrupo.reportedetiemposig.Model.functionality;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by mauriciocaro on 23/06/15.
 */
public interface IRestClient {

    @POST("/Seguridad/AutenticarUsuario")
    Object User(@Body IGLogin Credenciales);

    @GET("/Consultas/ConsultarListaGerentes")
    List<Manager> getManager();

    @GET("/Consultas/ConsultarListaTipoHora")
    List<ConceptHour> GetConceptHour();

    @GET("/Consultas/ConsultarListaMaestroTipoHora")
    List<ClassificationConceptHour> GetClassificationConceptHour(@Query("CodigoTipoHora") int codeTypeHour);

    @GET("/Consultas/ConsultarListaProyectos")
    List<Proyect> GetProyect(@Query("id") int codeManager);

    @GET("/Consultas/ConsultarListaFuncionalidades")
    List<functionality> Getfunctionality(@Query("Id")int codeProyect, @Query("soloActivos")int soloActivos,@Query("IdFuncionalidadActual")int IdFuncionalidadActual);

    @GET("/Consultas/ConsultarListaDisciplinas")
    List<Discipline> GetDiscipline(@Query("CodigoMaestroMarcoTrabajo") int code);

    @GET("/Consultas/ConsultarActividadesDisciplina")
    List<ActivityDiscipline> getActivity(@Query("CodigoDisciplina") int code);

    @GET("/Consultas/ConsultarFuncionalidadActividadesDisciplinasEstimadasParaRegistro")
    List<Discipline> getActivityDisciplineStimationForRegister(@Query("codigoFuncionalidad") int code);


    @GET("/Consultas/ConsultarFuncionalidadActividadesEstimadasParaRegistro")
    List<ActivityDiscipline> getFuncionalityActivityStimateForRegister(@Query("codigoDisciplina") int codeDiscipline,@Query("codigoFuncionalidad")int codeFuncionality);

    @POST("/TiempoColaborador/GuardarTiempoColaborador")
    Boolean Register(@Body ReportTime register);

    @GET("/TiempoColaborador/ConsultarTiempoColaborador")
    List<ViewTimesModel> GetTimesForCollaborator(@Query("CodigoEmpleado")String userCode);

    @GET("/TiempoColaborador/ConsultarResumenTiempoColaborador")
    List<ResumTimesForCollaborator> GetResumTimesForCollaborator (@Query("CodigoEmpleado")String userCode);


    @GET("/ReporteGerente/ConsultarTiempoColaboradorGerente")
    List<TimesForManager> GetTimesForManager (@Query("CodigoGerente")String idManagerCode, @Query("FechaInicio")String startDate,@Query("FechaFin")String finishDate);


    @POST("/TiempoColaborador/EliminarTiempoColaborador")
    Boolean DeleteTimes(@Body Object codes);

    @POST("/TiempoColaborador/EditarTiempoColaborador")
    Boolean EditTimes(@Body ReportTime register);

    @GET ("/DetalleHora/ConsultarDetalleHora")
    List<ViewTimesManagerDetail> GetTimesManagerDetail (@Query("CodigoGerente")String idManagerCode, @Query("FechaInicio")String startDate,@Query("FechaFin")String finishDate);



}

