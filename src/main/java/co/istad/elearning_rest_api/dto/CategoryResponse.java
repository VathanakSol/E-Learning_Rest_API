package co.istad.elearning_rest_api.dto;

import lombok.Builder;

@Builder
public record CategoryResponse(
    Long id,
    String alias,
    String icon,
    boolean isDeleted,
    String name,
    String parentCategoryId
) {
}
