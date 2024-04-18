package co.istad.elearning_rest_api.features.users;


import co.istad.elearning_rest_api.features.users.dto.UserRequest;
import co.istad.elearning_rest_api.features.users.dto.UserResponse;
import co.istad.elearning_rest_api.utils.BaseResponse;
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
    public BaseResponse<UserResponse> registerUser(
            @Valid @RequestBody UserRequest userRequest) {
        return BaseResponse.<UserResponse>createSuccess()
                .setPayload(userService.createUser(userRequest));
    }

    // Assuming you have a UserService method to handle sorting and filtering
    @GetMapping
    public BaseResponse<List<UserResponse>> getAllUsers(
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String filter) {
        return BaseResponse.<List<UserResponse>>ok()
                .setPayload(userService.getAllUsers());
    }

    @GetMapping("/{username}")
    public BaseResponse<UserResponse> getUserByUsername(@PathVariable String username) {
        return BaseResponse.<UserResponse>ok()
                .setPayload(userService.getUserByUsername(username));
    }

    @PutMapping("/{username}/disable")
    public BaseResponse<UserResponse> disableUserByUsername(@PathVariable String username) {
        return BaseResponse.<UserResponse>ok()
                .setPayload(userService.disableUser(username));
    }

    @PutMapping("/{username}/enable")
    public BaseResponse<UserResponse> enableUserByUsername(@PathVariable String username) {
        return BaseResponse.<UserResponse>ok()
                .setPayload(userService.enableUser(username));
    }

    @DeleteMapping("/{username}")
    public BaseResponse<?> deleteUserByUsername(@PathVariable String username) {
        userService.deleteUserByUsername(username);
        return BaseResponse.ok();
    }
}

