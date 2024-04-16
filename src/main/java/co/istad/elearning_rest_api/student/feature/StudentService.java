package co.istad.elearning_rest_api.student.feature;

import co.istad.elearning_rest_api.student.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentByUsername(String username);
    Student updateStudent(String username, Student student);
    void deleteStudent(String username);
    boolean isHighSchoolIdBlockedForUniversity(String highSchoolId);
}
