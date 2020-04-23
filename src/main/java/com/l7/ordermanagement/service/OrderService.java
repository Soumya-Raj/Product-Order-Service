package com.l7.ordermanagement.service;

import com.l7.ordermanagement.model.Order;

import java.util.List;
import java.util.Optional;

/**
 * Interface for Order entity related business logic
 */
public interface OrderService {
    public List<Order> getAllOrders();
    public Optional<Order> getOrderById(int orderId);
    public void deleteOrderById(int orderId);
    public int createOrder(Order order);
    public void updateOrder(Order order);
}
