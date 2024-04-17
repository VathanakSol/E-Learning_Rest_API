package co.istad.elearning_rest_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_countries")
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flag;
    private String iso;
    private String name;
    private String nice_name;
    private int num_code;
    private int phone_code;

    @OneToMany(mappedBy = "country")
    private Set<Cities> cities;
}
