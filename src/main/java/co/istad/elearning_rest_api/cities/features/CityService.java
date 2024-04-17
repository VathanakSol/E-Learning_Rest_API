package co.istad.elearning_rest_api.cities.features;

import co.istad.elearning_rest_api.cities.features.dto.CityResponse;

import java.util.List;

public interface CityService {
    List<CityResponse> findAllCities(String sortBy, String filterByName);
    List<CityResponse> findAllCitiesByCountryId(String countryId);

    List<CityResponse> findCitiesByCountry(String iso);
}
