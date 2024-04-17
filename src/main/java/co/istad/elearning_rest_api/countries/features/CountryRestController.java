package co.istad.elearning_rest_api.countries.features;

import co.istad.elearning_rest_api.countries.features.dto.CountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryRestController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<CountryResponse> getAllCountries(@RequestParam(required = false) String sortBy,
                                                 @RequestParam(required = false) String filterByName) {
        return countryService.findAllCountries(sortBy, filterByName);
    }
}
