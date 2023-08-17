package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wfm.models.TGH_POST_OFFICE;
import wfm.models.WFM_EMP;

import java.util.List;

@Repository
public interface TGH_POST_OFFICE_Repo extends JpaRepository<TGH_POST_OFFICE,String>, JpaSpecificationExecutor<TGH_POST_OFFICE> {
    @Query("Select office.emps from TGH_POST_OFFICE office where office.officeCode =:officeCode")
    List<WFM_EMP>getAllEmployees(@Param("officeCode") String officeCode);
}
