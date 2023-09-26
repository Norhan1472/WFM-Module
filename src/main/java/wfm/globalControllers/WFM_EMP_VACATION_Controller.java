package wfm.globalControllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wfm.models.WFM_EMP_VACATION;
import wfm.payload.request.WFM_EMP_VACATION_Req;
import wfm.payload.response.APIResponse;

@RequestMapping("WFM_EMP_VACATION")
public interface WFM_EMP_VACATION_Controller {
    @GetMapping("getEmpVacSeq")
    public ResponseEntity<APIResponse> getEmpVacSeq();
    @PostMapping("insertEmpVac")
    public ResponseEntity<APIResponse> insertEmpVac(@RequestParam long empId, @RequestBody WFM_EMP_VACATION_Req wfmEmpVacationReq);
    @PostMapping("updateEmpVac")
    public ResponseEntity<APIResponse> updateEmpVac(@RequestParam long empId, @RequestBody WFM_EMP_VACATION_Req wfmEmpVacationReq);
    @DeleteMapping("deleteEmpVac")
    public ResponseEntity<APIResponse> deleteEmpVac(@RequestParam String vacId);
    @GetMapping("getVacationOfEmployeeById")
    public ResponseEntity<APIResponse>getVacationOfEmployeeById(@RequestParam long empId);
}
