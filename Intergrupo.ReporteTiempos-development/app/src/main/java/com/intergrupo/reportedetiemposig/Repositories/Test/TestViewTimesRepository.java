package com.intergrupo.reportedetiemposig.Repositories.Test;

import com.intergrupo.reportedetiemposig.Model.ResumTimesForCollaborator;
import com.intergrupo.reportedetiemposig.Model.ViewTimesModel;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.IViewTimesRepository;
import com.intergrupo.reportedetiemposig.Ui.Controller.ViewTimes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 14/05/2016.
 */
public class TestViewTimesRepository implements IViewTimesRepository{


    @Override
    public ArrayList<ViewTimesModel> GetListTimesForCollaborator(String codeUser) {
        ArrayList<ViewTimesModel> times=  new ArrayList<ViewTimesModel>();
        ViewTimesModel time = new ViewTimesModel();
        time.setCodigoActividad(1);
        time.setDescripcion("Actividad 1 EPM");
        time.setNombreProyecto("EPM movilidad");
        time.setCodigoProyecto(1);
        time.setHoras(2d);

        times.add(time);

        time = new ViewTimesModel();
        time.setCodigoActividad(2);
        time.setDescripcion("Actividad 1 Ruta N");
        time.setNombreProyecto("Ruta N");
        time.setCodigoProyecto(2);
        time.setHoras(3d);

        times.add(time);

        time = new ViewTimesModel();
        time.setCodigoActividad(3);
        time.setDescripcion("Actividad 2 Ruta N");
        time.setNombreProyecto("Ruta N");
        time.setCodigoProyecto(2);
        time.setHoras(1d);

        times.add(time);

        time = new ViewTimesModel();
        time.setCodigoActividad(4);
        time.setDescripcion("Actividad 2 EPM");
        time.setNombreProyecto("EPM movilidad");
        time.setCodigoProyecto(1);
        time.setHoras(3.5);

        times.add(time);




        return times;
    }

    @Override
    public List<ResumTimesForCollaborator> GetResumTimesForCollaborator(String codeUser) {
        return null;
    }

    @Override
    public Boolean DeleteTime(Object codigos) {
        return true;
    }
}
