package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_EMP_VACATION;
import wfm.payload.response.WFM_EMP_VACATION_Response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface WFM_EMP_VACATION_Repo extends JpaRepository<WFM_EMP_VACATION,String> {
    @Query(value = "SELECT WFM_EMP_VACATION_SEQ.nextval FROM dual", nativeQuery = true)
    public BigDecimal getNextValVacation_Seq();
    @Query(value = "SELECT * FROM WFM_EMP_VACATION where emp_id=:id", nativeQuery = true)
    List<WFM_EMP_VACATION_Response>findVacationByEmployeeId(@Param("id") long id);
    @Modifying
    @Query(value = "INSERT INTO WFM_EMP_VACATION (no_days, start_date, emp_id, vacation_id) " +
            "VALUES (:noDays, :startDate, :empId, :vacationId)", nativeQuery = true)
    void saveVacation(
            @Param("vacationId") String vacationId,
            @Param("noDays") Long noDays,
            @Param("empId") Long empId,
            @Param("startDate") Date startDate);
}//update wfm_emp_vacation set no_days=?, start_date=?, emp_id=? where vacation_id=?
/*
private String vacationId;
    @Column(name = "NO_DAYS")
    private Long noDays;
    @Column(name = "START_DATE")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date startDate;
    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    private WFM_EMP wfmEmp;
 */
