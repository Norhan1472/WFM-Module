package wfm.wrapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wfm.models.*;
import wfm.payload.request.WFM_EMP_Request;
import wfm.payload.response.CustomEmployeeData;
import wfm.payload.response.CustomEmployeeFullData;
import wfm.payload.response.OFFICES_Search_Response;
import wfm.repos.WFM_DEGREES_Repo;
import wfm.repos.WFM_JOBS_Repo;
import wfm.repos.WFM_JOB_TITLE_Repo;
import wfm.repos.WFM_QUALIFICATION_Repo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//@AllArgsConstructor
//@NoArgsConstructor
public class MapEmployees {
//    @Autowired
//    WFM_DEGREES_Repo wfm_degrees_repo;
//    @Autowired
//    WFM_QUALIFICATION_Repo wfm_qualification_repo;
//    @Autowired
//    WFM_JOBS_Repo wfm_jobs_repo;
//    @Autowired
//    WFM_JOB_TITLE_Repo wfm_job_title_repo;


    public CustomEmployeeFullData mapToFullDataResponse(WFM_EMP emp,Long degree,Long qualification,Long jobTitle,Integer job,String officeName) {
        CustomEmployeeFullData response = new CustomEmployeeFullData();
        response.setEmpId(emp.getEmpId());
        response.setFirstName(emp.getFirstName());
        response.setLastName(emp.getLastName());
        response.setGender(emp.getGender());
        response.setPhone(emp.getPhone());
        response.setAddress(emp.getAddress());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String birthDate = "";
        if(emp.getBirthdate()!=null){
            birthDate = dateFormat.format(emp.getBirthdate());
        }
        response.setBirthDate(birthDate);
        response.setCardId(emp.getCardId());
        String hireDate = "";
        if(emp.getHireDate()!=null){
            hireDate = dateFormat.format(emp.getHireDate());
        }
        response.setHireDate(hireDate);
        response.setCity(emp.getCity());
        response.setLevelId(emp.getSkillLevel().getLevelId());
        response.setLaborType(emp.getLaborType().getLaborTypeId());
        response.setDegree(degree);
        String qualificationDate = "";
        if(emp.getQualificationDate()!=null){
            qualificationDate = dateFormat.format(emp.getQualificationDate());
        }
        response.setQualificationDate(qualificationDate);
        response.setQualification(qualification);
        response.setJobTitle(jobTitle);
        response.setJob(job);
        response.setLocation(emp.getLocation());
        response.setCivil(emp.getCivil());
        response.setPostOffice(officeName);
        return response;
    }
    public CustomEmployeeData mapToResponse(WFM_EMP emp) {
        CustomEmployeeData response = new CustomEmployeeData();
        response.setEmpId(emp.getEmpId());
        response.setFirstName(emp.getFirstName());
        response.setLastName(emp.getLastName());
        response.setGender(emp.getGender());
        response.setPhone(emp.getPhone());
        response.setAddress(emp.getAddress());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String birthDate = "";
        if(emp.getBirthdate()!=null){
             birthDate = dateFormat.format(emp.getBirthdate());
        }
        response.setBirthDate(birthDate);
        response.setCardId(emp.getCardId());
        String hireDate = "";
        if(emp.getHireDate()!=null){
            hireDate = dateFormat.format(emp.getHireDate());
        }
        response.setHireDate(hireDate);
        response.setCity(emp.getCity());
        response.setLevelName(emp.getSkillLevel().getLevelName());
        response.setLaborType(emp.getLaborType().getLaborTypeName());
        //Set<CustomEmployeeData> employees = new HashSet<>();
        //loop
       /* for(WFM_EMP emp : postOffice.getEmps()){
            CustomEmployeeData customEmployeeData = new CustomEmployeeData();
            customEmployeeData.setEmpId(emp.getEmpId());
            customEmployeeData.setFirstName(emp.getFirstName());
            customEmployeeData.setLastName(emp.getLastName());
            customEmployeeData.setGender(emp.getGender());
            customEmployeeData.setPhone(emp.getPhone());
            customEmployeeData.setAddress(emp.getAddress());
            response.getEmps().add(customEmployeeData);
        }*/
        return response;
    }
    public List<CustomEmployeeData> customizedEmployeeResponse(List<WFM_EMP> result){
        return result.stream()
                .map(this::mapToResponse) // Convert to response DTO
                .collect(Collectors.toList());
    }
    public WFM_EMP mapToResponse(WFM_EMP_Request emp) throws ParseException {
        WFM_EMP wfmEmp = new WFM_EMP();
        //post office
        if(!(emp.getPostOffice() == null || emp.getPostOffice() == "")){
            TGH_POST_OFFICE postOffice = new TGH_POST_OFFICE();
            postOffice.setOfficeCode(emp.getPostOffice());
            wfmEmp.setPostOffice(postOffice);
        }
        //emp id
        wfmEmp.setEmpId(emp.getEmpId());
        //first name
        wfmEmp.setFirstName(emp.getFirstName());
        //last name
        wfmEmp.setLastName(emp.getLastName());
        //gender
        wfmEmp.setGender(emp.getGender());
        //phone
        wfmEmp.setPhone(emp.getPhone());
        //birthday
        if(!(emp.getBirthdate() == "" || emp.getBirthdate() == null)){
            Date birthDate=new SimpleDateFormat("dd/MM/yyyy").parse(emp.getBirthdate());
            wfmEmp.setBirthdate(birthDate);
        }
        //card id
        wfmEmp.setCardId(emp.getCardId());
        //hire date
        if(!(emp.getHireDate() == "" || emp.getHireDate() == null)){
            Date hireDate=new SimpleDateFormat("dd/MM/yyyy").parse(emp.getHireDate());
            wfmEmp.setHireDate(hireDate);
        }
        //city
        if(!(emp.getCity() == null || emp.getCity() == "")){
            TGH_CITY city = new TGH_CITY();
            city.setCityCode(emp.getCity());
            wfmEmp.setCity(city.getCityCode());
        }
        // skill level
        if(!(emp.getLevelId() == null || emp.getLevelId() == "")){
            WFM_SKILL_LEVEL level = new WFM_SKILL_LEVEL();
            level.setLevelId(emp.getLevelId());
            wfmEmp.setSkillLevel(level);
        }
        // labor type
        if(!(emp.getLaborType() == null || emp.getLaborType() == "")){
            WFM_LABOR_TYPE laborType =  new WFM_LABOR_TYPE();
            laborType.setLaborTypeId(emp.getLaborType());
            wfmEmp.setLaborType(laborType);
        }
        //degree
        if(!(emp.getDegree() == null || emp.getDegree() == 0)){
            WFM_DEGREES degrees =  new WFM_DEGREES();
            degrees.setDegreeValue(emp.getDegree());
            wfmEmp.setDegree(degrees.getDegreeValue());
        }
        //qualification date
        if(!(emp.getQualificationDate() == null || emp.getQualificationDate() == "")){
            Date qualificationDate=new SimpleDateFormat("dd/MM/yyyy").parse(emp.getQualificationDate());
            wfmEmp.setQualificationDate(qualificationDate);
        }
        //qualification
        if(emp.getQualification() != 0){
            wfmEmp.setQualification(emp.getQualification());
        }
        //job title
        if((emp.getJobTitle() != 0)){
            wfmEmp.setJobTitle(emp.getJobTitle());
        }
        // job
        if((emp.getJob() != 0)){
            wfmEmp.setJob((int) emp.getJob());
        }
        //civil
        wfmEmp.setCivil(emp.getCivil());
        //location
        wfmEmp.setLocation(emp.getLocation());
        wfmEmp.setAddress(emp.getAddress());
        return wfmEmp;
    }
}
