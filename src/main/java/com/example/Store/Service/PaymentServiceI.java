package com.example.Store.Service;

import com.example.Store.Modules.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentServiceI {

    Payment createPayment(Payment payment);
    List<Payment> getAllPayments();
    Payment updatePayment(Long customerNumber, Payment payment);
    void deletePayment(Long customerNumber);
}
