package com.intergrupo.reportedetiemposig.Util;

/**
 * Created by mauriciocaro on 23/06/15.
 */
public interface Constants {

    //Variables estaticas para los mensajes técnicos de la aplicación.

    boolean DEBUG = false   ;
    String NETWORK_ERROR_CODE = "527";
    String NETWORK_LOW_MESSAGE = "Parece que tienes problemas con tu conexión a internet";
    String NETWORK_ERROR_MESSAGE = "Por favor verifique que el dispositivo tenga acceso a internet e intente de nuevo.";
    String TITLE = "Reporte de tiempos";
    String TITLE_RESUMEN = "Resumen del reporte";


    String PREFS = "MyPrefs   File";
    String USER_TOKEN = "userToken";
    String USER_NAME = "username";
    String USER_LASTNAME = "userLastName";
    String USER_CODIGO = "UserCodigo";
    String URLUSERPHOTO = "urlImageUser";
    String IG_USER = "IGUser";
    String REMEMBER_ACCESS = "RememberAccess";
    String ERROR_GENERAL_REPORT = "Ocurrío un error tratando de registrar el tiempo";
    String ERROR_SELECT_PROYECT = "Debe seleccionar un proyecto";
    String ERROR_SELECT_ACTIVITY = "Debe seleccionar una actividad";
    String ERROR_SELECT_DATE = "Debe seleccionar una fecha";
    String ERROR_SELECT_HOUR = "Debe Ingresar las horas trabajadas";
    String ERROR_DESCRIPTION = "Debe digitar una descripción para la actividad";
    String ERROR_REQUIREMENT = "Debe digitar una requerimiento";
    String REGISTER_SUCCESS = "Registro guardado correctamente";
    String REGISTE_ERROR = "Registro no se guardo correctamente";
    String ERROR_HOUR = "La hora no debe ser mayor a 24 ni inferior a 0";
    String REGISTER_TITLE_DIALOG_PROYECT = "Seleccione proyecto";
    String REGISTER_TITLE_DIALOG_DIRECTOR = "Seleccione gerente";
    String REGISTER_TITLE_DIALOG_CONCEPT_HOUR = "Seleccione concepto de hora";
    String REGISTER_TITLE_DIALOG_CLASIFICATION_CONCEPT_HOUR = "Seleccione clasificación concepto de hora";
    String REGISTER_TITLE_DIALOG_ACTIVITY = "Seleccione Actividad";
    String REGISTER_TITLE_DIALOG_DISCIPLINE = "Seleccione disciplina";
    String REGISTER_TITLE_DIALOG_FUNCTIONALITY = "Seleccione Funcionalidad";



    String REGULAR_EXPRESSION_CORRECT_PASSWORD = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{3,20})";
    String REGULAR_EXPRESSION_CORRECT_EMAIL = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
            + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
            + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
            + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

    String message_user_error = "Ha ocurrido un error con el servicio de autenticaciòn.";

    String message_error_get_times= "Ha ocurrido un error obteniendo los reportes";
    String message_collaborator_without_times= "El colaborador no tiene tiempos registrados";
    String message_manager_without_times= "Actualmente no hay tiempos registrados";
    String tittle_delete_time = "¿Esta seguro de eliminar la actividad?";
    String delete_confirmation_message = "La accion que realizará no se podrá deshacer.";
    String deleted_time = "El registro se ha eliminado";

    String message_no_found_functionalities= "No se han encontrado funcionalidades, verifique el proyecto seleccionado.";
    String message_no_found_proyects= "No se han encontrado proyectos, verifique el gerente seleccionado.";
    String message_no_found_clasification_concept_hours= "No se han encontrado clasificacion de conceptos de hora, verifique el concepto de hora.";
    String message_no_found_concept_hours= "No se han encontrado conceptos de hora.";
    String message_no_found_discipline= "No se han encontrado disciplinas.";
    String message_no_found_activity= "No se han encontrado actividades.";
    String message_no_found_managers= "No se han encontrado gerentes.";
    String message_error_get_functionality= "No se han encontrado funcionalidades por que no hay proyecto seleccionado.";
    String message_user_fecha_menos = "La fecha 'Hasta' no puede ser inferior a la fecha 'Desde'";
    String from = "Desde";
    String to = "Hasta";

    String message_hours_reported= "Ha sobrepasado las horas permitidas semanalmente";
    String report = "Reporte";
}