package co.istad.elearning_rest_api.countries.model;

import co.istad.elearning_rest_api.cities.model.Cities;
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
    private int id;

    private String flag;

    @Column(nullable = false, length = 10)
    private String iso;

    @Column(nullable = false, length = 60)
    private String name;

    private String nice_name;

    @Column(nullable = false)
    private int num_code;

    @Column(nullable = false)
    private int phone_code;


    @OneToMany(mappedBy = "country")
    private Set<Cities> cities;
}
