package co.istad.elearning_rest_api.course.features;

import co.istad.elearning_rest_api.course.features.dto.CategoryResponse;
import co.istad.elearning_rest_api.course.features.dto.CategoryUpdateRequest;
import co.istad.elearning_rest_api.course.model.Category;
import co.istad.elearning_rest_api.instructor.utils.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@Validated
public class CategoryRestController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    // create new category with all details
    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category){
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    // find or show all details categories exist
    @GetMapping
    public Page<Category> findAllCategories(
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="10") int size,
            @RequestParam(defaultValue="id") String sortBy,
            @RequestParam(defaultValue="asc") String sortOrder){
        return categoryService.findAllCategories(page, size, sortBy, sortOrder);
    }

    // Find all categories which have subcategories
    @GetMapping("/parents")
    public ResponseEntity<List<Category>> findAllCategoriesWithSubcategories() {
        List<Category> categoriesWithSubcategories = categoryService.findAllCategoriesWithSubcategories();
        return ResponseEntity.ok(categoriesWithSubcategories);
    }

    // Find a category by alias
    @GetMapping("/{alias}")
    public ResponseEntity<Category> findCategoryByAlias(@PathVariable String alias) {
        Category category = categoryService.findCategoryByAlias(alias);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a category's information
    @PutMapping("/{alias}")
    public ResponseEntity<Category> updateCategory(@PathVariable String alias, @RequestBody CategoryUpdateRequest updateRequest) {
        Category updatedCategory = categoryService.updateCategory(alias, updateRequest);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // disable category
    @PutMapping("/{alias}/disable")
    public ResponseEntity<String> disableCategory(@PathVariable("alias") String alias) {
        boolean result = categoryService.disableCategory(alias);
        if (result) {
            return new ResponseEntity<>("Category disabled successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to disable category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
