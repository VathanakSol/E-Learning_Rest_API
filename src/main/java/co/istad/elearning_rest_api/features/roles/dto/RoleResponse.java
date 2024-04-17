package co.istad.elearning_rest_api.features.roles.dto;

public record RoleResponse(
        long id,
        String name,
        java.util.Set<co.istad.elearning_rest_api.domain.Authority> authorities
) {}
