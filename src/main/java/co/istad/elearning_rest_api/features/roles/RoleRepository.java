package co.istad.elearning_rest_api.features.roles;

import co.istad.elearning_rest_api.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends  JpaRepository<Role,String> {
    Optional<Role> findByName(String name   );
}
