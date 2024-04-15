package co.istad.elearning_rest_api.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
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

    @CreationTimestamp
    @Column(name="enrolledat", updatable = false)
    private LocalDateTime enrolledAt;

    @Column(name="progress")
    private int progress;

    @Column(name="status")
    private boolean status;
    public void setEnabled(boolean status) {
        this.status = status;
    }



}
