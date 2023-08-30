package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_JOBS;

@Repository
public interface WFM_JOBS_Repo extends JpaRepository<WFM_JOBS,Long> {
}
