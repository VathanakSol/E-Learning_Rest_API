package co.istad.elearning_rest_api.cities.features.dto;

import lombok.Builder;

@Builder
public class CityResponse {
    private int id;
    private int country_id;
    private String name;
}
