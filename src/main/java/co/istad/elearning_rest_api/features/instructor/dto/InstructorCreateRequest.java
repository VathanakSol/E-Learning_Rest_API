package co.istad.elearning_rest_api.features.instructor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record InstructorCreateRequest(
        @NotBlank(message = "Biography is required")
        String biography,
        String github,
        @NotEmpty
        @NotBlank(message = "book status is required")
        boolean is_booked,
        @NotEmpty
        @NotBlank(message = "job title is required")
        String job_title,
        @NotBlank(message = "linked in is required")
        String linked_in,
        @NotBlank(message = "website is required")
        String website
) {
}
