package co.istad.elearning_rest_api.domain;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "roles_tb")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Use Long instead of long for nullable IDs

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "role_authority",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities;

    // Constructors, getters, and setters
    public Role() {}

    public Role(String name, Set<Authority> authorities) {
        this.name = name;
        this.authorities = authorities;
    }
}
