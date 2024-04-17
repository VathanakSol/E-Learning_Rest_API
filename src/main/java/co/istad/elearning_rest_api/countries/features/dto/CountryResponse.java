package co.istad.elearning_rest_api.countries.features.dto;

import lombok.Builder;

@Builder
public class CountryResponse {
    private int id;
    private String flag;
    private String iso;
    private String name;
    private String nice_name;
    private int num_code;
    private int phone_code;
}
