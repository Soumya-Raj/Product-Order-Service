package com.l7.ordermanagement.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * JPA entity class for an order
 */
@Entity
@Table(name = "orderTable")
@DynamicUpdate
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20, nullable = false)
    private int orderId;

    @ManyToMany
    @JoinTable(name = "Order_Product",joinColumns = {@JoinColumn(name="fk_order")},inverseJoinColumns = {@JoinColumn(name="fk_product")})
    private List<Product> productId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @NotNull(message = "Total price of order cannot be null")
    @Column(nullable = false)
    private float totalPrice;

    protected Order() {

    }

    public Order(int orderId, @NotEmpty(message = "Products purchased cannot be empty") List<Product> productId, @NotEmpty(message = "Order date cannot be empty") Date orderDate, @NotEmpty(message = "Total price of order cannot be empty") float totalPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProductId() {
        return productId;
    }

    public void setProductId(List<Product> productId) {
        this.productId = productId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
