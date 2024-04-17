package co.istad.elearning_rest_api.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "instructor_tbl")
@Data
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private String instructor_id;
    private int user_id;
    private String biography;
    private String github;
    private boolean is_blocked;
    private String job_title;
    private String linked_in;
    private String website;


}
