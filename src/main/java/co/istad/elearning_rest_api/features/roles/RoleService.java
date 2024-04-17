package co.istad.elearning_rest_api.features.roles;

import co.istad.elearning_rest_api.features.roles.dto.RoleResponse;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<RoleResponse> getAllRoles();
    Optional<RoleResponse> getRoleByName(String name);
}

