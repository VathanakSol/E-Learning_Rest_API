package co.istad.elearning_rest_api.student.feature;

import co.istad.elearning_rest_api.student.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Page<Student> findAllStudents(int page, int size, String sortBy, String sortOrder);
    Student getStudentByUsername(String username);
    Student updateStudent(String username, Student student);
    void deleteStudent(String username);
    boolean isHighSchoolIdBlockedForUniversity(String highSchoolId);


}
