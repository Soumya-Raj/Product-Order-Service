package com.l7.ordermanagement.exception;

/**
 * Custom exception if order is not found
 */
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
