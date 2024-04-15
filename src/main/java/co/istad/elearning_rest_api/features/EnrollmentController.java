package co.istad.elearning_rest_api.features;

import co.istad.elearning_rest_api.features.dto.EnrollmentResponse;
import co.istad.elearning_rest_api.model.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService){
        this.enrollmentService = enrollmentService;
    }

    // create new enrollment with all details
    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.createEnrollment(enrollment);
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
    public Enrollment findEnrollmentByCode(@PathVariable String code){
        return enrollmentService.findEnrollmentByCode(code);
    }

    //
    @PutMapping("/{code}/progress/{progress}")
    public Enrollment updateEnrollmentProgress(@PathVariable String code, @PathVariable int progress){
        return enrollmentService.updateEnrollmentProgress(code, progress);
    }

    //
    @GetMapping("{code}/progress")
    public int getEnrollmentProgress(@PathVariable String code){
        return enrollmentService.getEnrollmentProgress(code);
    }

    //
    @PutMapping("/{code}/is-certified")
//    public boolean certifyEnrollment(@PathVariable String code){
//        return enrollmentService.certifyEnrollment(code);
//    }
    public ResponseEntity<String> certifyEnrollment(@PathVariable String code){
        boolean certified = enrollmentService.certifyEnrollment(code);
        if(certified){
            return ResponseEntity.ok("Enrollment with code " + code + " successfully certified.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment with code " + code + " not found or progress is not 100.");
        }
    }

    //
    @PutMapping("/{code}")
    public ResponseEntity<String> disableEnrollment(@PathVariable String code) {
        enrollmentService.disableEnrollment(code);
        return ResponseEntity.ok("Enrollment with code " + code + " has been disabled.");
    }
}
