package co.istad.elearning_rest_api.features.instructor;

import co.istad.elearning_rest_api.features.instructor.dto.InstructorCreateRequest;
import co.istad.elearning_rest_api.features.instructor.dto.InstructorResponse;
import co.istad.elearning_rest_api.features.instructor.dto.InstructorUpdateRequest;
import org.springframework.data.domain.Page;

public interface InstructorService {
    InstructorResponse createInstructor(InstructorCreateRequest instructorCreateRequest);
    Page<InstructorResponse> findListInstructor(int page, int limit);
    InstructorResponse fineInstructorProfile(String username);
    InstructorResponse updateInstructorProfile(String username, InstructorUpdateRequest instructorUpdateRequest);
}

