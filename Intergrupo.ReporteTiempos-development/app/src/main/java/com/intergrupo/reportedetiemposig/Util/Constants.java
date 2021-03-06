package com.intergrupo.reportedetiemposig.Util;

/**
 * Created by mauriciocaro on 23/06/15.
 */
public interface Constants {

    //Variables estaticas para los mensajes técnicos de la aplicación.

    boolean DEBUG = false   ;
    String NETWORK_ERROR_CODE = "527";
    String NETWORK_ERROR_MESSAGE = "Por favor verifique que el dispositivo tenga acceso a internet e intente de nuevo.";


    String PREFS = "MyPrefs   File";
    String USER_TOKEN = "userToken";
    String USER_NAME = "username";
    String WAIT_MESSAGE = "username";
    String USER_LASTNAME = "userLastName";
    String USER_CODIGO = "UserCodigo";
    String URLUSERPHOTO = "urlImageUser";
    String IG_USER = "IGUser";
    String REMEMBER_ACCESS = "RememberAccess";
    String ERROR_GENERAL_REPORT = "Ocurrío un error tratando de registrar el tiempo";
    String ERROR_SELECT_DATE = "Debe seleccionar una fecha";
    String ERROR_SELECT_HOUR = "Debe Ingresar las horas trabajadas";
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

    String MESSAGE_USER_ERROR = "Ha ocurrido un error con el servicio de autenticaciòn.";

    String MESSAGE_ERROR_GET_TIMES = "Ha ocurrido un error obteniendo los reportes";
    String MESSAGE_COLLABORATOR_WITHOUT_TIMES = "El colaborador no tiene tiempos registrados";
    String MESSAGE_MANAGER_WITHOUT_TIMES = "Actualmente no hay tiempos registrados";
    String TITLE_DELETE_TIME = "¿Esta seguro de eliminar la actividad?";
    String DELETE_CONFIRMATION_MESSAGE = "La accion que realizará no se podrá deshacer.";
    String DELETED_TIME = "El registro se ha eliminado";

    String MESSAGE_NO_FOUND_FUNCTIONALITIES = "No se han encontrado funcionalidades, verifique el proyecto seleccionado.";
    String MESSAGE_NO_FOUND_PROYECTS = "No se han encontrado proyectos, verifique el gerente seleccionado.";
    String MESSAGE_NO_FOUND_CLASIFICATION_CONCEPT_HOURS = "No se han encontrado clasificacion de conceptos de hora, verifique el concepto de hora.";
    String MESSAGE_NO_FOUND_CONCEPT_HOURS = "No se han encontrado conceptos de hora.";
    String MESSAGE_NO_FOUND_DISCIPLINE = "No se han encontrado disciplinas.";
    String MESSAGE_NO_FOUND_ACTIVITY = "No se han encontrado actividades.";
    String MESSAGE_NO_FOUND_MANAGERS = "No se han encontrado gerentes.";
    String MESSAGE_ERROR_GET_FUNCTIONALITY = "No se han encontrado funcionalidades por que no hay proyecto seleccionado.";
    String MESSAGE_USER_DATE_LESS = "La fecha 'Hasta' no puede ser inferior a la fecha 'Desde'";
    String FROM = "Desde";
    String to = "Hasta";

    String MESSAGE_HOURS_REPORTED = "Ha sobrepasado las horas permitidas semanalmente";
    String REPORT = "Reporte";
}