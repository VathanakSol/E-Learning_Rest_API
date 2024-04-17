package co.istad.elearning_rest_api.features.users;


import co.istad.elearning_rest_api.features.users.dto.UserRequest;
import co.istad.elearning_rest_api.features.users.dto.UserResponse;
import co.istad.elearning_rest_api.features.users.dto.UserUpdateRequest;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();
    UserResponse getUserByUsername(String username);
    void deleteUserByUsername(String id);
    UserResponse updateUserByUsername(String username, UserUpdateRequest userRequest);

    UserResponse disableUser(String username);
    UserResponse enableUser(String username);

}
