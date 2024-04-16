package co.istad.elearning_rest_api.userroleauthorities.features.users.dto;

import jakarta.validation.constraints.Email;

import java.util.Set;

public record UserRequest(
        String address1,
        String address2,
        int cityId,
        int countryId,
        String dob,
        @Email(message = "Email format is not correct!")
        String email,
        String familyName,
        String gender,
        String givenName,
        Set<String> roles,
        char nationalIdCard,
        char phoneNumber,
        char profile,
        String username,
        char uuid,
        char verifyCode


) {
}
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column(updatable = false, nullable = false)
//private String id;
//@Column(unique = true,nullable = false)
//private String address1;
//private String address2;
//private int city_id;
//private int country_id;
//private String dob;
//private String email;
//private String family_name;
//private String gender;
//private String given_name;
//@ManyToMany
//Set<Role> roles;
//private Boolean is_deleted;
//private Boolean is_verified;
//private char national_id_card;
//private char phone_number;
//private char profile;
//private char username;
//private char uuid;
//private char verify_code;



