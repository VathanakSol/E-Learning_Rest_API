package co.istad.elearning_rest_api.student.feature.dto;

public record StudentResponse(
        Long id,
        String username,
        String highSchool,
        Boolean isBlocked,
        String universityUserId
) {
}
