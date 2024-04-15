package co.istad.elearning_rest_api.domain;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String highSchoolId;
    private String universityUserId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHighSchoolId() {
        return highSchoolId;
    }

    public void setHighSchoolId(String highSchoolId) {
        this.highSchoolId = highSchoolId;
    }

    public String getUniversityUserId() {
        return universityUserId;
    }

    public void setUniversityUserId(String universityUserId) {
        this.universityUserId = universityUserId;
    }
}
