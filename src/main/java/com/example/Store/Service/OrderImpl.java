package com.example.Store.Service;

import com.example.Store.Modules.Customer;
import com.example.Store.Modules.Order;
import com.example.Store.Repository.CustomerRepository;
import com.example.Store.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderImpl implements OrderServiceI{
    public final OrderRepository orderRepository;
    public final CustomerRepository customerRepository;

    @Override
    public Order createOrder(Order order) {
        Customer customer = customerRepository.findById(order.getCustomerNumber().getCustomerNumber())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomerNumber(customer);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    @Override
    public Order updateOrder(Long orderNumber, Order order) {
        Order existingOrder = orderRepository.findById(orderNumber)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        // Update fields (add more as needed)
        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setRequiredDate(order.getRequiredDate());
        existingOrder.setShippedDate(order.getShippedDate());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setComments(order.getComments());
        return orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long orderNumber) {
        orderRepository.deleteById(orderNumber);
    }

}
