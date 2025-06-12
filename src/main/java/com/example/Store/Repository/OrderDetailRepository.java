package com.example.Store.Repository;

import com.example.Store.Modules.OrderDetail;
import com.example.Store.Modules.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}
