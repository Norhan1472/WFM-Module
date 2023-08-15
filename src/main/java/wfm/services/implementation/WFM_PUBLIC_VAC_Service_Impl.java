package wfm.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import wfm.models.WFM_PUBLIC_VAC;
import wfm.models.WFM_PUBLIC_VAC_TYPE;
import wfm.payload.request.WFM_PUBLIC_VAC_Req;
import wfm.payload.response.WFM_PUBLIC_VAC_Search_Response;
import wfm.repos.WFM_PUBLIC_VAC_Repo;
import wfm.services.WFM_PUBLIC_VAC_Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class WFM_PUBLIC_VAC_Service_Impl implements WFM_PUBLIC_VAC_Service {
    @Autowired
    JdbcTemplate jdbcTemplate;
    WFM_PUBLIC_VAC_Repo wfmPublicVacRepo;
    @Autowired
    public WFM_PUBLIC_VAC_Service_Impl(WFM_PUBLIC_VAC_Repo wfmPublicVacRepo) {
        this.wfmPublicVacRepo = wfmPublicVacRepo;
    }

    @Override
    public List<WFM_PUBLIC_VAC_Search_Response> searchPublicVac(WFM_PUBLIC_VAC_Req searchRequest) {
        StringBuilder queryBuilder = new StringBuilder("SELECT " +
                "vac.VACATION_ID," +
                "vac.VACATION_NAME," +
                "vac.START_DATE ," +
                "type.VACATION_NAME AS VACATION_TYPE_ID " +
                "FROM WFM_PUBLIC_VAC vac " +
                "LEFT JOIN WFM_PUBLIC_VAC_TYPE type " +
                "ON vac.VACATION_TYPE_ID = type.VACATION_TYPE_ID "+
                "WHERE 1=1");

        List<Object> queryParams = new ArrayList<>();
        // VACATION_ID
        if (!(searchRequest.getVacationId() == null || searchRequest.getVacationId().equals(""))) {
            queryBuilder.append(" AND vac.VACATION_ID= ?");
            queryParams.add(searchRequest.getVacationId());
        }
        // VACATION_NAME
        if (!(searchRequest.getVacationName() == null || searchRequest.getVacationName().equals(""))) {
            queryBuilder.append(" AND vac.VACATION_NAME= ?");
            queryParams.add(searchRequest.getVacationName());
        }

        // VACATION_TYPE_ID
        if (!(searchRequest.getVacationTypeId() == null || searchRequest.getVacationTypeId().equals(""))) {
            queryBuilder.append(" AND type.VACATION_NAME= ?");
            queryParams.add(searchRequest.getVacationTypeId());
        }
        // START_DATE
        if (!(searchRequest.getStartDate() == null || searchRequest.getStartDate().equals(""))) {
            queryBuilder.append(" AND (to_char(vac.START_DATE, 'mm/dd/yyyy')=?)");
            String[] data = searchRequest.getStartDate().split("/");
            String startDate = searchRequest.getStartDate();
            if(data[0].length()==1){
                data[0]="0"+data[0];
                startDate= startDate.replace(startDate.substring(0,1),data[0]);
            }
            if(data[1].length()==1){
                data[1]="0"+data[1];
                startDate= startDate.replace(startDate.substring(3,4),data[1]);
            }
            System.out.println(startDate);
            queryParams.add(startDate);
        }
        //NUM_DAYS
        if (!(searchRequest.getNumDays()== 0 )) {
            queryBuilder.append(" AND vac.NUM_DAYS= ? ");
            queryParams.add(searchRequest.getNumDays());
        }

        String query = queryBuilder.toString();

        Object[] params = queryParams.toArray();

        // Execute the query
        @SuppressWarnings("deprecation")
        List<WFM_PUBLIC_VAC_Search_Response> results = jdbcTemplate.query(query, params, (rs, rowNum) -> {
            // Map the result rows to your Result class
            WFM_PUBLIC_VAC_Search_Response result = new WFM_PUBLIC_VAC_Search_Response();
            //VACATION_ID
            result.setVacationId(rs.getString("VACATION_ID"));
            //VACATION_NAME
            result.setVacationName(rs.getString("VACATION_NAME"));
            //VACATION_TYPE_ID
            result.setVacationTypeId(rs.getString("VACATION_TYPE_ID"));
            //START_DATE
            String pattern = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            if(rs.getDate("START_DATE")!=null){
                String startDate = simpleDateFormat.format(rs.getDate("START_DATE"));
                result.setStartDate(startDate);
            }
            return result;
        });

        return results;
    }

    @Override
    public WFM_PUBLIC_VAC updateWFMVac(WFM_PUBLIC_VAC_Req wfm_PUBLIC_VAC_Req) throws ParseException {
        //WFM_PUBLIC_VAC wfmPublicVac = new WFM_PUBLIC_VAC();
        WFM_PUBLIC_VAC wfmPublicVac = wfmPublicVacRepo.findById(wfm_PUBLIC_VAC_Req.getVacationId()).get();
        if(Objects.isNull(wfmPublicVac)){
            return wfmPublicVac;
        }else{
            //vacation name
            if(wfm_PUBLIC_VAC_Req.getVacationName()!=null && wfm_PUBLIC_VAC_Req.getVacationName()!=""){
                wfmPublicVac.setVacationName(wfm_PUBLIC_VAC_Req.getVacationName());
            }
            System.out.println(wfm_PUBLIC_VAC_Req.getStartDate());
            //date
            if(wfm_PUBLIC_VAC_Req.getStartDate()!=null){
                String sDate1=wfm_PUBLIC_VAC_Req.getStartDate();
                Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);
                System.out.println(date1);
                wfmPublicVac.setStartDate(date1);
            }
            // num days
            if(wfm_PUBLIC_VAC_Req.getNumDays()!=0){
                wfmPublicVac.setNumDays(wfm_PUBLIC_VAC_Req.getNumDays());
            }
            // vacation type id
            if(wfm_PUBLIC_VAC_Req.getVacationTypeId()!=null && wfm_PUBLIC_VAC_Req.getVacationTypeId()!=""){
                WFM_PUBLIC_VAC_TYPE vacType = new WFM_PUBLIC_VAC_TYPE();
                vacType.setVacationTypeId(wfm_PUBLIC_VAC_Req.getVacationTypeId());
                wfmPublicVac.setWfmPublicVacType(vacType);
            }
            return wfmPublicVacRepo.save(wfmPublicVac);
        }
    }
    @Override
    public WFM_PUBLIC_VAC insertWFMVac(WFM_PUBLIC_VAC_Req wfm_PUBLIC_VAC_Req) throws ParseException {
        WFM_PUBLIC_VAC wfmPublicVac = wfmPublicVacRepo.findById(wfm_PUBLIC_VAC_Req.getVacationId())
                .orElse(null);
        if(Objects.nonNull(wfmPublicVac)){
            return null;
        }
        wfmPublicVac = new WFM_PUBLIC_VAC();
        wfmPublicVac.setVacationId(wfm_PUBLIC_VAC_Req.getVacationId());
        if(wfm_PUBLIC_VAC_Req.getVacationName()!=null && wfm_PUBLIC_VAC_Req.getVacationName()!=""){
            wfmPublicVac.setVacationName(wfm_PUBLIC_VAC_Req.getVacationName());
        }
        System.out.println(wfm_PUBLIC_VAC_Req.getStartDate());
        //date
        if(wfm_PUBLIC_VAC_Req.getStartDate()!=null){
            String sDate1=wfm_PUBLIC_VAC_Req.getStartDate();
            Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);
            System.out.println(date1);
            wfmPublicVac.setStartDate(date1);
        }
        // num days
        if(wfm_PUBLIC_VAC_Req.getNumDays()!=0){
            wfmPublicVac.setNumDays(wfm_PUBLIC_VAC_Req.getNumDays());
        }
        // vacation type id
        if(wfm_PUBLIC_VAC_Req.getVacationTypeId()!=null && wfm_PUBLIC_VAC_Req.getVacationTypeId()!=""){
            WFM_PUBLIC_VAC_TYPE vacType = new WFM_PUBLIC_VAC_TYPE();
            vacType.setVacationTypeId(wfm_PUBLIC_VAC_Req.getVacationTypeId());
            wfmPublicVac.setWfmPublicVacType(vacType);
        }
        return wfmPublicVacRepo.save(wfmPublicVac);
    }

    @Override
    public Boolean deleteWFMVac(String vacationId) {
        WFM_PUBLIC_VAC publicVac = wfmPublicVacRepo.findById(vacationId).get();
        if(Objects.isNull(publicVac)){
            return false;//"vacation id not exist"
        }else{
            wfmPublicVacRepo.delete(publicVac);
            return true;//"vacation deleted successfully";
        }
    }


}
