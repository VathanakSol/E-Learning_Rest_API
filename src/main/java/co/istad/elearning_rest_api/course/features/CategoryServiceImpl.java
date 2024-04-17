package co.istad.elearning_rest_api.course.features;

import co.istad.elearning_rest_api.course.features.dto.CategoryUpdateRequest;
import co.istad.elearning_rest_api.course.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    //create a new category

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // find all categories with pagination
    @Override
    public Page<Category> findAllCategories(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> findAllCategoriesWithSubcategories() {
        return categoryRepository.findAllByParentCategoryIdNotNull();
    }

    @Override
    public Category findCategoryByAlias(String alias) {
        return categoryRepository.findByAlias(alias);
    }

    @Override
    public Category updateCategory(String alias, CategoryUpdateRequest updateRequest) {
        Category existingCategory = categoryRepository.findByAlias(alias);
        if (existingCategory != null) {
            existingCategory.setName(updateRequest.getName());
            existingCategory.setIcon(updateRequest.getIcon());
            return categoryRepository.save(existingCategory);
        } else {
            return null;
        }
    }

    @Override
    public boolean disableCategory(String alias) {
        Category category = categoryRepository.findByAlias(alias);
        if (category != null) {
            category.setEnabled(false); // Assuming there's a boolean field named 'enabled' in your Category entity
            categoryRepository.save(category);
            return true; // Category disabled successfully
        } else {
            return false; // Category with the given alias not found
        }
    }




}
