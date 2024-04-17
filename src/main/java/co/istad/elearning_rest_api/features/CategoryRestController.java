package co.istad.elearning_rest_api.features;

import co.istad.elearning_rest_api.model.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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




}
