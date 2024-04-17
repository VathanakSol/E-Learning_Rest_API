package co.istad.elearning_rest_api.course.features.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder

public record CategoryUpdateRequest(

    String alias,
    String icon,
    boolean isDeleted,
    String name,
    String parentCategoryId
) {
    @Override
    public boolean isDeleted() {
        return isDeleted;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

}
