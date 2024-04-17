package co.istad.elearning_rest_api.student.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name="students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name="username")
    private String username;

    @Column(name="highschool")
    private String highSchool;

    @Column(name="isblocked")
    private boolean isBlocked;

    @Column(name="universityuserid")
    private String universityUserId;

}
