package wfm.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public interface WFM_CALENDER_SHIFT_Response {
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @JsonProperty("shiftStart")
    LocalDateTime getSHIFT_START();
    @JsonProperty("shiftId")
    String getSHIFT_ID();

}
