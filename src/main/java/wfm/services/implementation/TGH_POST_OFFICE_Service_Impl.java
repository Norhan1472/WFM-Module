package wfm.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wfm.models.TGH_POST_OFFICE;
import wfm.models.WFM_EMP;
import wfm.payload.request.OFFICES_Search_Req;
import wfm.repos.TGH_POST_OFFICE_Repo;
import wfm.repos.TGH_POST_OFFICE_Specification;
import wfm.services.TGH_POST_OFFICE_Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TGH_POST_OFFICE_Service_Impl implements TGH_POST_OFFICE_Service {
    private final TGH_POST_OFFICE_Repo tghPostOfficeRepo;
    @Autowired
    public TGH_POST_OFFICE_Service_Impl(TGH_POST_OFFICE_Repo tghPostOfficeRepo) {
        this.tghPostOfficeRepo = tghPostOfficeRepo;
    }

    @Override
    public List<TGH_POST_OFFICE> searchOffices(OFFICES_Search_Req officesSearchReq) {
        TGH_POST_OFFICE_Specification citySpecification = new TGH_POST_OFFICE_Specification(officesSearchReq);
        List<TGH_POST_OFFICE>result = tghPostOfficeRepo.findAll(citySpecification);
        return result;
    }

    @Override
    public List<WFM_EMP> getAllEmployees(String officeCode) {
        return tghPostOfficeRepo.getAllEmployees(officeCode);
    }

    @Override
    public List<TGH_POST_OFFICE> getAllOffices() {
        return tghPostOfficeRepo.findAll();
    }


}
