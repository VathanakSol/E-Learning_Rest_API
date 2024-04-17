package co.istad.elearning_rest_api.course.features;

import co.istad.elearning_rest_api.course.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByParentCategoryIdNotNull();
    Category findByAlias(String alias);
}
