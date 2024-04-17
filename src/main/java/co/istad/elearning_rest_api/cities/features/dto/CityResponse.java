package co.istad.elearning_rest_api.cities.features.dto;

import lombok.Builder;

@Builder
public record CityResponse (
        String name
){
}
