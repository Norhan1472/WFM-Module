package wfm.wrapper;

import wfm.models.TGH_POST_OFFICE;
import wfm.models.WFM_EMP;
import wfm.payload.response.CustomEmployeeData;
import wfm.payload.response.OFFICES_Search_Response;

import java.util.List;
import java.util.stream.Collectors;

public class MapEmployees {
    private CustomEmployeeData mapToResponse(WFM_EMP emp) {
        CustomEmployeeData response = new CustomEmployeeData();
        response.setEmpId(emp.getEmpId());
        response.setFirstName(emp.getFirstName());
        response.setLastName(emp.getLastName());
        response.setGender(emp.getGender());
        response.setPhone(emp.getPhone());
        response.setAddress(emp.getAddress());
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
}
