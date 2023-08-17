package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_LABOR_TYPE;

@Repository
public interface WFM_LABOR_TYPE_Repo extends JpaRepository<WFM_LABOR_TYPE,String> {
}
