package wfm.globalControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wfm.models.TGH_POST_OFFICE;
import wfm.models.WFM_EMP;
import wfm.payload.request.OFFICES_Search_Req;
import wfm.payload.response.APIResponse;

import java.util.List;

@RequestMapping("TGH_POST_OFFICE")
public interface TGH_POST_OFFICE_Controller {
    @PostMapping("searchOffices")
    public ResponseEntity<APIResponse>searchOffices(@RequestBody OFFICES_Search_Req officesSearchReq);
    @GetMapping("getAllEmployees")
    public ResponseEntity<APIResponse> getAllEmployees(@RequestParam String officeCode);
    @GetMapping("getAllOffices")
    public ResponseEntity<APIResponse> getAllOffices();
}
