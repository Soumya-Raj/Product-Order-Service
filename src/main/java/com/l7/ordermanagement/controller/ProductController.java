package com.l7.ordermanagement.controller;

import com.l7.ordermanagement.aspect.LoggerAspect;
import com.l7.ordermanagement.exception.ProductNotFoundException;
import com.l7.ordermanagement.model.Product;
import com.l7.ordermanagement.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Request handler for product entity CRUD operations
 */
@RestController
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    @LoggerAspect
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product")
    @LoggerAspect
    public Optional<Product> getProductByID(@RequestParam Integer productId) {
        Optional<Product> product = productService.getProductByID(productId);
        if (product.equals(Optional.empty())) {
            logger.info("Failed to fetch product with ID " + productId);
            throw new ProductNotFoundException("ProductID = "+ productId);
        }
        return product;
    }

    @DeleteMapping("/product")
    @LoggerAspect
    public String deleteProductById(@RequestParam int productId) {
        productService.deleteProductById(productId);
        logger.info("Product with ID " + productId + " deleted successfully");
        return "Product with ID " + productId + " deleted successfully";
    }

    @PostMapping("/product")
    @ResponseBody
    @LoggerAspect
    public ResponseEntity<Object> addProduct(@Valid @RequestBody Product product) {
        int generatedProductId = productService.addProduct(product);
        if (generatedProductId > 0) {
            logger.info("Product with ID " + generatedProductId + " added successfully");
            return new ResponseEntity("Added product is " + getProductByID(generatedProductId), HttpStatus.CREATED);
        } else {
            logger.info("Product addition failed");
            return new ResponseEntity("Product addition failed", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/productUpdate")
    @ResponseBody
    @LoggerAspect
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        logger.info("Product with ID " + product.getProductId() + " updated successfully");
        return new ResponseEntity("Product with ID " + product.getProductId() + " updated to "+getProductByID(product.getProductId()), HttpStatus.CREATED);
    }
}
