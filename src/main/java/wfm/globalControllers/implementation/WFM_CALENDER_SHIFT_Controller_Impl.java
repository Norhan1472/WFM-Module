package wfm.globalControllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import wfm.globalControllers.WFM_CALENDER_SHIFT_Controller;
import wfm.payload.request.WFM_CALENDER_SHIFT_Insert_Req;
import wfm.payload.response.APIResponse;
import wfm.services.WFM_CALENDER_SHIFT_Service;

@RestController
public class WFM_CALENDER_SHIFT_Controller_Impl implements WFM_CALENDER_SHIFT_Controller {
    private final WFM_CALENDER_SHIFT_Service shift_service;
    @Autowired
    public WFM_CALENDER_SHIFT_Controller_Impl(WFM_CALENDER_SHIFT_Service shiftService) {
        shift_service = shiftService;
    }

    @Override
    public ResponseEntity<APIResponse> insertShift(WFM_CALENDER_SHIFT_Insert_Req shift_insert_req) {
        APIResponse apiResponse = new APIResponse();
        try {
            System.out.println("kkiioo");
            return shift_service.insertGroupShiftInQuery(shift_insert_req);
        } catch (Exception ex) {
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
            apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<APIResponse> deleteShift(long empId) {
        APIResponse apiResponse = new APIResponse();
        try {
            System.out.println("kkiioo");
            return shift_service.deleteShift(empId);
        } catch (Exception ex) {
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
            apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
