package co.istad.elearning_rest_api.userroleauthorities.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(unique = true,nullable = false, name="address1")
    private String address1;

    @Column(name="address2")
    private String address2;

    @Column(name="cityid")
    private int cityId;

    @Column(name="countryid")
    private int countryId;

    @Column(name="dob")
    private String dob;

    @Column(name="email")
    private String email;

    @Column(name="familyname")
    private String familyName;

    @Column(name="gender")
    private String gender;

    @Column(name="givenname")
    private String givenName;

    @ManyToMany
    Set<Role> roles;
    @Column()
    private Boolean isDeleted;
    private Boolean isVerified;
    private char nationalIdCard;
    private char phone_number;
    private char profile;
    private String username;
    private char uuid;
    private char verifyCode;
}
