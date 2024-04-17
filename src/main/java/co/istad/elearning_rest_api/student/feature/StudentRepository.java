package co.istad.elearning_rest_api.student.feature;

import co.istad.elearning_rest_api.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsername(String username);
}