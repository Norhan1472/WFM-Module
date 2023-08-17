package wfm.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wfm.models.WFM_LABOR_TYPE;
import wfm.repos.WFM_LABOR_TYPE_Repo;
import wfm.services.WFM_LABOR_TYPE_Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WFM_LABOR_TYPE_Service_Impl implements WFM_LABOR_TYPE_Service {
    private final WFM_LABOR_TYPE_Repo laborTypeRepo;
    @Autowired
    public WFM_LABOR_TYPE_Service_Impl(WFM_LABOR_TYPE_Repo laborTypeRepo) {
        this.laborTypeRepo = laborTypeRepo;
    }

    @Override
    public List<WFM_LABOR_TYPE> getAllLaborTypes() {
        return laborTypeRepo.findAll();
    }
}
