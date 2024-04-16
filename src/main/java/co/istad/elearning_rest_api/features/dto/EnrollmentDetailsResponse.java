package co.istad.elearning_rest_api.features.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EnrollmentDetailsResponse(
    Long id,
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
