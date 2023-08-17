package wfm.globalControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wfm.payload.response.APIResponse;

@RequestMapping("TGH_CITY")
public interface TGH_CITY_Controller {
    @GetMapping("/getAllCities")
    public ResponseEntity<APIResponse>getAllCities();
}
