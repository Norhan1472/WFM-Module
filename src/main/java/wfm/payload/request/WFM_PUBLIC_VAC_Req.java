package wfm.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WFM_PUBLIC_VAC_Req {
    private String vacationId;
    private String vacationName;
    private String startDate;
    private long numDays;
    private String vacationTypeId;
}
