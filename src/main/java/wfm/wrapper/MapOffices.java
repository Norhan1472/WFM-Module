package wfm.wrapper;

import wfm.models.TGH_POST_OFFICE;
import wfm.models.WFM_EMP;
import wfm.payload.response.CustomEmployeeData;
import wfm.payload.response.OFFICES_Search_Response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MapOffices {
    private OFFICES_Search_Response mapToResponse(TGH_POST_OFFICE postOffice) {
        OFFICES_Search_Response response = new OFFICES_Search_Response();
        response.setOfficeName(postOffice.getOfficeName());
        response.setOfficeCode(postOffice.getOfficeCode());
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
    public List<OFFICES_Search_Response>customizedOfficeSearchResponse(List<TGH_POST_OFFICE> result){
       return result.stream()
                .map(this::mapToResponse) // Convert to response DTO
                .collect(Collectors.toList());
    }
}
