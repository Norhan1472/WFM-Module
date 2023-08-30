package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_QUALIFICATION;

@Repository
public interface WFM_QUALIFICATION_Repo extends JpaRepository<WFM_QUALIFICATION,Long> {
}
