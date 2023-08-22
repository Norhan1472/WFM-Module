package wfm.globalControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wfm.payload.request.WFM_CALENDER_SHIFT_Insert_Req;
import wfm.payload.response.APIResponse;

@RequestMapping("WFM_CALENDER_SHIFT")
public interface WFM_CALENDER_SHIFT_Controller {
    @PostMapping("insertShift")
    public ResponseEntity<APIResponse>insertShift(@RequestBody WFM_CALENDER_SHIFT_Insert_Req shift_insert_req);
    @DeleteMapping("deleteShift")
    public ResponseEntity<APIResponse> deleteShift(@RequestParam long empId);
}
