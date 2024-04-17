package co.istad.elearning_rest_api.instructor.features;

import co.istad.elearning_rest_api.instructor.features.dto.InstructorCreateRequest;
import co.istad.elearning_rest_api.instructor.features.dto.InstructorResponse;
import co.istad.elearning_rest_api.instructor.features.dto.InstructorUpdateRequest;
import co.istad.elearning_rest_api.instructor.model.Instructor;
import co.istad.elearning_rest_api.instructor.utils.BaseResponse;
import co.istad.elearning_rest_api.student.model.Student;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/instructors")
@RequiredArgsConstructor
public class InstructorRestController {
    private final InstructorService instructorService;

    // create new instructor
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor createdInstructor = instructorService.createInstructor(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInstructor);
    }

    // show or list all instructor by pagination and sort ordering
    @GetMapping
    @Operation(summary = "Get all instructors by pagination and sort")
    public Page<Instructor> getAllInstructor(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "instructorId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        return instructorService.findAllInstructors(page, size, sortBy, sortOrder);
    }

    // find instructor's profile by username
    @GetMapping("/{username}")
    @Operation(summary = "Find instructor profile by username")
    public ResponseEntity<Instructor> getInstructorByUsername(@PathVariable String username) {
        Instructor instructor = instructorService.getInstructorByUsername(username);
        if (instructor != null) {
            return ResponseEntity.ok(instructor);
        }
        return ResponseEntity.notFound().build();
    }



    @PutMapping("/{username}")
    @Operation(summary = "Update instructor by username")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable String username, @RequestBody Instructor instructor) {
        Instructor updatedInstructor = instructorService.updateInstructor(username, instructor);
        if (updatedInstructor != null) {
            return ResponseEntity.ok(updatedInstructor);
        }
        return ResponseEntity.notFound().build();
    }



}
