package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_GENDER;

@Repository
public interface WFM_GENDER_Repo extends JpaRepository<WFM_GENDER,String> {
}
