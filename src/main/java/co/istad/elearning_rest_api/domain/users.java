package co.istad.elearning_rest_api.domain;

import jakarta.persistence.*;

import javax.management.relation.Role;
import java.security.Timestamp;
import java.util.List;

@Entity(name="users_tbl")
public class users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String uuid;

    private String address1;

    private String address2;

    private Timestamp dob;

    @Column(nullable = false)
    private String email;

    @Column(length = 50)
    private String familyName;

    @Column(length = 8)
    private String gender;

    @Column(length = 50)
    private String givenName;

    private Boolean isDeleted;
    private Boolean isBlocked;

    @Column(length = 30,nullable = false)
    private String nationalIdCard;

    private String password;

    @Column(length = 30,nullable = false)
    private String phoneNumber;

    private String profile;

    @Column(length = 30,nullable = false)
    private String username;

    //relationship
//    @ManyToOne
//    private City city;
//
//    @ManyToOne
//    private Country country;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<role> roles;



}
