package wfm.payload.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomEmployeeFullData {
    private long empId;
    private String firstName;
    private String lastName;
    private String gender;
    private long phone;
    private String address;
    @JsonProperty("birthdate")
    private String birthDate;
    private String cardId;
    private String hireDate;
    private String city;
    private String levelId;
    private String laborType;
    private Long degree;
    private String qualificationDate;
    private Long qualification;
    private Long jobTitle;
    private Integer job;
    private Integer civil;
    private String location;
    private String postOffice;
}
