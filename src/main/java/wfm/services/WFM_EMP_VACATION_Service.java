package wfm.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import wfm.models.WFM_EMP_VACATION;
import wfm.payload.response.APIResponse;

public interface WFM_EMP_VACATION_Service {
    public String getEmpVacSeq();
    public ResponseEntity<APIResponse> insertEmpVac(long empId, WFM_EMP_VACATION wfmEmpVacation);
}
