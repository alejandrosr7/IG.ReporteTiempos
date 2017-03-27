package com.intergrupo.reportedetiemposig.Repositories.Production;

import com.intergrupo.reportedetiemposig.Model.TimesForManager;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.IViewTimesMRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LeidyZuluaga on 29/05/2016.
 */
public class ViewTimesManagerRepository implements IViewTimesMRepository {

    /**
     * Método que consume el serviico para obtener la
     * lista de los proyectos asociados al gerente
     * @param idManagerCode  código unico del gerente
     * @param startDate fecha de inicio para el filtro
     * @param finishDate fecha fin para el filtro
     * @return resumTimesForManager lista de los proyectos
     * asociados al gerente
     */
    @Override
    public List<TimesForManager> GetTimesForManager(String idManagerCode, Date startDate, Date finishDate) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        List<TimesForManager> resumTimesForManager = new ArrayList<>();
        try {
            if(idManagerCode != null){
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String startDate1 = df.format(startDate);
                String finishDate1 = df.format(finishDate);
                resumTimesForManager = client.GetTimesForManager(idManagerCode, startDate1, finishDate1);
                return resumTimesForManager;
            } else {
                return resumTimesForManager;
            }

        } catch (Exception error ) {
            error.printStackTrace();

        }
        return resumTimesForManager;
    }
}
