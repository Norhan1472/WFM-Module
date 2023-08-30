package wfm.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import wfm.models.TGH_POST_OFFICE;
import wfm.models.WFM_EMP;
import wfm.payload.request.OFFICES_Search_Req;
import wfm.payload.response.OFFICES_Search_Response;
import wfm.payload.response.WFM_PUBLIC_VAC_Search_Response;
import wfm.repos.TGH_POST_OFFICE_Repo;
import wfm.repos.TGH_POST_OFFICE_Specification;
import wfm.services.TGH_POST_OFFICE_Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TGH_POST_OFFICE_Service_Impl implements TGH_POST_OFFICE_Service {
    private final TGH_POST_OFFICE_Repo tghPostOfficeRepo;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public TGH_POST_OFFICE_Service_Impl(TGH_POST_OFFICE_Repo tghPostOfficeRepo) {
        this.tghPostOfficeRepo = tghPostOfficeRepo;
    }

    @Override
    public List<TGH_POST_OFFICE> searchOffices(OFFICES_Search_Req officesSearchReq) {
        TGH_POST_OFFICE_Specification citySpecification = new TGH_POST_OFFICE_Specification(officesSearchReq);
        List<TGH_POST_OFFICE>result = tghPostOfficeRepo.findAll(citySpecification);
        return result;
    }

    @Override
    public List<OFFICES_Search_Response> searchOfficesJdbc(OFFICES_Search_Req officesSearchReq) {
        StringBuilder queryBuilder = new StringBuilder("SELECT " +
                "office.OFFICE_NAME ," +
                "office.OFFICE_CODE "+
                "from TGH_POST_OFFICE office "+
                /*"vac.VACATION_ID," +
                "vac.VACATION_NAME," +
                "vac.START_DATE ," +
                "vac.NUM_DAYS, "+
                "type.VACATION_NAME AS VACATION_TYPE_ID " +
                "FROM WFM_PUBLIC_VAC vac " +
                "LEFT JOIN WFM_PUBLIC_VAC_TYPE type " +
                "ON vac.VACATION_TYPE_ID = type.VACATION_TYPE_ID "+*/
                "WHERE 1=1"
        );

        List<Object> queryParams = new ArrayList<>();
        // VACATION_ID
        if(!(officesSearchReq.getCityName() == null|| officesSearchReq.getCityName().equals(""))){
            queryBuilder.append(" AND office.CITY_CODE= ?");
            queryParams.add(officesSearchReq.getCityName());
        }
        if (!(officesSearchReq.getOfficeName() == null || officesSearchReq.getOfficeName().equals(""))) {
            queryBuilder.append(" AND office.OFFICE_NAME LIKE '%' || ?|| '%'");
            queryParams.add(officesSearchReq.getOfficeName());
        }

        String query = queryBuilder.toString();

        Object[] params = queryParams.toArray();

        // Execute the query
        @SuppressWarnings("deprecation")
        List<OFFICES_Search_Response> results = jdbcTemplate.query(query, params, (rs, rowNum) -> {
            // Map the result rows to your Result class
            OFFICES_Search_Response result = new OFFICES_Search_Response();
            //VACATION_ID
            result.setOfficeName(rs.getString("OFFICE_NAME"));
            //VACATION_NAME
            result.setOfficeCode(rs.getString("OFFICE_CODE"));

            return result;
        });

        return results;
    }

    @Override
    public List<WFM_EMP> getAllEmployees(String officeCode) {
        return tghPostOfficeRepo.getAllEmployees(officeCode);
    }

    @Override
    public List<TGH_POST_OFFICE> getAllOffices() {
        return tghPostOfficeRepo.findAll();
    }


}
