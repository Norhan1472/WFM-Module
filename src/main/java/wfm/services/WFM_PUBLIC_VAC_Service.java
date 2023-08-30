package wfm.services;

import org.springframework.http.ResponseEntity;
import wfm.models.WFM_PUBLIC_VAC;
import wfm.payload.request.WFM_PUBLIC_VAC_Req;
import wfm.payload.response.APIResponse;
import wfm.payload.response.WFM_PUBLIC_VAC_Search_Response;

import java.text.ParseException;
import java.util.List;

public interface WFM_PUBLIC_VAC_Service {
    public List<WFM_PUBLIC_VAC_Search_Response> searchPublicVac(WFM_PUBLIC_VAC_Req searchRequest);
    public WFM_PUBLIC_VAC_Search_Response updateWFMVac(WFM_PUBLIC_VAC_Req wfm_PUBLIC_VAC_Req) throws ParseException;
    public Boolean deleteWFMVac(String vacationId);
    public WFM_PUBLIC_VAC_Search_Response insertWFMVac(WFM_PUBLIC_VAC_Req wfm_PUBLIC_VAC_Req) throws ParseException;
    public ResponseEntity<APIResponse> getWFMVacById(String vacationId);
}
