package com.example.Store.Controllers;

import com.example.Store.Modules.OrderDetail;
import com.example.Store.Modules.OrderDetailId;
import com.example.Store.Service.OrderDetailServiceI;
import com.example.Store.Service.OrderServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderDetails")
@RequiredArgsConstructor
public class OrderDetailController {
    public final OrderDetailServiceI orderDetailServiceI;

    @PostMapping("/createOrderDetail")
    public ResponseEntity<String> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        try{
            orderDetailServiceI.createOrderDetail(orderDetail);
            return ResponseEntity.ok("Order detail added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( e.getMessage());
        }
    }

    @GetMapping("/viewOrderDetails")
    public ResponseEntity<List<OrderDetail>> getOrderDetails() {
        try{
            List<OrderDetail> orderDetails = orderDetailServiceI.getAllOrderDetails();
            return ResponseEntity.ok(orderDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PutMapping("/updateOrderDetail/{orderNumber}/{productCode}")
    public ResponseEntity<?> updateOrderDetail(@PathVariable Long orderNumber, @PathVariable Long productCode, @RequestBody OrderDetail orderDetail) {
        try {
            OrderDetailId id = new OrderDetailId(orderNumber, productCode);
            OrderDetail updatedOrderDetail = orderDetailServiceI.updateOrderDetail(id, orderDetail);
            return ResponseEntity.ok(updatedOrderDetail);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the order detail.");
        }
    }
    @DeleteMapping("/deleteOrderDetail/{orderNumber}/{productCode}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable Long orderNumber, @PathVariable Long productCode) {
        try {
            OrderDetailId id = new OrderDetailId(orderNumber, productCode);
            orderDetailServiceI.deleteOrderDetail(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the order detail.");
        }
    }
}
