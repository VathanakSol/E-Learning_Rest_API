package co.istad.elearning_rest_api.features.roles;

import co.istad.elearning_rest_api.features.roles.dto.RoleResponse;
import co.istad.elearning_rest_api.utils.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1/roles")
public class RoleRestController {
    private final RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public BaseResponse<List<RoleResponse>> getAllRoles() {
        return BaseResponse.<List<RoleResponse>>ok()
                .setPayload(roleService.getAllRoles());
    }

    @GetMapping("/{name}")
    public BaseResponse<RoleResponse> getRoleByName(@PathVariable String name) {
        return roleService.getRoleByName(name)
                .map(roleResponse -> BaseResponse.<RoleResponse>ok().setPayload(roleResponse))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role with name = " + name + " not found."));
    }

}

