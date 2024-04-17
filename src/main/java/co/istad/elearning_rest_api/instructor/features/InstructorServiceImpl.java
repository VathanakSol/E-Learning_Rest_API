package co.istad.elearning_rest_api.instructor.features;

import co.istad.elearning_rest_api.instructor.model.Instructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    // create a new instructor
    @Override
    public Instructor createInstructor(Instructor instructor){
        return instructorRepository.save(instructor);
    }

    // find all instructor
    @Override
    public Page<Instructor> findAllInstructors(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return instructorRepository.findAll(pageable);
    }

    // find instructor by username
    @Override
    public Instructor getInstructorByUsername(String username) {
        return instructorRepository.findByUsername(username);
    }

    // update instructor's profile

    @Override
    public Instructor updateInstructor(String username, Instructor updateRequest) {
        Instructor existingInstructor = instructorRepository.findByUsername(username);
        if (existingInstructor != null) {
            // Apply updates from InstructorUpdateRequest to existing instructor
            existingInstructor.setBiography(updateRequest.getBiography());
            existingInstructor.setGithub(updateRequest.getGithub());
            existingInstructor.setIsBlocked(updateRequest.isBlocked());
            existingInstructor.setJobTitle(updateRequest.getJobTitle());
            existingInstructor.setLinkedIn(updateRequest.getLinkedIn());
            existingInstructor.setWebsite(updateRequest.getWebsite());
            return instructorRepository.save(existingInstructor);
        }
        return null;
    }


}
