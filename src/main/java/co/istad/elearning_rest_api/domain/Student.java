package co.istad.elearning_rest_api.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name="students_tbl")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String username;

    private String highSchool;
    private boolean isBlocked;
    private String universityUserId;

//    public String  getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getHighSchool() {
//        return highSchool;
//    }
//
//    public void setHighSchool(String highSchool) {
//        this.highSchool = highSchool;
//    }


}
