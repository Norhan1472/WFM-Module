package wfm.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wfm.models.WFM_SKILL_LEVEL;
import wfm.repos.WFM_SKILL_LEVEL_Repo;
import wfm.services.WFM_SKILL_LEVEL_Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WFM_SKILL_LEVEL_Service_Impl implements WFM_SKILL_LEVEL_Service {
    private final WFM_SKILL_LEVEL_Repo skillLevelRepo;
    @Autowired
    public WFM_SKILL_LEVEL_Service_Impl(WFM_SKILL_LEVEL_Repo skillLevelRepo) {
        this.skillLevelRepo = skillLevelRepo;
    }
    @Override
    public List<WFM_SKILL_LEVEL> getAllLevels() {
        return skillLevelRepo.findAll();
    }
}
