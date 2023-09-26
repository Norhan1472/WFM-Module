package wfm.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import wfm.models.WFM_EMP_VACATION;
import wfm.payload.request.WFM_EMP_VACATION_Req;
import wfm.payload.response.APIResponse;

public interface WFM_EMP_VACATION_Service {
    public String getEmpVacSeq();
    public ResponseEntity<APIResponse> insertEmpVac(long empId, WFM_EMP_VACATION_Req wfmEmpVacationReq);
    public ResponseEntity<APIResponse> updateEmpVac(long empId, WFM_EMP_VACATION_Req wfmEmpVacationReq);
    public ResponseEntity<APIResponse> deleteEmpVac(String vacId);
    public ResponseEntity<APIResponse> getVacationOfEmployeeById(long empId);
}
