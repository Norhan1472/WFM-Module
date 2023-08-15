package wfm.payload.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WFM_PUBLIC_VAC_Search_Response {
    private String vacationId;
    private String vacationName;
    private String vacationTypeId;
    private String startDate;
}
