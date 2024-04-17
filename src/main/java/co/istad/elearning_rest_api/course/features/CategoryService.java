package co.istad.elearning_rest_api.course.features;

import co.istad.elearning_rest_api.course.model.Category;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Category createCategory(Category category);
    Page<Category> findAllCategories(int page, int size, String sortBy, String sortOrder);


}
