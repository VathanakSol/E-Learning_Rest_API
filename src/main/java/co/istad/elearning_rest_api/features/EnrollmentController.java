package co.istad.elearning_rest_api.features;

import co.istad.elearning_rest_api.features.dto.EnrollmentProgressRequest;
import co.istad.elearning_rest_api.features.dto.EnrollmentProgressResponse;
import co.istad.elearning_rest_api.model.Enrollment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollments")
@Validated
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService){
        this.enrollmentService = enrollmentService;
    }

    // create new enrollment with all details
    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@Valid @RequestBody Enrollment enrollment){
        Enrollment createdEnrollment = enrollmentService.createEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEnrollment);
    }

    // find or show all details enrollments exist
    @GetMapping
    public List<Enrollment> findAllEnrollments(
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="10") int size,
            @RequestParam(defaultValue="id") String sortBy,
            @RequestParam(defaultValue="asc") String sortOrder){
       return enrollmentService.findAllEnrollments(page, size, sortBy, sortOrder);
    }

    // find or show all details enrollments by ID
    @GetMapping("/{code}")
    public ResponseEntity<Enrollment> findEnrollmentByCode(@PathVariable @NotBlank String code) {
        Enrollment enrollment = enrollmentService.findEnrollmentByCode(code);
        if (enrollment != null) {
            return ResponseEntity.ok(enrollment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // update progress of enrollment
    @PutMapping("/{code}/progress")
    public ResponseEntity<Enrollment> updateEnrollmentProgress(@PathVariable @NotBlank String code, @Valid @RequestBody EnrollmentProgressRequest enrollmentProgressRequest) {
        Enrollment updatedEnrollment = enrollmentService.updateEnrollmentProgress(code, enrollmentProgressRequest.getProgress());
        if (updatedEnrollment != null) {
            return ResponseEntity.ok(updatedEnrollment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // check progress of enrollment
    @GetMapping("/{code}/progress")
    public ResponseEntity<Integer> getEnrollmentProgress(@PathVariable @NotBlank String code) {
        int progress = enrollmentService.getEnrollmentProgress(code);
        return ResponseEntity.ok(progress);
    }

    // check for getting certification when enrollment finish 100%
    @PutMapping("/{code}/is-certified")
    public ResponseEntity<String> certifyEnrollment(@PathVariable @NotBlank String code){
        boolean certified = enrollmentService.certifyEnrollment(code);
        if(certified){
            return ResponseEntity.ok("Enrollment with code " + code + " successfully certified.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment with code " + code + " not found or progress is not 100.");
        }
    }

    // disable enrollment
    @PutMapping("/{code}/disable")
    public ResponseEntity<String> disableEnrollment(@PathVariable @NotBlank String code) {
        enrollmentService.disableEnrollment(code);
        return ResponseEntity.ok("Enrollment with code " + code + " has been disabled.");
    }
}
