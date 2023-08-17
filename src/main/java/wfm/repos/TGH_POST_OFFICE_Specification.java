package wfm.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import wfm.models.TGH_CITY;
import wfm.models.TGH_POST_OFFICE;
import wfm.payload.request.OFFICES_Search_Req;
import wfm.payload.response.OFFICES_Search_Response;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TGH_POST_OFFICE_Specification implements Specification<TGH_POST_OFFICE> {
    private final OFFICES_Search_Req officesSearchReq;
    private EntityManager entityManager; // Inject EntityManager
    @Autowired
    public TGH_POST_OFFICE_Specification(OFFICES_Search_Req officesSearchReq) {
        this.officesSearchReq = officesSearchReq;
    }

    @Override
    public Predicate toPredicate(Root<TGH_POST_OFFICE> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates1=new ArrayList<>();
        Predicate predicateForSearch;

        // Define the list of selected columns
        /*query.multiselect(
                root.get("officeName")// Add other columns here
        );
        //,
        //                root.get("someOtherColumn")

        CriteriaQuery<OFFICES_Search_Response> resultQuery = criteriaBuilder.createQuery(OFFICES_Search_Response.class);

        Root<TGH_POST_OFFICE> resultRoot = resultQuery.from(TGH_POST_OFFICE.class);
        resultQuery.select(criteriaBuilder.construct(
                OFFICES_Search_Response.class,
                resultRoot.get("officeName")
        ));
*/
        if(officesSearchReq.getCityName()!=null && !officesSearchReq.getCityName().isEmpty()) {
            TGH_CITY tghCity = new TGH_CITY();
            tghCity.setCityCode(officesSearchReq.getCityName());
            predicates1.add(criteriaBuilder.equal(root.get("tghCity"), tghCity));
        }

        if(officesSearchReq.getOfficeName()!=null && !officesSearchReq.getOfficeName().isEmpty()) {
            predicates1.add(criteriaBuilder.equal(root.get("officeName"), officesSearchReq.getOfficeName()));
        }

        predicateForSearch=criteriaBuilder.and(predicates1.toArray(new Predicate[0]));
        return criteriaBuilder.and(predicateForSearch);
        /*predicateForSearch = criteriaBuilder.and(predicates1.toArray(new Predicate[0]));
        resultQuery.where(predicateForSearch);

        // Execute the result query and return the results
        TypedQuery<OFFICES_Search_Response> typedQuery = entityManager.createQuery(resultQuery);
        List<OFFICES_Search_Response> results = typedQuery.getResultList();
        printList(results);
        return null;*/
    }
   /* public void printList(List<OFFICES_Search_Response> results){
        for(int i=0;i<results.size();i++){
            System.out.print(results.get(i).getOfficeName());
        }
    }*/
}
