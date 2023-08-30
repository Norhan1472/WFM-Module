package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_JOB_TITLE;

@Repository
public interface WFM_JOB_TITLE_Repo extends JpaRepository<WFM_JOB_TITLE,Long> {
}
