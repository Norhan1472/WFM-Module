package wfm.payload.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomEmployeeData {
    private long empId;
    private String firstName;
    private String lastName;
    private String gender;
    private long phone;
    private String address;
}
