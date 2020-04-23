package com.l7.ordermanagement.springdata;

import com.l7.ordermanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpringDataRepository extends JpaRepository<Product,Integer> {
}
