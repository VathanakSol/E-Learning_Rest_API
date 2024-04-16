package co.istad.elearning_rest_api.userroleauthorities.features.users;

import co.istad.elearning_rest_api.userroleauthorities.features.users.dto.UserRequest;
import co.istad.elearning_rest_api.userroleauthorities.features.users.dto.UserResponse;
import co.istad.elearning_rest_api.userroleauthorities.features.users.dto.UserUpdateRequest;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(String id);
    void deleteUserById(String id);
    UserResponse updateUserById(String id, UserUpdateRequest userRequest);

    UserResponse disableUser(String id);
    UserResponse enableUser(String id);
}
