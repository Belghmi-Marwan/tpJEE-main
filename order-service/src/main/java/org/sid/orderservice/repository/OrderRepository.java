package org.sid.orderservice.repository;

import org.sid.orderservice.entites.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @RestResource(path="/byCustomerId")
    List<Order> findByCustomerId(@Param("customerId")Long customerId);
}
