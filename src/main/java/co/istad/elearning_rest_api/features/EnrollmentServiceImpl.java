package co.istad.elearning_rest_api.features;

import co.istad.elearning_rest_api.features.dto.EnrollmentRequest;
import co.istad.elearning_rest_api.features.dto.EnrollmentResponse;
import co.istad.elearning_rest_api.model.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository){
        this.enrollmentRepository = enrollmentRepository;
    }

    // create new enrollment
    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    // find or show all enrollments exist
    @Override
    public List<Enrollment> findAllEnrollments(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc")?Sort.Direction.ASC: Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        Page<Enrollment> enrollmentPage = enrollmentRepository.findAll(pageable);
        return enrollmentPage.getContent();
    }

    @Override
    public Enrollment findEnrollmentByCode(String code) {
        return null;
    }

    @Override
    public Enrollment updateEnrollmentProgress(String code, int progress) {
        return null;
    }

    @Override
    public int getEnrollmentProgress(String code) {
        return 0;
    }

    @Override
    public boolean certifyEnrollment(String code) {
        return false;
    }

    @Override
    public void disableEnrollment(String code) {

    }

}
