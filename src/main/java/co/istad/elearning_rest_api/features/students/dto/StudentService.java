package co.istad.elearning_rest_api.features.students.dto;

import co.istad.elearning_rest_api.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

    public Student updateStudent(String username, Student student) {
        Student existingStudent = studentRepository.findByUsername(username);
        if (existingStudent != null) {
            student.setId(existingStudent.getId());
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudent(String username) {
        Student student = studentRepository.findByUsername(username);
        if (student != null) {
            studentRepository.delete(student);
        }
    }

    public boolean isHighSchoolIdBlockedForUniversity(String highSchoolId) {
        return studentRepository.existsByHighSchoolId(highSchoolId);
    }
}
