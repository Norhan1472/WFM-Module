package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_EMP_VACATION;

import java.math.BigDecimal;

@Repository
public interface WFM_EMP_VACATION_Repo extends JpaRepository<WFM_EMP_VACATION,String> {
    @Query(value = "SELECT WFM_EMP_VACATION_SEQ.nextval FROM dual", nativeQuery = true)
    public BigDecimal getNextValVacation_Seq();
}
