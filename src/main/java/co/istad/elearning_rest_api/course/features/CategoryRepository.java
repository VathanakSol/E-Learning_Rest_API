package co.istad.elearning_rest_api.course.features;

import co.istad.elearning_rest_api.course.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
