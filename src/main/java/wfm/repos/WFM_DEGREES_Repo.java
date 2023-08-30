package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_DEGREES;

@Repository
public interface WFM_DEGREES_Repo extends JpaRepository<WFM_DEGREES,Long> {
}
