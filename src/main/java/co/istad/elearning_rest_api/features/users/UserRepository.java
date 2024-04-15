package co.istad.elearning_rest_api.features.users;

import co.istad.elearning_rest_api.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.isDeleted = :status WHERE u.id = :userId")
    int updateDeletedStatusById(String userId, boolean status);
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.isVerified = :status WHERE u.id = :userId")
    int updateVerifiedStatusById(String userId, boolean status);

}
