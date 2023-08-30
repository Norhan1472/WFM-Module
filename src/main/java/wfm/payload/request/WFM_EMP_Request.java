package wfm.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WFM_EMP_Request {
    private long empId;
    private String postOffice;
    private String firstName;
    private String lastName;
    private String gender;
    private long phone;
    private String address;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String birthdate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String hireDate;
    private String city;
    private String levelId;
    private String laborType;
    private Integer degree;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String qualificationDate;
    private long qualification;
    private long jobTitle;
    private long job;
    private Integer civil;
    private String location;
    private String cardId;

}
