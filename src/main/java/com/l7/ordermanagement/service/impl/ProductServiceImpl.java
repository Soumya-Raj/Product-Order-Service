package com.l7.ordermanagement.service.impl;

import com.l7.ordermanagement.model.Product;
import com.l7.ordermanagement.repository.ProductRepository;
import com.l7.ordermanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class defining business logic involved in CRUD operations of product entity
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public Optional<Product> getProductByID(int productId){
        return productRepository.getProductByID(productId);
    }

    public void deleteProductById(int productId){
        productRepository.deleteProductById(productId);
    }

    public int addProduct(Product product){
        Product productAdded = null;
        product.setProductName(product.getProductName().toString().trim());
        int addedProductId = productRepository.addProduct(product);
        return addedProductId;
    }

    public void updateProduct(Product product){
        product.setProductName(product.getProductName().toString().trim());
        productRepository.updateProduct(product);
    }
}
