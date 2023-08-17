package wfm.globalControllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import wfm.globalControllers.WFM_EMP_Controller;
import wfm.models.WFM_EMP;
import wfm.models.WFM_SKILL_LEVEL;
import wfm.payload.response.APIResponse;
import wfm.services.WFM_EMP_Service;

import java.util.List;

@RestController
public class WFM_EMP_Controller_Impl implements WFM_EMP_Controller {
    private final WFM_EMP_Service empService;
    @Autowired
    public WFM_EMP_Controller_Impl(WFM_EMP_Service empService) {
        this.empService = empService;
    }

    @Override
    public ResponseEntity<APIResponse> insertEmployee(WFM_EMP emp) {
        APIResponse apiResponse = new APIResponse();
        System.out.println("lll");
        try {
            return empService.insertEmployee(emp);
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
    public ResponseEntity<APIResponse> updateEmployee(WFM_EMP emp) {
        APIResponse apiResponse = new APIResponse();
        try {
            return empService.updateEmployee(emp);
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
    public ResponseEntity<APIResponse> deleteEmployee(long empId) {
        APIResponse apiResponse = new APIResponse();
        try {
            return empService.deleteEmployee(empId);
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
