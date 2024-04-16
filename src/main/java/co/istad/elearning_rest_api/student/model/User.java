package co.istad.elearning_rest_api.student.model;

import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.List;

@Entity(name="users_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(unique = true, nullable = false, name="uuid")
//    private String uuid;

    @Column(name="address1")
    private String address1;

    @Column(name="address2")
    private String address2;

    @Column(name="dob")
    private Timestamp dob;

    @Column(nullable = false, name="email")
    private String email;

    @Column(length = 50, name="familyname")
    private String familyName;

    @Column(length = 8, name="gender")
    private String gender;

    @Column(length = 50, name="givenname")
    private String givenName;

    @Column(name="isdeleted")
    private Boolean isDeleted;

    @Column(name="isblocked")
    private Boolean isBlocked;

    @Column(length = 30,nullable = false, name="nationalidcard")
    private String nationalIdCard;

    @Column(name="password")
    private String password;

    @Column(length = 30,nullable = false, name="phonenumber")
    private String phoneNumber;

    @Column(name="profile")
    private String profile;

    @Column(length = 30,nullable = false, name="username")
    private String username;

    //relationship
//    @ManyToOne
//    private City city;
//
//    @ManyToOne
//    private Country country;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;



}
