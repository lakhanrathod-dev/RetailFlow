package com.retailflow.controller;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.retailflow.entity.Category;
import com.retailflow.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	// Add category
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	// Get all categories
	@GetMapping
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}
	// Get category by ID
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}
	// Update category
	@PutMapping("/{id}")
	public Category updateCategory(
	        @PathVariable Long id,
	        @RequestBody Category category) {

	    return categoryService.updateCategory(id, category);
	}
}