package com.example.Store.Repository;

import com.example.Store.Modules.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
