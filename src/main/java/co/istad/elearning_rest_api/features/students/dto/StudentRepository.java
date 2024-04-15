package co.istad.elearning_rest_api.features.students.dto;

import co.istad.elearning_rest_api.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByHighSchoolId(String highSchoolId);
    Student findByUsername(String username);

}
