package wfm.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import wfm.models.TGH_POST_OFFICE;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OFFICES_Search_Response {
    private String officeName;
    private String officeCode;
   //Set<CustomEmployeeData> emps = new HashSet<>();

}
