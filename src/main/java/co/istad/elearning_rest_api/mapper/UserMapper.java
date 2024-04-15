package co.istad.elearning_rest_api.mapper;


import co.istad.elearning_rest_api.domain.Role;
import co.istad.elearning_rest_api.domain.User;
import co.istad.elearning_rest_api.features.users.dto.UserRequest;
import co.istad.elearning_rest_api.features.users.dto.UserResponse;
import co.istad.elearning_rest_api.features.users.dto.UserUpdateRequest;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Named("toUserResponse")
    @Mapping(target = "roles", expression = "java(mapRoles(user.getRoles()))")
    @Mapping(target = "nationalIdCard", source = "nationalIdCard")
    UserResponse toUserResponse(User user);

    default Set<String> mapRoles(Set<Role> roles) {
        return roles.stream().map(Role::getName).collect(Collectors.toSet());
    }

    //    define method that convert the set of role to set of string
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "nationalIdCard", source = "nationalIdCard")
    User requestToUser(UserRequest userRequest);

    @Mapping(target = "roles", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromRequest(@MappingTarget User user, UserUpdateRequest userRequest);
}
