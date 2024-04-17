package co.istad.elearning_rest_api.student.model;

import jakarta.persistence.*;

import java.util.List;
@Entity(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //relationship
    @ManyToMany(mappedBy = "roles")
    private List<User> users;


    public Object getId() {
        return id;
    }

    public Object getName() {
        return name;
    }

    public Object getAuthorities() {
        return null;
    }
}
