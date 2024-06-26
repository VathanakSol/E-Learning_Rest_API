package co.istad.elearning_rest_api.citycountry.cities.features;

import co.istad.elearning_rest_api.citycountry.cities.features.dto.CityResponse;

import java.util.List;

public interface CityService {
    List<CityResponse> findAllCities(String sortBy, String filterByName);
    List<CityResponse> findCitiesByCountry(String iso, String sortBy, String filterByName);
}
