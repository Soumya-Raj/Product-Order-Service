package com.l7.ordermanagement.controller;

import com.l7.ordermanagement.aspect.LoggerAspect;
import com.l7.ordermanagement.exception.OrderNotFoundException;
import com.l7.ordermanagement.model.Order;
import com.l7.ordermanagement.service.impl.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Request handler for order entity CRUD operations
 */
@RestController
public class OrderController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    OrderServiceImpl orderService;

    @GetMapping("/orders")
    @LoggerAspect
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/order")
    @LoggerAspect
    public Optional<Order> getOrderById(@RequestParam int orderId){
        Optional<Order> order = orderService.getOrderById(orderId);
        if (order.equals(Optional.empty())) {
            logger.info("Failed to fetch order with ID " + orderId);
            throw new OrderNotFoundException("OrderID = "+ orderId);
        }
        return order;
    }

    @DeleteMapping("/order")
    @LoggerAspect
    public String deleteOrderById(@RequestParam int orderId){
        orderService.deleteOrderById(orderId);
        logger.info("Order with ID " + orderId + " deleted successfully");
        return "Order with ID " + orderId + " deleted successfully";
    }

    @PostMapping("/order")
    @ResponseBody
    @LoggerAspect
    public ResponseEntity<Object> createOrder(@RequestBody  Order order){
        int generatedOrderId=orderService.createOrder(order);
        if (generatedOrderId > 0) {
            logger.info("Order with ID " + generatedOrderId + " added successfully");
            return new ResponseEntity("Added order is " + getOrderById(generatedOrderId), HttpStatus.CREATED);
        } else {
            logger.info("Order addition failed");
            return new ResponseEntity("Order addition failed", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/orderUpdate")
    @ResponseBody
    @LoggerAspect
    public ResponseEntity<Object> updateOrder(@RequestBody Order order){
        logger.info("Order with ID " + order.getOrderId() + " updated successfully");
        return new ResponseEntity("Product with ID " + order.getOrderId() + " updated to "+getOrderById(order.getOrderId()), HttpStatus.CREATED);
    }
}
