package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_EMP;

@Repository
public interface WFM_EMP_Repo extends JpaRepository<WFM_EMP,Long> {
}
