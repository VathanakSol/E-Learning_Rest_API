package co.istad.elearning_rest_api.countries.features;

import co.istad.elearning_rest_api.countries.features.dto.CountryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Override
    public List<CountryResponse> findAllCountries(String sortBy, String filterByName) {
        return null;
    }
}
