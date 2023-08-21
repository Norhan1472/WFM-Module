package wfm.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wfm.models.WFM_SHIFTS;
import wfm.repos.WFM_SHIFTS_Repo;
import wfm.services.WFM_SHIFTS_Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WFM_SHIFTS_Service_Impl implements WFM_SHIFTS_Service {
    private final WFM_SHIFTS_Repo wfm_shifts_repo;
    @Autowired
    public WFM_SHIFTS_Service_Impl(WFM_SHIFTS_Repo wfmShiftsRepo) {
        wfm_shifts_repo = wfmShiftsRepo;
    }

    @Override
    public List<WFM_SHIFTS> getAllShifts() {
        return wfm_shifts_repo.findAll();
    }
}
