package co.istad.elearning_rest_api.instructor.features.dto;

import lombok.Builder;

@Builder
public record InstructorResponse(
        Long instructorId,
        int userid,
        String username,
        String biography,
        String github,
        boolean isBlocked,
        String jobTitle,
        String linkedIn,
        int userId,
        String website
) {
}

