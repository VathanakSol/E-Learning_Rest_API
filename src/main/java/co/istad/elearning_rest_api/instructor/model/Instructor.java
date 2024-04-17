package co.istad.elearning_rest_api.instructor.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "instructors")
@Data
@Getter
@Setter
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="instructorid")
    private Long instructorId;

    @Column(name="userid")
    private int userId;

    @Column(name="username")
    private String username;

    @Column(name="biography")
    private String biography;

    @Column(name="github")
    private String github;

    @Column(name="isblocked")
    private boolean isBlocked;

    @Column(name="jobtitle")
    private String jobTitle;

    @Column(name="linkedin")
    private String linkedIn;

    @Column(name="website")
    private String website;

    public static void setId(int id) {

    }

    public int getId() {
        return userId;
    }

    public void setIsBlocked(boolean blocked) {
    }
}
