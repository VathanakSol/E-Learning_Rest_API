package co.istad.elearning_rest_api.features;

import co.istad.elearning_rest_api.features.dto.EnrollmentResponse;
import co.istad.elearning_rest_api.model.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/{code}/progress/{progress}")
    public Enrollment updateEnrollmentProgress(@PathVariable String code, @PathVariable int progress){
        return enrollmentService.updateEnrollmentProgress(code, progress);
    }
}
