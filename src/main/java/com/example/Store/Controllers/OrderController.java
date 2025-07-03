package com.example.Store.Controllers;


import com.example.Store.Modules.Order;
import com.example.Store.Service.OrderServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    public final OrderServiceI orderServiceI;

    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
            orderServiceI.createOrder(order);
            return ResponseEntity.ok("Order created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            List<Order> allOrders = orderServiceI.getAllOrders();
            return ResponseEntity.ok(allOrders);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/updateOrder/{orderNumber}")
    public ResponseEntity<?> updateOrder(@PathVariable Long orderNumber, @RequestBody Order order) {
        try {
            Order updatedOrder = orderServiceI.updateOrder(orderNumber, order);
            return ResponseEntity.ok(updatedOrder);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the order.");
        }
    }
    @DeleteMapping("/deleteOrder/{orderNumber}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderNumber) {
        try {
            orderServiceI.deleteOrder(orderNumber);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
