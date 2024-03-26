package com.google.product.controler;

import com.google.product.model.entity.Product;
import com.google.product.model.repository.ProductRepository;
import com.google.product.view.ProductView;

import java.util.List;

public class ProductController {

    private ProductView productView;
    private ProductRepository productRepository;

    public ProductController(ProductView productView, ProductRepository productRepository) {
        this.productView = productView;
        this.productRepository = productRepository;
    }

    public void createProduct(){
        //create product
        Product product = this.productView.createProduct();
        //save product
        this.productRepository.addProduct(product);
        //view product
        this.productView.viewProduct(product);
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
