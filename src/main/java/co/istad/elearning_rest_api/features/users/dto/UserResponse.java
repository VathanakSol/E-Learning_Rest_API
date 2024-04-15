package co.istad.elearning_rest_api.features.users.dto;
import java.util.Set;

public record UserResponse(
        String id,
        String address1,
        String address2,
        int cityId,
        int countryId,
        String dob,
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
