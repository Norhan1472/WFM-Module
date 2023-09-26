package wfm.services;

import org.springframework.http.ResponseEntity;
import wfm.payload.request.WFM_CALENDER_SHIFT_Insert_Req;
import wfm.payload.request.WFM_PUBLIC_VAC_Req;
import wfm.payload.response.APIResponse;
import wfm.payload.response.WFM_CALENDER_SHIFT_Response;
import wfm.payload.response.WFM_PUBLIC_VAC_Search_Response;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface WFM_CALENDER_SHIFT_Service {
    public ResponseEntity<APIResponse>insertGroupShift(WFM_CALENDER_SHIFT_Insert_Req shift_insert_req);
    public ResponseEntity<APIResponse> insertGroupShiftInQuery(WFM_CALENDER_SHIFT_Insert_Req shift_insert_req) throws ParseException;
    public ResponseEntity<APIResponse> deleteShift(long empId);
    public ResponseEntity<APIResponse> getShiftsOfEmp(long empId);
    public ResponseEntity<APIResponse> getOneShiftOfEmp(long empId, String startDate);
    public ResponseEntity<APIResponse> updateShift(long empId, String startDate, String shiftId, String shiftDate) throws ParseException;
    public ResponseEntity<APIResponse> deleteShiftOfEmp(long empId, String startDate);
    public ResponseEntity<APIResponse> updateShiftInQuery(long empId, String startDate, String shiftId, String shiftDate) throws ParseException;
    public ResponseEntity<APIResponse> updateShiftInQuery2(long empId, String startDate, String shiftId, String shiftDate) ;

}
