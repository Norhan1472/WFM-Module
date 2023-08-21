package wfm.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import wfm.models.WFM_EMP;
import wfm.models.WFM_EMP_VACATION;
import wfm.payload.response.APIResponse;
import wfm.repos.WFM_EMP_Repo;
import wfm.repos.WFM_EMP_VACATION_Repo;
import wfm.services.WFM_EMP_VACATION_Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
public class WFM_EMP_VACATION_Service_Impl implements WFM_EMP_VACATION_Service {
    private final WFM_EMP_VACATION_Repo vacationRepo;
    private final WFM_EMP_Repo empRepo;
    @Autowired
    public WFM_EMP_VACATION_Service_Impl(WFM_EMP_VACATION_Repo vacationRepo, WFM_EMP_Repo empRepo) {
        this.vacationRepo = vacationRepo;
        this.empRepo = empRepo;
    }
    @Override
    public String getEmpVacSeq() {
        return String.valueOf(vacationRepo.getNextValVacation_Seq());
    }

    @Override
    public ResponseEntity<APIResponse> insertEmpVac(long empId, WFM_EMP_VACATION empVacation) {
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
            if(empVacation.getStartDate()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("YOU MUST ENTER START DATE ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(empVacation.getVacationId()==null ||empVacation.getVacationId().equals("") ){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("YOU MUST ENTER VACATION ID ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
           /* if(empVacation.getVacationId() == ""||empVacation.getVacationId() == null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("This Vacation id is not exist ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }*/
            else {
               // System.out.println(empVacation.getVacationId());
                empVacation.setWfmEmp(checkExistEmp);
                //System.out.println(checkExistEmp.getFirstName());
                vacationRepo.save(empVacation);
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setBody("Employee inserted Successfully");
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
