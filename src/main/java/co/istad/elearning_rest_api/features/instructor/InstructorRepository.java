package co.istad.elearning_rest_api.features.instructor;

import co.istad.elearning_rest_api.domain.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, String> {
}

