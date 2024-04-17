package co.istad.elearning_rest_api.cities.features.dto;

import lombok.Builder;

@Builder
public record CityRequest(
        int id,
        String name
) {

}
