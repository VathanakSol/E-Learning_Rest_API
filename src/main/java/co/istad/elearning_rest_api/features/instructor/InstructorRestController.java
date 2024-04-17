package co.istad.elearning_rest_api.features.instructor;

import co.istad.elearning_rest_api.features.instructor.dto.InstructorCreateRequest;
import co.istad.elearning_rest_api.features.instructor.dto.InstructorResponse;
import co.istad.elearning_rest_api.features.instructor.dto.InstructorUpdateRequest;
import co.istad.elearning_rest_api.utils.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/instructors")
@RequiredArgsConstructor
public class InstructorRestController {
    private final InstructorService instructorService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Register a new instructor")
    public BaseResponse<InstructorResponse> registerInstructor(
            @Validated @RequestBody InstructorCreateRequest instructorCreateRequest) {
        return BaseResponse.<InstructorResponse>createSuccess()
                .setPayload(instructorService.createInstructor(instructorCreateRequest));
    }

    @GetMapping
    @Operation(summary = "Get all instructors by pagination")
    Page<InstructorResponse> findListInstructor(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "2") int limit) {
        return instructorService.findListInstructor(page, limit);
    }

    @GetMapping("/{username}")
    @Operation(summary = "Find instructor profile by username")
    public BaseResponse<InstructorResponse> fineInstructorProfile(@PathVariable String username) {
        return BaseResponse.<InstructorResponse>ok()
                .setPayload(instructorService.fineInstructorProfile(username));
    }


    @PutMapping("/{username}")
    @Operation(summary = "Update instructor by username")
    // configure swagger to provide the default request body for updating the user
    public BaseResponse<InstructorResponse> updateInstructorProfile(
            @PathVariable() String username,@RequestBody InstructorUpdateRequest instructorUpdateRequest) {
        return BaseResponse.<InstructorResponse>updateSuccess()
                .setPayload(instructorService.updateInstructorProfile(username, instructorUpdateRequest));
    }



}
