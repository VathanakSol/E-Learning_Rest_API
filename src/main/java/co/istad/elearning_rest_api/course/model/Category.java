package co.istad.elearning_rest_api.course.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="alias")
    private String alias;

    @Column(name="icon")
    private String icon;

    @Column(name="isdeleted")
    private boolean isDeleted;

    @Column(name="name")
    private String name;

    @Column(name="parentcategoryid")
    private int parentCategoryId;


    public void setEnabled(boolean b) {
    }
}