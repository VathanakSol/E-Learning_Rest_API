package co.istad.elearning_rest_api.features.students.dto;

import co.istad.elearning_rest_api.domain.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentByUsername(String username);
    Student updateStudent(String username, Student student);
    void deleteStudent(String username);
    boolean isHighSchoolIdBlockedForUniversity(String highSchoolId);
}
