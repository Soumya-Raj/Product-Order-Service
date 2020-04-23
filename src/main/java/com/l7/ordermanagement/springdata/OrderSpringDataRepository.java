package com.l7.ordermanagement.springdata;

import com.l7.ordermanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSpringDataRepository extends JpaRepository<Order,Integer> {
}
