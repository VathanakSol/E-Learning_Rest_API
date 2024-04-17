package co.istad.elearning_rest_api.citycountry.countries.features.dto;

import lombok.Builder;

@Builder
public record CountryRequest(
        String flag,
        String iso,
        String name,
        String nice_name,
        int num_code,
        int phone_code
) {

}
