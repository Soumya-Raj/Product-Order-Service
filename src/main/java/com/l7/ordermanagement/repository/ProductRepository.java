package com.l7.ordermanagement.repository;

import com.l7.ordermanagement.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * Interface for Product entity CRUD operation
 */
public interface ProductRepository {
    public List<Product> getAllProducts();

    public Optional<Product> getProductByID(int productId);

    public void deleteProductById(int productId);

    public int addProduct(Product product);

    public void updateProduct(Product product);
}
