package co.istad.elearning_rest_api.cities.features;

import co.istad.elearning_rest_api.cities.features.dto.CityResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Override
    public List<CityResponse> findAllCities(String sortBy, String filterByName) {
        return null;
    }

    @Override
    public List<CityResponse> findCitiesByCountry(String iso, String sortBy, String filterByName) {
        return null;
    }
}
