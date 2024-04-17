package co.istad.elearning_rest_api.mapper;

import co.istad.elearning_rest_api.domain.Instructor;
import co.istad.elearning_rest_api.features.instructor.dto.InstructorCreateRequest;
import co.istad.elearning_rest_api.features.instructor.dto.InstructorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {Instructor.class})
public interface InstructorMapper {
    InstructorResponse toInstructorResponse(Instructor instructor);
    Instructor requestToInstructor(InstructorCreateRequest instructorCreateRequest);
}

