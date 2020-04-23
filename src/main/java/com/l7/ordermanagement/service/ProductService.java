package com.l7.ordermanagement.service;

import com.l7.ordermanagement.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * Interface for Product entity related business logic
 */
public interface ProductService {
    public List<Product> getAllProducts();

    public Optional<Product> getProductByID(int productId);

    public void deleteProductById(int productId);

    public int addProduct(Product product);

    public void updateProduct(Product product);
}
