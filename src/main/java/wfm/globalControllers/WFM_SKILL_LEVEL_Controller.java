package wfm.globalControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wfm.payload.response.APIResponse;

@RequestMapping("WFM_SKILL_LEVEL")
public interface WFM_SKILL_LEVEL_Controller {
    @GetMapping("getAllLevels")
    public ResponseEntity<APIResponse> getAllLevels();
}
