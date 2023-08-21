package wfm.globalControllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import wfm.globalControllers.WFM_SHIFTS_Controller;
import wfm.models.WFM_PUBLIC_VAC_TYPE;
import wfm.models.WFM_SHIFTS;
import wfm.payload.response.APIResponse;
import wfm.services.WFM_SHIFTS_Service;

import java.util.List;

@RestController
public class WFM_SHIFTS_Controller_Impl implements WFM_SHIFTS_Controller {
    private final WFM_SHIFTS_Service wfm_shifts_service;
    @Autowired
    public WFM_SHIFTS_Controller_Impl(WFM_SHIFTS_Service wfmShiftsService) {
        wfm_shifts_service = wfmShiftsService;
    }
    @Override
    public ResponseEntity<APIResponse> getAllShifts() {
        APIResponse apiResponse = new APIResponse();
        try {
            List<WFM_SHIFTS> result = wfm_shifts_service.getAllShifts();
            if (result.isEmpty()) {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("No data found");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            } else {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setBody(result);
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            }

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
