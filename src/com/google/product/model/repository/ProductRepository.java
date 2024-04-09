package com.google.product.model.repository;

import com.google.product.model.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private List<Product> listaProducts;

    public ProductRepository() {
        this.listaProducts = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.listaProducts.add(product);
    }

    public Product searchProduct(Integer id) {
        for (Product product : this.listaProducts) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
    public Integer getProductPos(Integer id) {
        for (int i=0; i<this.listaProducts.size(); i++) {
            if (this.listaProducts.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    public Product searchProductLambda(Integer id) {
        return listaProducts.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product searchProductRemoveIf(Integer id) {
        List<Product> result = new ArrayList<>(listaProducts);
        result.removeIf(product -> !product.getId().equals(id));
        return result.isEmpty() ? null : result.get(0);
    }

    public boolean removeProduct(Integer id){
        Product search = this.searchProduct(id);
        if(search!=null){
            this.listaProducts.remove(search);
            return true;
        }
        return false;
    }

    public void updateProduct(Integer pos, Product product){
        this.listaProducts.set(pos, product);
    }

    //possicion
    public List<Product> getListaProducts() {
        return listaProducts;
    }
}
