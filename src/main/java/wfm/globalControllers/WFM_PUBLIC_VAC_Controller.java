package wfm.globalControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wfm.payload.request.WFM_PUBLIC_VAC_Req;
import wfm.payload.response.APIResponse;

@RequestMapping("/WFM_PUBLIC_VAC")
public interface WFM_PUBLIC_VAC_Controller {
    @PostMapping("/searchPublicVac")
    public ResponseEntity<APIResponse>searchPublicVac(@RequestBody WFM_PUBLIC_VAC_Req wfmPublicVacSearchReq);
    @PostMapping("/updateWFMVac")
    public ResponseEntity<APIResponse> updateWFMVac(@RequestBody WFM_PUBLIC_VAC_Req wfm_PUBLIC_VAC_Req) ;
    @PostMapping("/insertWFMVac")
    public ResponseEntity<APIResponse> insertWFMVac(@RequestBody WFM_PUBLIC_VAC_Req wfm_PUBLIC_VAC_Req) ;
    @DeleteMapping("/deleteWFMVac")
    public ResponseEntity<APIResponse>deleteWFMVac(@RequestParam String vacationId);
}
