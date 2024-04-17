package co.istad.elearning_rest_api.student.feature;

import co.istad.elearning_rest_api.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    // create a new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    // view or check all exists students
    @GetMapping
    public Page<Student> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        return studentService.findAllStudents(page, size, sortBy, sortOrder);
    }

    // check student by username
    @GetMapping("/{username}")
    public ResponseEntity<Student> getStudentByUsername(@PathVariable String username) {
        Student student = studentService.getStudentByUsername(username);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    // update student's profile
    @PutMapping("/{username}")
    public ResponseEntity<Student> updateStudent(@PathVariable String username, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(username, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        }
        return ResponseEntity.notFound().build();
    }

//    @DeleteMapping("/{username}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable String username) {
//        studentService.deleteStudent(username);
//        return ResponseEntity.noContent().build();
//    }
}
