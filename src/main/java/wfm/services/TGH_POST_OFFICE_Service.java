package wfm.services;

import org.springframework.data.repository.query.Param;
import wfm.models.TGH_POST_OFFICE;
import wfm.models.WFM_EMP;
import wfm.payload.request.OFFICES_Search_Req;

import java.util.List;

public interface TGH_POST_OFFICE_Service {
    public List<TGH_POST_OFFICE>searchOffices(OFFICES_Search_Req officesSearchReq);
    public List<WFM_EMP>getAllEmployees(String officeCode);
    public List<TGH_POST_OFFICE> getAllOffices();
}
