package com.google.product.view;

import com.google.product.model.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {

    public void viewProduct(Product product){
        System.out.println("Id: " + product.getId());
        System.out.println("Nombre: " + product.getNombre());
        System.out.println("Categoria: " + product.getCategory().getNombre());
    }

    public Product createProduct(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el Id del Producto");
        Integer id = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Ingrese el nombre del Producto");
        String nameProduct = scanner.nextLine();

        Product product = new Product(id, nameProduct);

        return product;
    }

    public Integer removeProduct(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el Id del Producto a eliminar");
        Integer id = scanner.nextInt();

        scanner.nextLine();

        return id;
    }

    public Product updateProduct(Product product){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del Producto ACTUALIZADO");
        String nameProduct = scanner.nextLine();

        product.setNombre(nameProduct);

        return product;
    }
    public Integer searchProductUpdate(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el Id del Producto que desea actualizar");
        Integer id = scanner.nextInt();

        scanner.nextLine();

        return id;
    }

    public void viewMessage(String message){
        System.out.println(message);
    }

    public void listProducts(List<Product> list){
        for (Product product: list){
            this.viewProduct(product);
        }
    }
}
