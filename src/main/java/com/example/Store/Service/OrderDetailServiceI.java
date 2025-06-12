package com.example.Store.Service;

import com.example.Store.Modules.OrderDetail;
import com.example.Store.Modules.OrderDetailId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailServiceI {

    OrderDetail createOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> getAllOrderDetails();
    OrderDetail updateOrderDetail(OrderDetailId id, OrderDetail orderDetail);
    void deleteOrderDetail(OrderDetailId id);
}
