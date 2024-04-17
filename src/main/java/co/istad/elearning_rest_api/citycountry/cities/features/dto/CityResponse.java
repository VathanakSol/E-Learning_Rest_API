package co.istad.elearning_rest_api.citycountry.cities.features.dto;

import lombok.Builder;

@Builder
public record CityResponse(
        int id,
        String name
) {
}
