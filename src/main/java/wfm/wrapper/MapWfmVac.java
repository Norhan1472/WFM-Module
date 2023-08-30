package wfm.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import wfm.models.WFM_PUBLIC_VAC;
import wfm.models.WFM_PUBLIC_VAC_TYPE;
import wfm.payload.response.WFM_PUBLIC_VAC_Search_Response;
import wfm.repos.WFM_PUBLIC_VAC_Repo;
import wfm.repos.WFM_PUBLIC_VAC_TYPE_Repo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MapWfmVac {

    public WFM_PUBLIC_VAC_Search_Response mapToResponse(WFM_PUBLIC_VAC vac,String vacationType) {

        WFM_PUBLIC_VAC_Search_Response response = new WFM_PUBLIC_VAC_Search_Response();
        response.setVacationId(vac.getVacationId());
        response.setVacationName(vac.getVacationName());
       if(vacationType!=""){
           response.setVacationTypeId(vacationType);
       }else {
          response.setVacationTypeId(vac.getWfmPublicVacType().getVacationName());
       }

        if(!(vac.getStartDate() == null)){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String startDate = dateFormat.format(vac.getStartDate());
            response.setStartDate(startDate);
        }
        response.setNumDays(vac.getNumDays());
        return response;
    }
}
