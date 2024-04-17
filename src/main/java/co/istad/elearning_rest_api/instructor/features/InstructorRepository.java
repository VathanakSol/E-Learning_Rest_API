package co.istad.elearning_rest_api.instructor.features;

import co.istad.elearning_rest_api.instructor.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Instructor findByUsername(String username);
}

