package wfm.globalControllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import wfm.globalControllers.TGH_CITY_Controller;
import wfm.models.TGH_CITY;
import wfm.models.TGH_POST_OFFICE;
import wfm.payload.response.APIResponse;
import wfm.services.TGH_CITY_Service;

import java.util.List;

@RestController
public class TGH_CITY_Controller_Impl implements TGH_CITY_Controller {
    private final TGH_CITY_Service tghCityService;
    @Autowired
    public TGH_CITY_Controller_Impl(TGH_CITY_Service tghCityService) {
        this.tghCityService = tghCityService;
    }

    @Override
    public ResponseEntity<APIResponse> getAllCities() {
        APIResponse apiResponse = new APIResponse();
        try {
            List<TGH_CITY> result = tghCityService.getAllCities();

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
