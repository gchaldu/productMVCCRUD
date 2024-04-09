package com.google.category.controller;

import com.google.category.model.entity.Category;
import com.google.category.model.repository.CategoryRepository;
import com.google.category.view.CategoryView;

public class CategoryController {

    CategoryView categoryView;
    CategoryRepository categoryRepository;

    public CategoryController(CategoryView categoryView, CategoryRepository categoryRepository) {
        this.categoryView = categoryView;
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(){
        Category category = this.categoryView.createCategory();
        this.categoryRepository.addCategory(category);
    }

    public CategoryView getCategoryView() {
        return categoryView;
    }

    public void setCategoryView(CategoryView categoryView) {
        this.categoryView = categoryView;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
