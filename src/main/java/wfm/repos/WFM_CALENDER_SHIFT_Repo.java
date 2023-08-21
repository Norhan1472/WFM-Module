package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_CALENDER_SHIFT;

import java.util.Date;

@Repository
public interface WFM_CALENDER_SHIFT_Repo extends JpaRepository<WFM_CALENDER_SHIFT, Date> {
}
