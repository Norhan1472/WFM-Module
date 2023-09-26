package wfm.payload.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomEmployeeData {//degree,qualificationDate,qualification,jobTitle,job,civil,location,cardId
    private long empId;
    private String firstName;
    private String lastName;
    private String gender;
    private long phone;
    private String address;
    //@JsonFormat(pattern = "dd-MM-yyyy")
    private String birthDate;
    private String cardId;
  //  @JsonFormat(pattern = "dd-MM-yyyy")
    private String hireDate;
    private String city;
    private String levelName;
    private String laborType;

}
