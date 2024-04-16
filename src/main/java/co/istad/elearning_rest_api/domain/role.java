package co.istad.elearning_rest_api.domain;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.util.List;
@Entity(name="roles")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //relationship
    @ManyToMany(mappedBy = "roles")
    private List<users> users;
}
