package com.google.product.controller;

import com.google.category.model.entity.Category;
import com.google.category.model.repository.CategoryRepository;
import com.google.category.view.CategoryView;
import com.google.product.model.entity.Product;
import com.google.product.model.repository.ProductRepository;
import com.google.product.view.ProductView;

import java.util.List;

public class ProductController {

    private ProductView productView;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private CategoryView categoryView;

    public ProductController(ProductView productView, ProductRepository productRepository,
                             CategoryView categoryView, CategoryRepository categoryRepository) {
        this.productView = productView;
        this.productRepository = productRepository;
        this.categoryView = categoryView;
        this.categoryRepository = categoryRepository;
    }

    public void agregarProducto() {
        // Verificar si la categoría ya existe
        Integer id = categoryView.buscarCategory();
        Category categoriaExistente = categoryRepository.findCategoryById(id);
        Product productNew;

        if (categoriaExistente != null) {
            // Si la categoría existe, asignarla al producto
            productNew = productView.createProduct();
            productRepository.addProduct(productNew);
            productNew.setCategory(categoriaExistente);
        } else {
            // Si la categoría no existe, crearla y asignarla al producto
            System.out.println("Categoria no existe");
            Category nuevaCategoria = categoryView.createCategory(id);
            categoryRepository.addCategory(nuevaCategoria);

            productNew = productView.createProduct();
            productRepository.addProduct(productNew);
            productNew.setCategory(nuevaCategoria);
        }
    }

    public void removeProduct(){
        //buscar
        Integer id = this.productView.removeProduct();
        //eliminar
        this.productRepository.removeProduct(id);
    }

    public void updateProduct(){
        //buscar
        Integer id = this.productView.searchProductUpdate();
        Product result =this.productRepository.searchProduct(id);
        Integer pos = this.productRepository.getProductPos(id);

        if(result!=null){
            Product productActualizado = this.productView.updateProduct(result);
            this.productRepository.updateProduct(pos, productActualizado);
            this.productView.viewMessage("El producto se actualizo");
        }else{
            this.productView.viewMessage("El producto no existe");
        }
    }

    public void listProducts(){
        List<Product> lista = this.productRepository.getListaProducts();
        this.productView.listProducts(lista);
    }
}
