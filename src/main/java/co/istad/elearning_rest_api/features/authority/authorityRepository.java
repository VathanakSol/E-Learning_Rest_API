package co.istad.elearning_rest_api.features.authority;

import co.istad.elearning_rest_api.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface authorityRepository extends JpaRepository<Authority,String> {
}
