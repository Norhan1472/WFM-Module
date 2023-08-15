package wfm.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wfm.models.WFM_PUBLIC_VAC_TYPE;
import wfm.repos.WFM_PUBLIC_VAC_TYPE_Repo;
import wfm.services.WFM_PUBLIC_VAC_TYPE_Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WFM_PUBLIC_VAC_TYPE_Service_Impl implements WFM_PUBLIC_VAC_TYPE_Service {
    private final WFM_PUBLIC_VAC_TYPE_Repo wfmPublicVacTypeRepo;
    @Autowired
    public WFM_PUBLIC_VAC_TYPE_Service_Impl(WFM_PUBLIC_VAC_TYPE_Repo wfmPublicVacTypeRepo) {
        this.wfmPublicVacTypeRepo = wfmPublicVacTypeRepo;
    }

    @Override
    public List<WFM_PUBLIC_VAC_TYPE> getAllVacationTypes() {
        return wfmPublicVacTypeRepo.findAll();
    }
}
