package co.istad.elearning_rest_api.course.features;

import co.istad.elearning_rest_api.course.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

}
