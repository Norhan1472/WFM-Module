package wfm.globalControllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import wfm.globalControllers.WFM_SKILL_LEVEL_Controller;
import wfm.models.TGH_CITY;
import wfm.models.WFM_SKILL_LEVEL;
import wfm.payload.response.APIResponse;
import wfm.services.WFM_SKILL_LEVEL_Service;

import java.util.List;

@RestController
public class WFM_SKILL_LEVEL_Controller_Impl implements WFM_SKILL_LEVEL_Controller {
    private final WFM_SKILL_LEVEL_Service skillLevelService;
    @Autowired
    public WFM_SKILL_LEVEL_Controller_Impl(WFM_SKILL_LEVEL_Service skillLevelService) {
        this.skillLevelService = skillLevelService;
    }

    @Override
    public ResponseEntity<APIResponse> getAllLevels() {
        APIResponse apiResponse = new APIResponse();
        System.out.println("lll");
        try {
            List<WFM_SKILL_LEVEL> result = skillLevelService.getAllLevels();

            if (result.isEmpty()) {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("No data found");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            } else {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setBody(result);
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
            apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
