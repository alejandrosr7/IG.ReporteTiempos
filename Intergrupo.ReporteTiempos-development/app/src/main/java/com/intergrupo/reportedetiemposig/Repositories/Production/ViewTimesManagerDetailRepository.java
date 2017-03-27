package com.intergrupo.reportedetiemposig.Repositories.Production;


import com.intergrupo.reportedetiemposig.Model.ViewTimesManagerDetail;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.IViewTimesManagerDetail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LeidyZuluaga on 13/08/2016.
 */
public class ViewTimesManagerDetailRepository implements IViewTimesManagerDetail {

    /**
     * Método que consume el servicio para obtener
     * la lista de los colaboradores
     * y las horas según el tipo de hora
     * @param idManagerCode  código unico del gerente
     * @param startDate fecha de inicio para el filtro
     * @param finishDate fecha fin para el filtro
     * @return timesManagerDetails lista de los colaboradores
     * y las horas según el tipo de hora
     */
    @Override
    public List<ViewTimesManagerDetail> GetTimesManagerDetail(String idManagerCode, Date startDate, Date finishDate) {
        IRestClient client = ReporteDeTiemposApiClient.getInstance().getClient();
        List<ViewTimesManagerDetail> timesManagerDetails = new ArrayList<>();
        try {
            if(idManagerCode != null){
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String startDate1 = df.format(startDate);
                String finishDate1 = df.format(finishDate);
                timesManagerDetails = client.GetTimesManagerDetail(idManagerCode, startDate1, finishDate1);
                return timesManagerDetails;
            } else {
                return timesManagerDetails;
            }

        } catch (Exception error ) {
            error.printStackTrace();

        }
        return timesManagerDetails;
    }
}
