package co.istad.elearning_rest_api.course.features.dto;

import lombok.Builder;

@Builder
public record CategoryRequest(
        String alias,
        String icon,
        boolean isDeleted,
        String name,
        String parentCategoryId
) {

}