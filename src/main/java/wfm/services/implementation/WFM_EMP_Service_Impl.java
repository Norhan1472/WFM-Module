package wfm.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import wfm.models.*;
import wfm.payload.request.InitEmployeeData;
import wfm.payload.request.WFM_EMP_Request;
import wfm.payload.response.APIResponse;
import wfm.payload.response.CustomEmployeeData;
import wfm.repos.*;
import wfm.services.WFM_EMP_Service;
import wfm.wrapper.MapEmployees;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class WFM_EMP_Service_Impl implements WFM_EMP_Service {
    private final WFM_EMP_Repo empRepo;
    private final TGH_POST_OFFICE_Repo tghPostOfficeRepo;
    private final TGH_CITY_Repo cityRepo;
    private final WFM_SKILL_LEVEL_Repo levelsRepo;
    private final WFM_LABOR_TYPE_Repo laborTypesRepo;
    private final WFM_JOBS_Repo jobsRepo;
    private final WFM_JOB_TITLE_Repo jobTitleRepo;
    private final WFM_QUALIFICATION_Repo qualificationRepo;
    private final WFM_DEGREES_Repo degreesRepo;
    private final WFM_GENDER_Repo genderRepo;
    @Autowired
    public WFM_EMP_Service_Impl(WFM_EMP_Repo empRepo, TGH_POST_OFFICE_Repo tghPostOfficeRepo, TGH_CITY_Repo cityRepo, WFM_SKILL_LEVEL_Repo levelsRepo, WFM_LABOR_TYPE_Repo laborTypesRepo, WFM_JOBS_Repo jobsRepo, WFM_JOB_TITLE_Repo jobTitleRepo, WFM_QUALIFICATION_Repo qualificationRepo, WFM_DEGREES_Repo degreesRepo, WFM_GENDER_Repo genderRepo) {
        this.empRepo = empRepo;
        this.tghPostOfficeRepo = tghPostOfficeRepo;
        this.cityRepo = cityRepo;
        this.levelsRepo = levelsRepo;
        this.laborTypesRepo = laborTypesRepo;
        this.jobsRepo = jobsRepo;
        this.jobTitleRepo = jobTitleRepo;
        this.qualificationRepo = qualificationRepo;
        this.degreesRepo = degreesRepo;
        this.genderRepo = genderRepo;
    }

    @Override
    public ResponseEntity<APIResponse> insertEmployee(WFM_EMP_Request emp) {
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
            if(emp.getLevelId() == null || emp.getLevelId()==""){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter LeveL ID");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(emp.getLaborType() == null || emp.getLaborType()==""){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter Labor Type ID");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
             else {
                WFM_EMP wfmEmp=  new WFM_EMP();
                MapEmployees mapEmployees = new MapEmployees();
                wfmEmp = mapEmployees.mapToResponse(emp);
                WFM_EMP employee = empRepo.save(wfmEmp);
                CustomEmployeeData result = mapEmployees.mapToResponse(employee);
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
    public ResponseEntity<APIResponse> updateEmployee(WFM_EMP_Request emp) {
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
            if(emp.getLevelId() == null){
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
                WFM_EMP wfmEmp=  new WFM_EMP();
                MapEmployees mapEmployees = new MapEmployees();
                wfmEmp = mapEmployees.mapToResponse(emp);
                WFM_EMP employee = empRepo.save(wfmEmp);
                CustomEmployeeData result = mapEmployees.mapToResponse(employee);
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

    @Override
    public ResponseEntity<APIResponse> initData() {
        APIResponse apiResponse = new APIResponse();
        try {
             InitEmployeeData initEmployeeData = new InitEmployeeData();
             //offices
            List<TGH_POST_OFFICE>offices = tghPostOfficeRepo.findAll();
            initEmployeeData.setOffices(offices);
            //cities
            List<TGH_CITY>cities = cityRepo.findAll();
            initEmployeeData.setCities(cities);
            //levels
            List<WFM_SKILL_LEVEL>levels = levelsRepo.findAll();
            initEmployeeData.setLevels(levels);
            //labor type
            List<WFM_LABOR_TYPE>laborTypes = laborTypesRepo.findAll();
            initEmployeeData.setLaborTypes(laborTypes);
            //jobs
            List<WFM_JOBS>jobs = jobsRepo.findAll();
            initEmployeeData.setJobs(jobs);
            //job title
            List<WFM_JOB_TITLE> jobTitles = jobTitleRepo.findAll();
            initEmployeeData.setJobTitles(jobTitles);
            //qualification
            List<WFM_QUALIFICATION>qualifications = qualificationRepo.findAll();
            initEmployeeData.setQualifications(qualifications);
            //degrees
            List<WFM_DEGREES>degrees = degreesRepo.findAll();
            initEmployeeData.setDegrees(degrees);
            //genders
            List<WFM_GENDER>genders = genderRepo.findAll();
            initEmployeeData.setGenders(genders);
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setBody(initEmployeeData);
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);

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
