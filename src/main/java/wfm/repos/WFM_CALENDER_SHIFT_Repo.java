package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_CALENDER_SHIFT;

import java.util.Date;
import java.util.List;

@Repository
public interface WFM_CALENDER_SHIFT_Repo extends JpaRepository<WFM_CALENDER_SHIFT, Date> {
    @Query("SELECT c FROM WFM_CALENDER_SHIFT c WHERE c.wfm_emp.empId = :empId")
    List<WFM_CALENDER_SHIFT> findByEmpId(long empId);
    @Modifying
    @Query("DELETE FROM WFM_CALENDER_SHIFT c WHERE c.wfm_emp.empId = :empId")
    int  deleteShift(@Param("empId") long empId);
}
