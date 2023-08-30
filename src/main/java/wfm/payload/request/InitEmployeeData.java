package wfm.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import wfm.models.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InitEmployeeData {
    private List<TGH_POST_OFFICE>offices;
    private List<WFM_SKILL_LEVEL>levels;
    private List<WFM_LABOR_TYPE>laborTypes;
    private List<TGH_CITY>cities;
    private List<WFM_JOBS>jobs;
    private List<WFM_JOB_TITLE>jobTitles;
    private List<WFM_QUALIFICATION>qualifications;
    private List<WFM_DEGREES>degrees;
    private List<WFM_GENDER>genders;

}
