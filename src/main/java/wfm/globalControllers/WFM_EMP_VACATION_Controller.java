package wfm.globalControllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wfm.models.WFM_EMP_VACATION;
import wfm.payload.response.APIResponse;

@RequestMapping("WFM_EMP_VACATION")
public interface WFM_EMP_VACATION_Controller {
    @GetMapping("getEmpVacSeq")
    public ResponseEntity<APIResponse> getEmpVacSeq();
    @PostMapping("insertEmpVac")
    public ResponseEntity<APIResponse> insertEmpVac(@RequestParam long empId, @RequestBody WFM_EMP_VACATION wfmEmpVacation);
}
