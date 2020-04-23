package com.l7.ordermanagement.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * JPA entity class for product
 */
@Entity
@Table(name = "productTable")
@DynamicUpdate
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20, nullable = false)
    private int productId;

    @NotNull(message = "Product name cannot be null")
    @NotBlank(message = "Product name cannot be blank")
    @Column(length = 255, nullable = false)
    private String productName;

    @NotNull(message = "Product price cannot be null")
    @Column(nullable = false)
    private double price;

    @Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;

    protected Product(){

    }

    public Product(int productId, @NotNull(message = "Product name cannot be null") @NotEmpty(message = "Product name cannot be empty") @NotBlank(message = "Product name cannot be blank") String productName, @NotEmpty(message = "Product price cannot be empty") @NotBlank(message = "Product price cannot be blank") double price, byte[] image) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
