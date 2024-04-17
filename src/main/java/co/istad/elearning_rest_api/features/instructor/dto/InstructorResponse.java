package co.istad.elearning_rest_api.features.instructor.dto;

import lombok.Builder;

@Builder
public record InstructorResponse(
        String instructor_id,
        String biography,
        String github,
        boolean is_booked,
        String job_title,
        String linked_in,
        int user_id,
        String website
) {
}

