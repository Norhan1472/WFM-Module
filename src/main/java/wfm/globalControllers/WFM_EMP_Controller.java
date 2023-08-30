package wfm.globalControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wfm.models.WFM_EMP;
import wfm.payload.request.WFM_EMP_Request;
import wfm.payload.response.APIResponse;

@RequestMapping("WFM_EMP")
public interface WFM_EMP_Controller {
    @PostMapping("insertEmployee")
    public ResponseEntity<APIResponse>insertEmployee(@RequestBody WFM_EMP_Request emp);
    @PostMapping("updateEmployee")
    public ResponseEntity<APIResponse>updateEmployee(@RequestBody WFM_EMP_Request emp);
    @DeleteMapping("deleteEmployee")
    public ResponseEntity<APIResponse> deleteEmployee(@RequestParam long empId);
    @GetMapping("initData")
    public ResponseEntity<APIResponse>initData();
}
