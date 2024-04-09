package com.google.category.view;

import com.google.category.model.entity.Category;

import java.util.Scanner;

public class CategoryView {

    public Category createCategory(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el id de la categoria");
        Integer id = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Ingrese el nombre de la categoria");
        String nombre = scanner.nextLine();

        Category category = new Category(id, nombre);

        return category;
    }
    public Category createCategory(Integer id){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la categoria");
        String nombre = scanner.nextLine();

        Category category = new Category(id, nombre);

        return category;
    }

    public Integer buscarCategory(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id de la categoria del Producto");
        Integer id = scanner.nextInt();
        return id;
    }
}
