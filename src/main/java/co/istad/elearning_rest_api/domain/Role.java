package co.istad.elearning_rest_api.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles_tb")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    // stuff , admin , ...
    @Column(nullable = false, length = 255)
    private String name;
}