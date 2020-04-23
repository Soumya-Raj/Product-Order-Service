package com.l7.ordermanagement.repository.impl;

import com.l7.ordermanagement.model.Order;
import com.l7.ordermanagement.repository.OrderRepository;
import com.l7.ordermanagement.springdata.OrderSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    OrderSpringDataRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(int orderId){
        return orderRepository.findById(orderId);
    }

    public void deleteOrderById(int orderId){
        orderRepository.deleteById(orderId);
    }

    public int createOrder(Order order){
        return orderRepository.save(order).getOrderId();
    }

    public void updateOrder(Order order){
        orderRepository.save(order);
    }

}
