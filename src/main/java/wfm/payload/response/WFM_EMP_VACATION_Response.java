package wfm.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Date;

public interface WFM_EMP_VACATION_Response {
    @JsonProperty("vacationId")
    String getVACATION_ID();
    @JsonProperty("noDays")
    long getNO_DAYS();
    @JsonProperty("startDate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate getSTART_DATE();
}
