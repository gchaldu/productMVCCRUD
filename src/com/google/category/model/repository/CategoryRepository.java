package com.google.category.model.repository;

import com.google.category.model.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    private List<Category> listaCategory;

    public CategoryRepository() {
        this.listaCategory = new ArrayList<>();
    }

    public void addCategory(Category category){
        this.listaCategory.add(category);
    }
    public List<Category> getListaCategory() {
        return listaCategory;
    }

    public void setListaCategory(List<Category> listaCategory) {
        this.listaCategory = listaCategory;
    }

    public Category findCategoryById(Integer id){
        Category category;
        for (int i=0; i<this.listaCategory.size();i++) {
            category = this.listaCategory.get(i);
            if(category.getId().equals(id)){
                return category;
            }
        }

        return null;
    }
}
