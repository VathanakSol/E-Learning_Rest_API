package co.istad.elearning_rest_api.instructor.features;

import co.istad.elearning_rest_api.instructor.model.Instructor;
import org.springframework.data.domain.Page;

public interface InstructorService {
    Instructor createInstructor(Instructor instructor);
    // find all instructor
    Page<Instructor> findAllInstructors(int page, int size, String sortBy, String sortOrder);

    Instructor getInstructorByUsername(String username);
    Instructor updateInstructor(String username, Instructor updateRequest);
}

