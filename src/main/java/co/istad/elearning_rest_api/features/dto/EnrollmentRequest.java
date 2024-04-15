package co.istad.elearning_rest_api.features.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EnrollmentRequest(
    String code,
    String courseTitle,
    String courseCategory,
    String studentUsername,
    boolean isCertified,
    LocalDateTime enrolledAt,
    int progress,
    boolean status
) {
}
