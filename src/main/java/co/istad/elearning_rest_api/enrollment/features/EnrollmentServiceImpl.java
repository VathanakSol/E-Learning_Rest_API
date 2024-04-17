package co.istad.elearning_rest_api.enrollment.features;

import co.istad.elearning_rest_api.enrollment.model.Enrollment;
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
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        Page<Enrollment> enrollmentPage = enrollmentRepository.findAll(pageable);
        return enrollmentPage.getContent();
    }

    //  find or show a detail of enrollment
    @Override
    public Enrollment findEnrollmentByCode(String code) {
        return enrollmentRepository.findEnrollmentByCode(code);
    }

    // update progress of enrollment
    @Override
    public Enrollment updateEnrollmentProgress(String code, int progress) {
        Enrollment enrollment = enrollmentRepository.findEnrollmentByCode(code);
        if (enrollment != null) {
            enrollment.setProgress(progress);
            return enrollmentRepository.save(enrollment);
        } else {
            throw new RuntimeException("Enrollment with code " + code + " not found");
        }
    }

    // check progress of enrollment
    @Override
    public int getEnrollmentProgress(String code) {
        Enrollment enrollment = enrollmentRepository.findEnrollmentByCode(code);
        if(enrollment != null) {
            return enrollment.getProgress();
        }
        else {
            return -1;
        }
    }

    // check for certificate for who progress 100
    @Override
    public boolean certifyEnrollment(String code) {
        Enrollment enrollment = enrollmentRepository.findEnrollmentByCode(code);
        if(enrollment != null && enrollment.getProgress() >= 100){
            enrollment.setCertified(true);
            enrollmentRepository.save(enrollment);
            return true;
        }
        return false;
    }

    // disable enrollment
    @Override
    public void disableEnrollment(String code) {
        Enrollment enrollment = enrollmentRepository.findEnrollmentByCode(code);
        if (enrollment != null) {
            enrollment.setEnabled(false); // Assuming there is an 'enabled' field in the Enrollment entity
            enrollmentRepository.save(enrollment);
        }
    }

}
