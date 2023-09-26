package wfm.services;

import org.springframework.http.ResponseEntity;
import wfm.models.WFM_EMP;
import wfm.payload.request.WFM_EMP_Request;
import wfm.payload.response.APIResponse;

public interface WFM_EMP_Service {
    public ResponseEntity<APIResponse> insertEmployee(WFM_EMP_Request emp);
    public ResponseEntity<APIResponse> updateEmployee(WFM_EMP_Request emp);
    public ResponseEntity<APIResponse> deleteEmployee(long empId);
    public ResponseEntity<APIResponse> initData();
    public ResponseEntity<APIResponse> getEmployeeById(long empId);
}
