package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_PUBLIC_VAC;

@Repository
public interface WFM_PUBLIC_VAC_Repo extends JpaRepository<WFM_PUBLIC_VAC,String> {
}
