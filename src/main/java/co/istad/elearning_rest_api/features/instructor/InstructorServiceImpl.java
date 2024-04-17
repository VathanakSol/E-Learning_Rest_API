package co.istad.elearning_rest_api.features.instructor;


import co.istad.elearning_rest_api.features.instructor.dto.InstructorCreateRequest;
import co.istad.elearning_rest_api.features.instructor.dto.InstructorResponse;
import co.istad.elearning_rest_api.features.instructor.dto.InstructorUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    @Override
    public InstructorResponse createInstructor(InstructorCreateRequest instructorCreateRequest) {
//        instructorRepository.save(instructorUpdateRequest);
        return null;
    }

    @Override
    public Page<InstructorResponse> findListInstructor(int page, int limit) {
        return null;
    }

    @Override
    public InstructorResponse fineInstructorProfile(String instructorId) {
        return null;
    }

    @Override
    public InstructorResponse updateInstructorProfile(String username, InstructorUpdateRequest instructorUpdateRequest) {
        return null;
    }

}
