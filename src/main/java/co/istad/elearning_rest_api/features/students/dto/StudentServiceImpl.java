package co.istad.elearning_rest_api.features.students.dto;

import co.istad.elearning_rest_api.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

    @Override
    public Student updateStudent(String username, Student student) {
        Student existingStudent = studentRepository.findByUsername(username);
        if (existingStudent != null) {
            student.setId(existingStudent.getId());
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(String username) {
        Student student = studentRepository.findByUsername(username);
        if (student != null) {
            studentRepository.delete(student);
        }
    }

    @Override
    public boolean isHighSchoolIdBlockedForUniversity(String highSchoolId) {
        // Implement the logic to check if the high school ID is blocked for university user ID
        return false;
    }
}
