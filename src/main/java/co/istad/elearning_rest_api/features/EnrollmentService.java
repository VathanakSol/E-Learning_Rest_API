package co.istad.elearning_rest_api.features;

import co.istad.elearning_rest_api.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    Enrollment createEnrollment(Enrollment enrollment);
    List<Enrollment> findAllEnrollments(int page, int size, String sortBy, String sortOrder);
    Enrollment findEnrollmentByCode(String code);
    Enrollment updateEnrollmentProgress(String code, int progress);
    int getEnrollmentProgress(String code);
    boolean certifyEnrollment(String code);
    void disableEnrollment(String code);
}
