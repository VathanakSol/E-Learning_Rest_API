package co.istad.elearning_rest_api.enrollment.features.dto;

import lombok.Builder;
import lombok.Getter;


@Builder
public record EnrollmentProgressResponse(
    int progress
) {
    public int getProgress() {
        return progress;
    }
}
