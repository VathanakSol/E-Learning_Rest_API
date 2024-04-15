package co.istad.elearning_rest_api.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="enrollment")
public class Enrollment {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="code")
    private String code;

    @Column(name="coursetitle")
    private String courseTitle;

    @Column(name="coursecategory")
    private String courseCategory;

    @Column(name="studentusername")
    private String studentUsername;

    @Column(name="iscertified")
    private boolean isCertified;

    @Column(name="enrolledat")
    private LocalDateTime enrolledAt;

    @Column(name="progress")
    private int progress;

    public void setEnabled(boolean b) {
    }
}
