package co.istad.elearning_rest_api.features.instructor.dto;

import lombok.Builder;

@Builder
public record InstructorUpdateRequest(
        String biography,
        String github,
        boolean is_booked,
        String job_title,
        String linked_in,
        String website
) {
}
