package co.istad.elearning_rest_api.features;

import co.istad.elearning_rest_api.model.Enrollment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EnrollmentRepository extends PagingAndSortingRepository<Enrollment, Long> {
    Enrollment save(Enrollment enrollment);
    Enrollment findEnrollmentByCode(String code);
}
