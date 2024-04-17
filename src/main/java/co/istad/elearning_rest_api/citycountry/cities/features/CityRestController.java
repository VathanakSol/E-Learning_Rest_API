package co.istad.elearning_rest_api.citycountry.cities.features;

import co.istad.elearning_rest_api.citycountry.cities.features.dto.CityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
public class CityRestController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<CityResponse> getAllCities(
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String filterByName)
    {
        return cityService.findAllCities(sortBy, filterByName);
    }

    @GetMapping("/{iso}/cities")
    public List<CityResponse> getCitiesByCountry(
            @PathVariable String iso,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String filterByName)
    {
        return cityService.findCitiesByCountry(iso, sortBy, filterByName);
    }
}
