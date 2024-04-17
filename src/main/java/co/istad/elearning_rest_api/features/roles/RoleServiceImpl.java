package co.istad.elearning_rest_api.features.roles;

import co.istad.elearning_rest_api.domain.Role;
import co.istad.elearning_rest_api.features.roles.dto.RoleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<RoleResponse> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(this::toRoleResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RoleResponse> getRoleByName(String name) {
        return Optional.ofNullable(roleRepository.findByName(name)
                .map(this::toRoleResponse)
                .orElseThrow(() -> new NoSuchElementException("Role with name = " + name + " not found.")));
    }

    private RoleResponse toRoleResponse(Role role) {
        // Implement the conversion logic here
        // For example:
        return new RoleResponse(role.getId(), role.getName(), role.getAuthorities());
    }


}
