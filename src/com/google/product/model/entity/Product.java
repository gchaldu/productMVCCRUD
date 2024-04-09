package com.google.product.model.entity;

import com.google.category.model.entity.Category;

public class Product {
    private Integer id;
    private String nombre;
    private Category category;
    public Product(Integer id, String nombre, Category category) {
        this.id = id;
        this.nombre = nombre;
        this.category = category;
    }
    public Product(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
