package wfm.services;

import org.springframework.http.ResponseEntity;
import wfm.models.WFM_CALENDER_SHIFT;
import wfm.payload.request.WFM_CALENDER_SHIFT_Insert_Req;
import wfm.payload.request.WFM_PUBLIC_VAC_Req;
import wfm.payload.response.APIResponse;
import wfm.payload.response.WFM_PUBLIC_VAC_Search_Response;

import java.util.List;

public interface WFM_CALENDER_SHIFT_Service {
    public ResponseEntity<APIResponse>insertGroupShift(WFM_CALENDER_SHIFT_Insert_Req shift_insert_req);
    public ResponseEntity<APIResponse> insertGroupShiftInQuery(WFM_CALENDER_SHIFT_Insert_Req shift_insert_req);
    /*public ResponseEntity<APIResponse> deleteShift()*/
}
