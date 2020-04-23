package com.l7.ordermanagement.repository;

import com.l7.ordermanagement.model.Order;

import java.util.List;
import java.util.Optional;

/**
 * Interface for Order entity CRUD operation
 */
public interface OrderRepository {
    public List<Order> getAllOrders();

    public Optional<Order> getOrderById(int orderId);

    public void deleteOrderById(int orderId);

    public int createOrder(Order order);

    public void updateOrder(Order order);
}
