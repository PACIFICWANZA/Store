package com.example.Store.Service;

import com.example.Store.Modules.Order;
import com.example.Store.Modules.OrderDetail;
import com.example.Store.Modules.OrderDetailId;
import com.example.Store.Modules.Product;
import com.example.Store.Repository.OrderDetailRepository;
import com.example.Store.Repository.OrderRepository;
import com.example.Store.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailImpl implements OrderDetailServiceI {
    public final OrderDetailRepository orderDetailRepository;
    public final OrderRepository orderRepository;
    public final ProductRepository productRepository;

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        Long orderNumber = orderDetail.getId().getOrderNumber();
        Long productCode = orderDetail.getId().getProductCode();
        Order order = orderRepository.findById(orderNumber)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderDetail.setOrder(order);
        Product product = productRepository.findById(productCode)
                .orElseThrow(() -> new RuntimeException("Product not found"));
         orderDetail.setProduct(product);
        return orderDetailRepository.save(orderDetail);
    }
    @Override
    public List<OrderDetail>getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetailId id, OrderDetail orderDetail) {
        OrderDetail existingOrderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order detail not found"));
        existingOrderDetail.setQuantityOrdered(orderDetail.getQuantityOrdered());
        existingOrderDetail.setPriceEach(orderDetail.getPriceEach());
        existingOrderDetail.setOrderLineNumber(orderDetail.getOrderLineNumber());
        return orderDetailRepository.save(existingOrderDetail);
    }
    @Override
    public void deleteOrderDetail(OrderDetailId id) {
        orderDetailRepository.deleteById(id);
    }

}
