package co.istad.elearning_rest_api.userroleauthorities.features.users;


import co.istad.elearning_rest_api.userroleauthorities.features.users.dto.UserRequest;
import co.istad.elearning_rest_api.userroleauthorities.features.users.dto.UserResponse;
import co.istad.elearning_rest_api.userroleauthorities.features.users.dto.UserUpdateRequest;
import co.istad.elearning_rest_api.userroleauthorities.utils.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor

public class UserRestController {
    private final UserService userService;

    // create new user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register new user",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = UserRequest.class),
                            examples = @ExampleObject(value = """
                                {
                                 "address1": "string",
                                 "address2": "string",
                                 "cityId": 1,
                                 "countryId": 1,
                                 "dob": "2000-01-01",
                                 "email": "example@email.com",
                                 "familyName": "Doe",
                                 "gender": "male",
                                 "givenName": "John",
                                 "roles": [
                                    "ADMIN", "STUDENT", "TEACHER"
                                 ],
                                 "nationalIdCard": "A123456789",
                                 "phoneNumber": "1234567890",
                                 "profile": "profileImage.jpg",
                                 "uuid": "UUID123456789",
                                 "verifyCode": "1234"
                                }
                                                        
                                                        
                                """)

                    )
            )
    )
    public BaseResponse<UserResponse> registerUser(@Valid @RequestBody UserRequest userRequest) {
        return BaseResponse.<UserResponse>createSuccess()
                .setPayload(userService.createUser(userRequest));
    }

    // getAllUsers
    @GetMapping
    @Operation(summary = "Get all users")
    public BaseResponse<List<UserResponse>> getAllUser() {
        return BaseResponse.<List<UserResponse>>ok()
                .setPayload(userService.getAllUsers());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get user by id")
    public BaseResponse<UserResponse> getUserById(@PathVariable String id) {
        return BaseResponse.<UserResponse>ok()
                .setPayload(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BaseResponse<?> deleteUserById(@PathVariable String id) {
        userService.deleteUserById(id);
        return BaseResponse.ok();
    }


    @PatchMapping("/{id}")
    @Operation(summary = "Update user by id")
    // configure swagger to provide the default request body for updating the user
    public BaseResponse<UserResponse> updateUserByID(
            @PathVariable() String id,@RequestBody UserUpdateRequest userRequest){
        return BaseResponse.<UserResponse>updateSuccess()
                .setPayload(userService.updateUserById(id,userRequest));
    }
    @PatchMapping("/{id}/disable")
    public BaseResponse<UserResponse> disableUser(@PathVariable() String id){
        return BaseResponse.<UserResponse>ok()
                .setPayload(userService.disableUser(id));
    }
    @PatchMapping("/{id}/enable")
    public BaseResponse<UserResponse> enableUser(@PathVariable String id){
        return BaseResponse.<UserResponse>ok()
                .setPayload(userService.enableUser(id));
    }

}

