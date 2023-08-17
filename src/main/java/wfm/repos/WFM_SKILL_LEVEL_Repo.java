package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_SKILL_LEVEL;

@Repository
public interface WFM_SKILL_LEVEL_Repo extends JpaRepository<WFM_SKILL_LEVEL,String> {
}
