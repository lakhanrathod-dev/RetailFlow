package com.retailflow.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.retailflow.entity.Category;
import com.retailflow.repository.CategoryRepository;
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    // Add category
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    // Get category by ID
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Category not found with ID: " + id));
    }
 // Update category
    public Category updateCategory(Long id, Category updatedCategory) {

        Category existingCategory = getCategoryById(id);

        existingCategory.setCategoryName(updatedCategory.getCategoryName());
        existingCategory.setDescription(updatedCategory.getDescription());

        return categoryRepository.save(existingCategory);
    }
}