package co.istad.elearning_rest_api.enrollment.features.dto;

import lombok.Builder;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
public record EnrollmentRequest(
    String code,
    String courseTitle,
    String courseCategory,
    String studentUsername,
    boolean isCertified,
    LocalDateTime enrolledAt,
    @Setter
    int progress,
    boolean status
) {
    public int getProgress() {
        return progress;
    }
}
