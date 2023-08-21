package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_SHIFTS;

@Repository
public interface WFM_SHIFTS_Repo extends JpaRepository<WFM_SHIFTS,String> {
}
