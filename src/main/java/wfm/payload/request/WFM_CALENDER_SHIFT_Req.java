package wfm.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WFM_CALENDER_SHIFT_Req {
      String shiftId;
      //@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
      String shiftDate;
      //@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
      String startDate;
}
