package co.istad.elearning_rest_api.enrollment.features.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
public record EnrollmentProgressRequest(
        int progress
) {

    public int getProgress() {
        return progress;
    }
}
