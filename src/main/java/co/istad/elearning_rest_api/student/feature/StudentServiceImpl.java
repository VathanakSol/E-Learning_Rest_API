package co.istad.elearning_rest_api.student.feature;

import co.istad.elearning_rest_api.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create a new student
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> findAllStudents(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return studentRepository.findAll(pageable);
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
