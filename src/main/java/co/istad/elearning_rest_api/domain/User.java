package co.istad.elearning_rest_api.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id; // Changed from String to Long
    @Column(unique = true,nullable = false)
    private String address1;
    private String address2;
    private int cityId;
    private int countryId;
    private String dob;
    private String email;
    private String family_name;
    private String gender;
    private String givenName;
    @ManyToMany
    private Set<Role> roles;
    private Boolean isDeleted;
    private Boolean isVerified;
    private char nationalIdCard;
    private char phone_number;
    private char profile;
    private String username;
    private char uuid;
    private char verifyCode;
}
