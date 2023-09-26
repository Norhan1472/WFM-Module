package wfm.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import wfm.models.WFM_EMP;
import wfm.models.WFM_EMP_VACATION;
import wfm.payload.request.WFM_EMP_VACATION_Req;
import wfm.payload.response.APIResponse;
import wfm.payload.response.WFM_EMP_VACATION_Response;
import wfm.repos.WFM_EMP_Repo;
import wfm.repos.WFM_EMP_VACATION_Repo;
import wfm.services.WFM_EMP_VACATION_Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    public ResponseEntity<APIResponse> insertEmpVac(long empId, WFM_EMP_VACATION_Req wfmEmpVacationReq) {
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
                System.out.println("here");
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("This Employee id is not exist ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(wfmEmpVacationReq.getStartDate()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("YOU MUST ENTER START DATE ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(wfmEmpVacationReq.getVacationId()==null ||wfmEmpVacationReq.getVacationId().equals("") ){
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
                WFM_EMP_VACATION wfm_emp_vac = new WFM_EMP_VACATION();
//                WFM_EMP wfm_emp = new WFM_EMP();
//                wfm_emp.setEmpId(wfm_emp.getEmpId());
                //emp id
                wfm_emp_vac.setWfmEmp(checkExistEmp);
                wfm_emp_vac.setVacationId(wfmEmpVacationReq.getVacationId());
                wfm_emp_vac.setNoDays(wfmEmpVacationReq.getNoDays());
                String startDate = wfmEmpVacationReq.getStartDate();
                Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
                wfm_emp_vac.setStartDate(date1);

                //System.out.println(checkExistEmp.getFirstName());
                vacationRepo.saveVacation(wfm_emp_vac.getVacationId(),wfm_emp_vac.getNoDays(),wfm_emp_vac.getWfmEmp().getEmpId(),wfm_emp_vac.getStartDate());
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("Vacation assigned to Employee Successfully");
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
    public ResponseEntity<APIResponse> updateEmpVac(long empId, WFM_EMP_VACATION_Req wfmEmpVacationReq) {
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
                System.out.println("here");
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("This Employee id is not exist ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(wfmEmpVacationReq.getStartDate()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("YOU MUST ENTER START DATE ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(wfmEmpVacationReq.getVacationId()==null ||wfmEmpVacationReq.getVacationId().equals("") ){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("YOU MUST ENTER VACATION ID ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            WFM_EMP_VACATION wfm_emp_vacation = vacationRepo.findById(wfmEmpVacationReq.getVacationId()).orElse(null);
            if(Objects.isNull(wfm_emp_vacation)){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("THIS VACATION ID IS NOT EXIST");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            else {
                // System.out.println(empVacation.getVacationId());
                WFM_EMP_VACATION wfm_emp_vac = new WFM_EMP_VACATION();
//                WFM_EMP wfm_emp = new WFM_EMP();
//                wfm_emp.setEmpId(wfm_emp.getEmpId());
                //emp id
                wfm_emp_vac.setWfmEmp(checkExistEmp);
                wfm_emp_vac.setVacationId(wfmEmpVacationReq.getVacationId());
                wfm_emp_vac.setNoDays(wfmEmpVacationReq.getNoDays());
                String startDate = wfmEmpVacationReq.getStartDate();
                Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
                wfm_emp_vac.setStartDate(date1);

                //System.out.println(checkExistEmp.getFirstName());
                vacationRepo.save(wfm_emp_vac);
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("Vacation assigned to Employee Updated Successfully");
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
    public ResponseEntity<APIResponse> deleteEmpVac(String vacId) {
        APIResponse apiResponse = new APIResponse();
        try {

            if(vacId==null ||vacId.equals("") ){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("YOU MUST ENTER VACATION ID ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            WFM_EMP_VACATION wfm_emp_vacation = vacationRepo.findById(vacId).orElse(null);
            if(Objects.isNull(wfm_emp_vacation)){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("THIS VACATION ID IS NOT EXIST");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            else {

                vacationRepo.deleteById(vacId);
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("Vacation assigned to Employee Deleted Successfully");
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
    public ResponseEntity<APIResponse> getVacationOfEmployeeById(long empId) {
        APIResponse apiResponse = new APIResponse();
        try {

            if(empId==0  ){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("YOU MUST ENTER EMPLOYEE ID ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            List<WFM_EMP_VACATION_Response> wfm_emp_vacation = vacationRepo.findVacationByEmployeeId(empId);
            if(wfm_emp_vacation.size()==0){
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());//THIS VACATION ID IS NOT EXIST
                apiResponse.setClientMessage("THIS VACATION ID IS NOT EXIST");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            }
            else {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setBody(wfm_emp_vacation);
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
