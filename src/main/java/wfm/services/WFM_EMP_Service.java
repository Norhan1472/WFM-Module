package wfm.services;

import org.springframework.http.ResponseEntity;
import wfm.models.WFM_EMP;
import wfm.payload.response.APIResponse;

public interface WFM_EMP_Service {
    public ResponseEntity<APIResponse> insertEmployee(WFM_EMP emp);
    public ResponseEntity<APIResponse> updateEmployee(WFM_EMP emp);
    public ResponseEntity<APIResponse> deleteEmployee(long empId);
}
