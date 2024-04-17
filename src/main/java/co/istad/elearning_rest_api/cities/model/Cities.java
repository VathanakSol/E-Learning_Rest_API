package co.istad.elearning_rest_api.cities.model;

import co.istad.elearning_rest_api.countries.model.Countries;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_cities")
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries country;

    @Column(nullable = false, length = 60)
    private String name;
}
