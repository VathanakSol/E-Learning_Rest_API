package co.istad.elearning_rest_api.instructor.mapper;

import co.istad.elearning_rest_api.instructor.model.Instructor;
import co.istad.elearning_rest_api.instructor.features.dto.InstructorCreateRequest;
import co.istad.elearning_rest_api.instructor.features.dto.InstructorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {Instructor.class})
public interface InstructorMapper {
    InstructorResponse toInstructorResponse(Instructor instructor);
    Instructor requestToInstructor(InstructorCreateRequest instructorCreateRequest);
}

