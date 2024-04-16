package co.istad.elearning_rest_api.userroleauthorities.features.users;

import co.istad.elearning_rest_api.userroleauthorities.model.Role;
import co.istad.elearning_rest_api.userroleauthorities.model.User;
import co.istad.elearning_rest_api.userroleauthorities.features.roles.RoleRepository;
import co.istad.elearning_rest_api.userroleauthorities.features.users.dto.UserRequest;
import co.istad.elearning_rest_api.userroleauthorities.features.users.dto.UserResponse;
import co.istad.elearning_rest_api.userroleauthorities.features.users.dto.UserUpdateRequest;
import co.istad.elearning_rest_api.userroleauthorities.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    // 
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        if (userRepository.existsByUsername(userRequest.username())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Username already exist ! Try another one ");
        }
        if (userRepository.existsByEmail(userRequest.email())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email already token ! Try another one ");
        }


        Set<Role> roles = new HashSet<>();
        for (var role : userRequest.roles()) {
            var roleObj = roleRepository.findByName(role)
                    .orElseThrow(
                            () -> new ResponseStatusException(
                                    HttpStatus.BAD_REQUEST,
                                    "Role: <" + role + "> could not found!"
                            )
                    );
            roles.add(roleObj);
        }

        User newUser = userMapper.requestToUser(userRequest);
        newUser.setIsVerified(false);
        newUser.setIsDeleted(false);
        newUser.setRoles(roles);
        userRepository.save(newUser);
        return userMapper.toUserResponse(newUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public UserResponse getUserById(String id) {
        var user = userRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("There is no user with id = " + id));
        return userMapper.toUserResponse(user);
    }

    @Override
    public void deleteUserById(String id) {
        var user = userRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("There is no user with id = " + id));
        userRepository.delete(user);

    }


    @Override
    public UserResponse updateUserById(String id, UserUpdateRequest userRequest) {
        var updateUser = userRepository
                .findById(id)
                .orElseThrow(
                        () -> new NoSuchElementException("There is no user with = " + id));
        userMapper.updateUserFromRequest(updateUser, userRequest);
        return userMapper.toUserResponse(userRepository.save(updateUser));
    }

    @Override
    public UserResponse disableUser(String id) {
        int affectedRow = userRepository.updateVerifiedStatusById(id, true);
        if (affectedRow > 0) {
            return userMapper.toUserResponse(
                    userRepository.findById(id)
                            .orElse(null));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User with id = " + id + " doesn't exist ! "
            );
        }

    }
    @Override
    public UserResponse enableUser(String id) {
        int affectedRow = userRepository.updateVerifiedStatusById(id, false);
        if (affectedRow > 0) {
            return userMapper.toUserResponse(
                    userRepository.findById(id)
                            .orElse(null));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User with id = " + id + " doesn't exist ! "
            );
        }
    }

}
