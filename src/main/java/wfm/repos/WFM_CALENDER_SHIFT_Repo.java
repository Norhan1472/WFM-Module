package wfm.repos;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wfm.models.WFM_CALENDAR_SHIFT;
import wfm.payload.response.WFM_CALENDER_SHIFT_Response;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface WFM_CALENDER_SHIFT_Repo extends JpaRepository<WFM_CALENDAR_SHIFT, Date> {
    @Query("SELECT c FROM WFM_CALENDAR_SHIFT c WHERE c.wfm_emp.empId = :empId")
    List<WFM_CALENDAR_SHIFT> findByEmpId(long empId);
    @Modifying
    @Query("DELETE FROM WFM_CALENDAR_SHIFT c WHERE c.wfm_emp.empId = :empId")
    int  deleteShift(@Param("empId") long empId);
    @Query(value = "SELECT shift_start,shift_ID FROM WFM_CALENDAR_SHIFT where emp_Id = :empId",nativeQuery = true)
    List<WFM_CALENDER_SHIFT_Response> ShiftsOfEmp(long empId);
    @Query(value = "SELECT shift_start, shift_ID FROM WFM_CALENDAR_SHIFT WHERE emp_Id = :empId AND shift_start = TO_DATE(:date, 'DD-MM-YYYY HH24:MI:SS')",nativeQuery = true)
    WFM_CALENDER_SHIFT_Response getOneShiftOfEmp(@Param("empId") long empId, @Param("date") String date);

    @Transactional
    @Modifying
    @Query(value = "UPDATE WFM_CALENDAR_SHIFT\n" +
            "SET shift_ID = :shiftId,\n" +
            "    shift_start = TO_DATE(:shiftDate, 'DD-MM-YYYY')\n" +
            "WHERE emp_Id = :empId\n" +
            "  AND shift_start = to_date(:startDate, 'DD-MM-YYYY') + TO_DSINTERVAL('0 ' || :hours) \n",nativeQuery = true)
    int updateShift(String shiftId,String shiftDate,long empId, String startDate,String hours);//, WFM_CALENDER_SHIFT_Response shift
    @Modifying
    @Query(value = "DELETE FROM WFM_CALENDAR_SHIFT WHERE emp_id = :empId AND shift_start = TO_DATE(:startDate, 'DD-MM-YYYY HH24:MI:SS')",nativeQuery = true)
    int deleteShiftOfEmp(long empId, String startDate);
    @Query(value ="Select emp_id from wfm_emp where office_code = :officeCode",nativeQuery = true)
    List<Long>getTghByOfficeCode(String officeCode);
}
