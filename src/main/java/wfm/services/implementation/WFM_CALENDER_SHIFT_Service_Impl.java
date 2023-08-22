package wfm.services.implementation;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import wfm.models.WFM_CALENDER_SHIFT;
import wfm.models.WFM_EMP;
import wfm.models.WFM_SHIFTS;
import wfm.payload.request.WFM_CALENDER_SHIFT_Insert_Req;
import wfm.payload.response.APIResponse;
import wfm.payload.response.WFM_PUBLIC_VAC_Search_Response;
import wfm.repos.WFM_CALENDER_SHIFT_Repo;
import wfm.services.WFM_CALENDER_SHIFT_Service;

import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class WFM_CALENDER_SHIFT_Service_Impl implements WFM_CALENDER_SHIFT_Service {
    private final WFM_CALENDER_SHIFT_Repo wfm_calender_shift_repo;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public WFM_CALENDER_SHIFT_Service_Impl(WFM_CALENDER_SHIFT_Repo wfmCalenderShiftRepo) {
        wfm_calender_shift_repo = wfmCalenderShiftRepo;
    }

    @Override
    public ResponseEntity<APIResponse> insertGroupShift(WFM_CALENDER_SHIFT_Insert_Req shift_insert_req) {
        APIResponse apiResponse = new APIResponse();
        try {
            // validation employee
            if(shift_insert_req.getWfm_emps().isEmpty()){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must select at least 1 employee");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            //validation date from
            if(shift_insert_req.getDateFrom() == null || shift_insert_req.getDateFrom().equals("")){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter Date From");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            //validation shift id
            if(shift_insert_req.getWfm_shifts() == null || shift_insert_req.getWfm_shifts().equals("")){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter Shift Id");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            //validation date to
            if(shift_insert_req.getDateTo() == null || shift_insert_req.getDateTo().equals("")){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter Date To");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            /*WFM_EMP checkExistEmp = empRepo.findById(empId).orElse(null);
            if(Objects.isNull(checkExistEmp)){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("This Employee id is not exist ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(empVacation.getStartDate()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("YOU MUST ENTER START DATE ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(empVacation.getVacationId()==null ||empVacation.getVacationId().equals("") ){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("YOU MUST ENTER VACATION ID ");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }*/
            else {

                // System.out.println(empVacation.getVacationId());
                /*empVacation.setWfmEmp(checkExistEmp);
                //System.out.println(checkExistEmp.getFirstName());
                vacationRepo.save(empVacation);*/

                WFM_CALENDER_SHIFT wfm_calender_shift = new WFM_CALENDER_SHIFT();
                System.out.println(shift_insert_req.getDateFrom());
                /*DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String strDate = dateFormat.format(shift_insert_req.getDateFrom());*/

                String dateFrom=shift_insert_req.getDateFrom();
                Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(dateFrom);
                wfm_calender_shift.setShiftStart(date1);
                System.out.println();
                System.out.println(dateFrom);
                String dateTo=shift_insert_req.getDateTo();
                Date date2=new SimpleDateFormat("dd-MM-yyyy").parse(dateTo);
                wfm_calender_shift.setCalenderDate(date2);
                WFM_SHIFTS wfm_shifts = new WFM_SHIFTS();
                wfm_shifts.setShiftId(shift_insert_req.getWfm_shifts());
                wfm_calender_shift.setWfm_shifts(wfm_shifts);
                System.out.println("llkk");
                System.out.println(shift_insert_req.getWfm_emps().size());
                for(long empId : shift_insert_req.getWfm_emps()){
                    WFM_EMP emp = new WFM_EMP();
                    emp.setEmpId(empId);
                    wfm_calender_shift.setWfm_emp(emp);
                    System.out.println("ssppp");
                    System.out.println(wfm_calender_shift.getShiftStart());
                    wfm_calender_shift_repo.save(wfm_calender_shift);
                }
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setBody("Shift inserted Successfully");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
            apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<APIResponse> insertGroupShiftInQuery(WFM_CALENDER_SHIFT_Insert_Req shift_insert_req) throws ParseException {
        StringBuilder queryBuilder = new StringBuilder("INSERT ALL ");
        APIResponse apiResponse = new APIResponse();
        List<Object> queryParams = new ArrayList<>();
        // validation employee
        if(shift_insert_req.getWfm_emps().isEmpty()){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("You Must select at least 1 employee");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        //validation date from
        if(shift_insert_req.getDateFrom() == null || shift_insert_req.getDateFrom().equals("")){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("You Must Enter Date From");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        //validation shift id
        if(shift_insert_req.getWfm_shifts() == null || shift_insert_req.getWfm_shifts().equals("")){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("You Must Enter Shift Id");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        //validation date to
        if(shift_insert_req.getDateTo() == null || shift_insert_req.getDateTo().equals("")){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("You Must Enter Date To");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        else{
            String []dateStart = shift_insert_req.getDateFrom().split("-");
            String []dateEnd = shift_insert_req.getDateTo().split("-");
            LocalDate startDate = LocalDate.of(Integer.parseInt(dateStart[2]), Integer.parseInt(dateStart[1]),Integer.parseInt(dateStart[0]));
            LocalDate endDate = LocalDate.of(Integer.parseInt(dateEnd[2]), Integer.parseInt(dateEnd[1]),Integer.parseInt(dateEnd[0]));

            List<String> datesInRange = getDatesBetween(startDate, endDate);
            System.out.println("testing");
            System.out.println(datesInRange.size());
            for (String date : datesInRange) {
                for (long id : shift_insert_req.getWfm_emps()) {
                    queryBuilder.append("INTO wfm_calendar_shift (shift_start, emp_id, calendar_date, shift_id ) VALUES ( to_date(?, 'DD-MM-YYYY') + TO_DSINTERVAL('0 ' || ?), ? , to_date(? , 'DD-MM-YYYY'), ?) ");
                    queryParams.add(date);
                    queryParams.add(shift_insert_req.getStartHour());
                    queryParams.add(id);
                    queryParams.add(shift_insert_req.getDateTo());
                    queryParams.add(shift_insert_req.getWfm_shifts());
                }
            }
            /*for (long id : shift_insert_req.getWfm_emps()) {
               */
            /* queryParams.add(shift_insert_req.getDateFrom());
                queryParams.add(id);
                queryParams.add(shift_insert_req.getDateTo());
                queryParams.add(shift_insert_req.getWfm_shifts());*/
            /*
            }*/
            queryBuilder.append(" SELECT 1 FROM dual");
            String query = queryBuilder.toString();
            int updatedRows = jdbcTemplate.update(query, queryParams.toArray());

            if (updatedRows > 0) {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("Shifts Inserted Successfully");
            } else {
                apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                apiResponse.setClientMessage("Failed to insert shifts");
            }

            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            }
    }


    private List<String> getDatesBetween(LocalDate startDate, LocalDate endDate) {
            List<String> datesInRange = new ArrayList<>();
            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

            for (int i = 0; i <= daysBetween; i++) {
                LocalDate currentDate = startDate.plusDays(i);
                datesInRange.add(String.valueOf(currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                System.out.println("currentDate = "+currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }

            return datesInRange;
        }
    @Override
    public ResponseEntity<APIResponse> deleteShift(long empId) {
        APIResponse apiResponse = new APIResponse();
        List<WFM_CALENDER_SHIFT> wfm_calender_shift = wfm_calender_shift_repo.findByEmpId(empId);
        if (wfm_calender_shift.isEmpty()){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("There is no shifts for this employee");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);

        }
        String sql = "DELETE FROM WFM_CALENDAR_SHIFT WHERE emp_id = ?";

        int updatedRows = jdbcTemplate.update(sql, empId);
        if (updatedRows > 0) {
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setClientMessage("Shifts Deleted Successfully");
        } else {
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage("Failed to delete shifts");
        }

       /* int num = wfm_calender_shift_repo.deleteShift(empId);
        System.out.println(num);
        if(num>0){
            new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
        }
*/
        return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
    }


    /*private String putHoursWithDate(String dateString,String hoursString) throws ParseException {
        // Date in the format "dd-MM-yyyy"
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormatter.parse(dateString);

        // Convert the Date to LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), java.time.ZoneId.systemDefault());

        // Add hours to LocalDateTime
        String[] hoursMinutes = hoursString.split(":");
        int hours = Integer.parseInt(hoursMinutes[0]);
        int minutes = Integer.parseInt(hoursMinutes[1]);
        localDateTime = localDateTime.withHour(hours);
        localDateTime = localDateTime.withMinute(minutes);

        // Format the final LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = localDateTime.format(formatter);
        System.out.println("Final Formatted Date-Time: " + formattedDateTime);
        return formattedDateTime;
    }*/
}
