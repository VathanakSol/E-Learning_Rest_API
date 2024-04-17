package co.istad.elearning_rest_api.citycountry.countries.features;

import co.istad.elearning_rest_api.citycountry.countries.features.dto.CountryResponse;

import java.util.List;

public interface CountryService {
    List<CountryResponse> findAllCountries(String sortBy, String filterByName);
}
