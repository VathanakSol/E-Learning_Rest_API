package co.istad.elearning_rest_api.instructor.features.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record InstructorCreateRequest(
        @NotBlank
        int userId,
        String username,
        @NotBlank(message = "Biography is required")
        String biography,
        String github,
        @NotEmpty
        @NotBlank(message = "book status is required")
        boolean isBlocked,
        @NotEmpty
        @NotBlank(message = "job title is required")
        String jobTitle,
        @NotBlank(message = "linked in is required")
        String linkedIn,
        @NotBlank(message = "website is required")
        String website
) {
}
