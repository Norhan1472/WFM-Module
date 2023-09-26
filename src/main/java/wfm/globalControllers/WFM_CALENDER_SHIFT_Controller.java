package wfm.globalControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wfm.payload.request.WFM_CALENDER_SHIFT_Insert_Req;
import wfm.payload.request.WFM_CALENDER_SHIFT_Req;
import wfm.payload.response.APIResponse;
import wfm.payload.response.WFM_CALENDER_SHIFT_Response;

import java.time.LocalDateTime;
import java.util.Date;

@RequestMapping("WFM_CALENDER_SHIFT")
public interface WFM_CALENDER_SHIFT_Controller {
    @PostMapping("insertShift")
    public ResponseEntity<APIResponse>insertShift(@RequestBody WFM_CALENDER_SHIFT_Insert_Req shift_insert_req);
    @DeleteMapping("deleteShift")
    public ResponseEntity<APIResponse> deleteShift(@RequestParam long empId);
    @GetMapping("getShiftsOfEmp")
    public ResponseEntity<APIResponse>getShiftsOfEmp(@RequestParam long empId);
    @GetMapping("getOneShiftOfEmp")
    public ResponseEntity<APIResponse>getOneShiftOfEmp(@RequestParam long empId,@RequestParam String startDate);
    @PostMapping("updateShift")
    public ResponseEntity<APIResponse>updateShift(@RequestParam long empId, @RequestBody WFM_CALENDER_SHIFT_Req shift);
    @DeleteMapping("deleteShiftOfEmp")
    public ResponseEntity<APIResponse>deleteShiftOfEmp(@RequestParam long empId,@RequestParam String startDate);
}
