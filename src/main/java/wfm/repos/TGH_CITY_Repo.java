package wfm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wfm.models.TGH_CITY;

@Repository
public interface TGH_CITY_Repo extends JpaRepository<TGH_CITY,String> {
}
