package co.istad.elearning_rest_api.features.students.dto;

import co.istad.elearning_rest_api.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        if (studentService.isHighSchoolIdBlockedForUniversity(student.getHighSchoolId())) {
            return ResponseEntity.badRequest().build();
        }

        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Student> getStudentByUsername(@PathVariable String username) {
        Student student = studentService.getStudentByUsername(username);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{username}")
    public ResponseEntity<Student> updateStudent(@PathVariable String username, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(username, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String username) {
        studentService.deleteStudent(username);
        return ResponseEntity.noContent().build();
    }
}
