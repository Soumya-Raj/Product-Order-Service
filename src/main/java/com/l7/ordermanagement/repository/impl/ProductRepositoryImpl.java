package com.l7.ordermanagement.repository.impl;

import com.l7.ordermanagement.model.Product;
import com.l7.ordermanagement.repository.ProductRepository;
import com.l7.ordermanagement.springdata.ProductSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
Acts as the CRUD operation layer for Product Entity
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    ProductSpringDataRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductByID(int productId){
        return productRepository.findById(productId);
    }

    public void deleteProductById(int productId){
        productRepository.deleteById(productId);
    }

    public int addProduct(Product product){
        return productRepository.save(product).getProductId();
    }

    public void updateProduct(Product product){
        productRepository.save(product);
    }


}
