package wfm.globalControllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import wfm.globalControllers.WFM_PUBLIC_VAC_TYPE_Controller;
import wfm.models.WFM_PUBLIC_VAC_TYPE;
import wfm.payload.response.APIResponse;
import wfm.services.WFM_PUBLIC_VAC_TYPE_Service;

import java.util.List;

@RestController
public class WFM_PUBLIC_VAC_TYPE_Controller_Impl implements WFM_PUBLIC_VAC_TYPE_Controller {
    private final WFM_PUBLIC_VAC_TYPE_Service incidentSearchRequest;
    @Autowired
    public WFM_PUBLIC_VAC_TYPE_Controller_Impl(WFM_PUBLIC_VAC_TYPE_Service incidentSearchRequest) {
        this.incidentSearchRequest = incidentSearchRequest;
    }

    @Override
    public ResponseEntity<APIResponse> getAllVacationType() {
        APIResponse apiResponse = new APIResponse();
        try {
            List<WFM_PUBLIC_VAC_TYPE> result = incidentSearchRequest.getAllVacationTypes();
            System.out.println("result.size() = "+result.size());
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
