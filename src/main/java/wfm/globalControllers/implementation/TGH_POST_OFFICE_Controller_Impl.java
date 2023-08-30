package wfm.globalControllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import wfm.globalControllers.TGH_POST_OFFICE_Controller;
import wfm.models.TGH_POST_OFFICE;
import wfm.models.WFM_EMP;
import wfm.payload.request.OFFICES_Search_Req;
import wfm.payload.response.APIResponse;
import wfm.payload.response.CustomEmployeeData;
import wfm.payload.response.OFFICES_Search_Response;
import wfm.repos.TGH_POST_OFFICE_Repo;
import wfm.services.TGH_POST_OFFICE_Service;
import wfm.wrapper.MapEmployees;
import wfm.wrapper.MapOffices;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TGH_POST_OFFICE_Controller_Impl implements TGH_POST_OFFICE_Controller {
    private final TGH_POST_OFFICE_Service tghPostOfficeService;
    private final TGH_POST_OFFICE_Repo tghPostOfficeRepo;
    @Autowired
    public TGH_POST_OFFICE_Controller_Impl(TGH_POST_OFFICE_Service tghPostOfficeService, TGH_POST_OFFICE_Repo tghPostOfficeRepo) {
        this.tghPostOfficeService = tghPostOfficeService;
        this.tghPostOfficeRepo = tghPostOfficeRepo;
    }

    @Override
    public ResponseEntity<APIResponse> searchOffices(OFFICES_Search_Req officesSearchReq) {
        APIResponse apiResponse = new APIResponse();
        try {
            //List<TGH_POST_OFFICE>result = tghPostOfficeService.searchOffices(officesSearchReq);
            //MapOffices mapOffices = new MapOffices();
            //List<TGH_POST_OFFICE>result = tghPostOfficeRepo.findAll();
            // List<OFFICES_Search_Response> data = mapOffices.customizedOfficeSearchResponse(result);
            List<OFFICES_Search_Response>result = tghPostOfficeService.searchOfficesJdbc(officesSearchReq);
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
    public ResponseEntity<APIResponse> getAllEmployees(String officeCode) {
        APIResponse apiResponse = new APIResponse();
        try {
            List<WFM_EMP>result = tghPostOfficeService.getAllEmployees(officeCode);
            MapEmployees mapEmployees =new MapEmployees();
            List<CustomEmployeeData>customizedDate = mapEmployees.customizedEmployeeResponse(result);
            //MapOffices mapOffices = new MapOffices();
            //List<TGH_POST_OFFICE>result = tghPostOfficeRepo.findAll();
            // List<OFFICES_Search_Response> data = mapOffices.customizedOfficeSearchResponse(result);
            if (result.isEmpty()) {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("No data found");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            } else {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setBody(customizedDate);
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
    public ResponseEntity<APIResponse> getAllOffices() {
        APIResponse apiResponse = new APIResponse();
        try {
            List<TGH_POST_OFFICE>result = tghPostOfficeService.getAllOffices();

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
