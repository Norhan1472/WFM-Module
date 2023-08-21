package wfm.globalControllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import wfm.globalControllers.WFM_EMP_VACATION_Controller;
import wfm.models.TGH_POST_OFFICE;
import wfm.models.WFM_EMP_VACATION;
import wfm.payload.response.APIResponse;
import wfm.services.WFM_EMP_VACATION_Service;

import java.util.List;

@RestController
public class WFM_EMP_VACATION_Controller_Impl implements WFM_EMP_VACATION_Controller {
    private final WFM_EMP_VACATION_Service empVacationService;
    @Autowired
    public WFM_EMP_VACATION_Controller_Impl(WFM_EMP_VACATION_Service empVacationService) {
        this.empVacationService = empVacationService;
    }

    @Override
    public ResponseEntity<APIResponse> getEmpVacSeq() {
        APIResponse apiResponse = new APIResponse();
        try {
            String result = empVacationService.getEmpVacSeq();;
            if (result.isEmpty()|| result == null) {
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

    @Override
    public ResponseEntity<APIResponse> insertEmpVac(long empId, WFM_EMP_VACATION wfmEmpVacation) {
        APIResponse apiResponse = new APIResponse();
        try {
            System.out.println("kkiioo");
            System.out.println(empId);
            return empVacationService.insertEmpVac(empId,wfmEmpVacation);
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
