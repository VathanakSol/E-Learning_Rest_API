package co.istad.elearning_rest_api.countries.features.dto;

import lombok.Builder;

@Builder
public record CountryResponse (
         int id,
         String flag,
         String iso,
         String name,
         String nice_name,
         int num_code,
         int phone_code
){

}
