package co.istad.elearning_rest_api.citycountry.countries.model;

import co.istad.elearning_rest_api.citycountry.cities.model.Cities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "countries")
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="flag")
    private String flag;

    @Column(nullable = false, length = 10, name="iso")
    private String iso;

    @Column(nullable = false, length = 60, name="name")
    private String name;

    @Column(name="nicename")
    private String nice_name;

    @Column(nullable = false, name="numcode")
    private int num_code;

    @Column(nullable = false, name="phonecode")
    private int phone_code;


    @OneToMany(mappedBy = "country")
    private Set<Cities> cities;
}
