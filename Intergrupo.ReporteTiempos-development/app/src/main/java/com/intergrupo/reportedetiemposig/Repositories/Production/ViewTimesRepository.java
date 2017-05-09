package com.intergrupo.reportedetiemposig.Repositories.Production;

import com.google.gson.Gson;
import com.intergrupo.reportedetiemposig.Model.ResumTimesForCollaborator;
import com.intergrupo.reportedetiemposig.Model.ViewTimesModel;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.IViewTimesRepository;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit.RetrofitError;

/**
 * Created by Usuario on 14/05/2016.
 */
public class ViewTimesRepository implements IViewTimesRepository {

    @Override
    public List<ViewTimesModel> GetListTimesForCollaborator(String codeUser) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();

        try {
            List<ViewTimesModel> timesForCollaborator;
            if (codeUser != null) {
                timesForCollaborator = client.GetTimesForCollaborator(codeUser);
            } else {
                return null;
            }
            return timesForCollaborator;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
        }

        return null;
    }

    @Override
    public List<ResumTimesForCollaborator> GetResumTimesForCollaborator(String codeUser) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();

        try {
            List<ResumTimesForCollaborator> resumTimesForCollaborator;
            if (codeUser != null) {
                resumTimesForCollaborator = client.GetResumTimesForCollaborator(codeUser);
            } else {
                return null;
            }
            return resumTimesForCollaborator;
        } catch (RetrofitError retrofitError) {
            retrofitError.getBody();
            return null;
        }
    }

    @Override
    public Boolean DeleteTime(Object codigos) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();

        try {
            return client.DeleteTimes(codigos);
        } catch (RetrofitError retrofitError) {
            retrofitError.printStackTrace();
            return false;
        }

    }
}
