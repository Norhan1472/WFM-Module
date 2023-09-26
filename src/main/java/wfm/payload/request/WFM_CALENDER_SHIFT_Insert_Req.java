package wfm.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import wfm.models.WFM_EMP;
import wfm.models.WFM_SHIFTS;

import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WFM_CALENDER_SHIFT_Insert_Req {
    private String officeCode;
    private String wfm_shifts;
    private String startHour;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String dateFrom;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String dateTo;
   // private Set<Long>wfm_emps = new HashSet<>();
    private Long wfm_emp;
}
