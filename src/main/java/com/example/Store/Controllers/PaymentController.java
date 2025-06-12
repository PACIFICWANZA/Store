package com.example.Store.Controllers;

import com.example.Store.Modules.Payment;
import com.example.Store.Service.PaymentServiceI;
import jdk.jfr.Unsigned;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    public final PaymentServiceI paymentServiceI;

    @PostMapping("/makePayment")
    public ResponseEntity<String> createPayment(@RequestBody Payment payment) {
        try {
            paymentServiceI.createPayment(payment);
            return ResponseEntity.ok("Payment created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/viewPayments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        try {
            List<Payment> Madepayments = paymentServiceI.getAllPayments();
            return ResponseEntity.ok(Madepayments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/updatePayment/{customerNumber}")
    public ResponseEntity<?> updatePayment(@PathVariable Long customerNumber, @RequestBody Payment payment) {
        try {
            Payment updatedPayment = paymentServiceI.updatePayment(customerNumber, payment);
            return ResponseEntity.ok(updatedPayment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the payment.");
        }

    }

    @DeleteMapping("/deletePayment/{customerNumber}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long customerNumber) {
        try {
            paymentServiceI.deletePayment(customerNumber);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
