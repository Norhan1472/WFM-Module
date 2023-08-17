package wfm.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wfm.models.TGH_CITY;
import wfm.repos.TGH_CITY_Repo;
import wfm.services.TGH_CITY_Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TGH_CITY_Service_Impl implements TGH_CITY_Service {
    private final TGH_CITY_Repo tghCityRepo;
    @Autowired
    public TGH_CITY_Service_Impl(TGH_CITY_Repo tghCityRepo) {
        this.tghCityRepo = tghCityRepo;
    }

    @Override
    public List<TGH_CITY> getAllCities() {
        return tghCityRepo.findAll();
    }
}
