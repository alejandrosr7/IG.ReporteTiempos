package com.intergrupo.reportedetiemposig.Repositories.Interfaces;

import com.intergrupo.reportedetiemposig.Model.ResumTimesForCollaborator;
import com.intergrupo.reportedetiemposig.Model.ViewTimesModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Usuario on 14/05/2016.
 */
public interface IViewTimesRepository {

    List<ViewTimesModel> GetListTimesForCollaborator(String codeUser);

    List<ResumTimesForCollaborator> GetResumTimesForCollaborator(String codeUser);

    Boolean DeleteTime(Object codigos);
}
