package wfm.globalControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wfm.models.WFM_SHIFTS;
import wfm.payload.response.APIResponse;

import java.util.List;

@RequestMapping("WFM_SHIFTS")
public interface WFM_SHIFTS_Controller {
    @GetMapping("getAllShifts")
    public ResponseEntity<APIResponse>getAllShifts();
}
