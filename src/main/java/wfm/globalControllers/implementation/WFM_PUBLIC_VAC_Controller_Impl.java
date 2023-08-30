package wfm.globalControllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import wfm.globalControllers.WFM_PUBLIC_VAC_Controller;
import wfm.models.WFM_PUBLIC_VAC;
import wfm.models.WFM_PUBLIC_VAC_TYPE;
import wfm.payload.request.WFM_PUBLIC_VAC_Req;
import wfm.payload.response.APIResponse;
import wfm.payload.response.WFM_PUBLIC_VAC_Search_Response;
import wfm.services.WFM_PUBLIC_VAC_Service;

import java.util.List;
import java.util.Objects;

@RestController
public class WFM_PUBLIC_VAC_Controller_Impl implements WFM_PUBLIC_VAC_Controller {
    private final WFM_PUBLIC_VAC_Service wfmPublicVacService;
    @Autowired
    public WFM_PUBLIC_VAC_Controller_Impl(WFM_PUBLIC_VAC_Service wfmPublicVacService) {
        this.wfmPublicVacService = wfmPublicVacService;
    }

    @Override
    public ResponseEntity<APIResponse> searchPublicVac(WFM_PUBLIC_VAC_Req wfmPublicVacSearchReq) {
        APIResponse apiResponse = new APIResponse();
        try {
            List<WFM_PUBLIC_VAC_Search_Response> result = wfmPublicVacService.searchPublicVac(wfmPublicVacSearchReq);
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

    @Override
    public ResponseEntity<APIResponse> updateWFMVac(WFM_PUBLIC_VAC_Req wfm_PUBLIC_VAC_Req) {
        APIResponse apiResponse = new APIResponse();
        try {
            WFM_PUBLIC_VAC_Search_Response result = wfmPublicVacService.updateWFMVac(wfm_PUBLIC_VAC_Req);
            if (Objects.isNull(result)) {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("No data found");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            } else {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("Vacation Updated Successfully");
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

    @Override
    public ResponseEntity<APIResponse> insertWFMVac(WFM_PUBLIC_VAC_Req wfm_PUBLIC_VAC_Req) {
        APIResponse apiResponse = new APIResponse();
        try {
            System.out.println("lll");
            System.out.println(wfm_PUBLIC_VAC_Req.getVacationId());
            if(wfm_PUBLIC_VAC_Req.getVacationId()==""||wfm_PUBLIC_VAC_Req.getVacationId()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("Please Enter vacation id");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            WFM_PUBLIC_VAC_Search_Response result = wfmPublicVacService.insertWFMVac(wfm_PUBLIC_VAC_Req);
            if (Objects.isNull(result)) {
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("Duplicated vacation id");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            } else {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("Vacation Inserted Successfully");
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

    @Override
    public ResponseEntity<APIResponse> deleteWFMVac(String vacationId) {
        APIResponse apiResponse = new APIResponse();
        try {
            boolean result = wfmPublicVacService.deleteWFMVac(vacationId);
            if (!result) {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("vacation id not exist");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            } else {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("vacation deleted successfully");
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

    @Override
    public ResponseEntity<APIResponse> getWFMVacById(String vacationId) {
        APIResponse apiResponse = new APIResponse();
        try {
            return wfmPublicVacService.getWFMVacById(vacationId);

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
