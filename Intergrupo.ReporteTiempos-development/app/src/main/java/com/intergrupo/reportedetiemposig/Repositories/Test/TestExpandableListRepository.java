package com.intergrupo.reportedetiemposig.Repositories.Test;

/**
 * Created by USUARIO on 23/05/2016.
 */

import com.intergrupo.reportedetiemposig.Model.TimesForManager;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.IViewTimesMRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
public class TestExpandableListRepository implements IViewTimesMRepository {

    public static HashMap<String, List<String>> getData() {
         HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

    List<String> epmMovilidad = new ArrayList<>();
        epmMovilidad.add("Juan Camilo");
        epmMovilidad.add("Fernando Restrepo");
        epmMovilidad.add("Leidy Carolina Zuluaga");
        epmMovilidad.add("Mauricio Caro");
        epmMovilidad.add("Natalia Bustamante");


        List<String> sura= new ArrayList<>();
        sura.add("Juan Camilo");
        sura.add("Fernando Restrepo");
        sura.add("Leidy Carolina Zuluaga");
        sura.add("Mauricio Caro");
        sura.add("Natalia Bustamante");


        List<String> Marketing = new ArrayList<>();
        Marketing.add("Juan Camilo");
        Marketing.add("Fernando Restrepo");
        Marketing.add("Leidy Carolina Zuluaga");
        Marketing.add("Mauricio Caro");
        Marketing.add("Natalia Bustamante");

        expandableListDetail.put("EPM MOVILIDAD", epmMovilidad);
        expandableListDetail.put("Sura",sura);
        expandableListDetail.put("Marketing personal",Marketing);
        return expandableListDetail;
    }


    @Override
    public List<TimesForManager> GetTimesForManager(String idManagerCode, Date fechaInicio, Date fechaFin) {
        return null;
    }
}
