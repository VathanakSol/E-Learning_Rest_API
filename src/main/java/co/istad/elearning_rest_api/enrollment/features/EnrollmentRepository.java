package co.istad.elearning_rest_api.enrollment.features;

import co.istad.elearning_rest_api.enrollment.model.Enrollment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EnrollmentRepository extends PagingAndSortingRepository<Enrollment, Long> {
    Enrollment save(Enrollment enrollment);
    Enrollment findEnrollmentByCode(String code);
}
