package co.istad.elearning_rest_api.course.features;

import co.istad.elearning_rest_api.course.features.dto.CategoryUpdateRequest;
import co.istad.elearning_rest_api.course.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Page<Category> findAllCategories(int page, int size, String sortBy, String sortOrder);
    public List<Category> findAllCategoriesWithSubcategories();
    public Category findCategoryByAlias(String alias);
    public Category updateCategory(String alias, CategoryUpdateRequest updateRequest);

}
