package wfm.globalControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wfm.payload.response.APIResponse;

@RequestMapping("/WFM_PUBLIC_VAC_TYPE")
public interface WFM_PUBLIC_VAC_TYPE_Controller {
    @GetMapping("/getAllVacationType")
    public ResponseEntity<APIResponse>getAllVacationType();
}
