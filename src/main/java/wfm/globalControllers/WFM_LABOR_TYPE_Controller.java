package wfm.globalControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wfm.payload.response.APIResponse;

@RequestMapping("WFM_LABOR_TYPE")
public interface WFM_LABOR_TYPE_Controller {
    @GetMapping("getAllLaborTypes")
    public ResponseEntity<APIResponse>getAllLaborTypes();
}
