package com.l7.ordermanagement.service.impl;

import com.l7.ordermanagement.model.Order;
import com.l7.ordermanagement.repository.OrderRepository;
import com.l7.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class defining business logic involved in CRUD operations of order entity
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }

    public Optional<Order> getOrderById(int orderId){
        return orderRepository.getOrderById(orderId);
    }

    public void deleteOrderById(int orderId){
        orderRepository.deleteOrderById(orderId);
    }

    public int createOrder(Order order){
        return orderRepository.createOrder(order);
    }

    public void updateOrder(Order order){
        orderRepository.updateOrder(order);
    }
}
