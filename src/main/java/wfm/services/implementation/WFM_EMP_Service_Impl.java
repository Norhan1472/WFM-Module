package wfm.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import wfm.models.WFM_EMP;
import wfm.models.WFM_SKILL_LEVEL;
import wfm.payload.response.APIResponse;
import wfm.repos.WFM_EMP_Repo;
import wfm.services.WFM_EMP_Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class WFM_EMP_Service_Impl implements WFM_EMP_Service {
    private final WFM_EMP_Repo empRepo;

    @Autowired
    public WFM_EMP_Service_Impl(WFM_EMP_Repo empRepo) {
        this.empRepo = empRepo;
    }

    @Override
    public ResponseEntity<APIResponse> insertEmployee(WFM_EMP emp) {
        APIResponse apiResponse = new APIResponse();
        try {
            if(emp.getEmpId() == 0){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter employee Id ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            WFM_EMP checkExistEmp = empRepo.findById(emp.getEmpId()).orElse(null);
            if(!Objects.isNull(checkExistEmp)){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("This Employee id already exist ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(emp.getFirstName()=="" || emp.getFirstName()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter first name");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(emp.getSkillLevel() == null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter LeveL ID");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(emp.getLaborType() == null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter Labor Type ID");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
             else {
                WFM_EMP wfmEmp=  empRepo.save(emp);
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setBody(wfmEmp);
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
    public ResponseEntity<APIResponse> updateEmployee(WFM_EMP emp) {
        APIResponse apiResponse = new APIResponse();
        try {
            if(emp.getEmpId() == 0){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter employee Id ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            WFM_EMP checkExistEmp = empRepo.findById(emp.getEmpId()).orElse(null);
            if(Objects.isNull(checkExistEmp)){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("This Employee id is not exist ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(emp.getFirstName()=="" || emp.getFirstName()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter first name");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(emp.getSkillLevel() == null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter LeveL ID");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(emp.getLaborType() == null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter Labor Type ID");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            else {
                WFM_EMP wfmEmp=  empRepo.save(emp);
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setBody(wfmEmp);
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
    public ResponseEntity<APIResponse> deleteEmployee(long empId) {
        APIResponse apiResponse = new APIResponse();
        try {
            if(empId == 0){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter employee Id ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            WFM_EMP checkExistEmp = empRepo.findById(empId).orElse(null);
            if(Objects.isNull(checkExistEmp)){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("This Employee id is not exist ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }

            else {
                empRepo.deleteById(empId);
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setBody("Employee Deleted Successfully");
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
