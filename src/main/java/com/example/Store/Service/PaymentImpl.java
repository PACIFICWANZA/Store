package com.example.Store.Service;

import com.example.Store.Modules.Customer;
import com.example.Store.Modules.Payment;
import com.example.Store.Repository.CustomerRepository;
import com.example.Store.Repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentImpl implements PaymentServiceI{
    public final PaymentRepository paymentRepository;
    public final CustomerRepository customerRepository;

    @Override
    public Payment createPayment(Payment payment){
        Customer customer = customerRepository.findById(payment.getCustomerNumber())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        payment.setCustomer(customer);
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    @Override
    public Payment updatePayment(Long customerNumber, Payment payment) {
        Payment existingPayment = paymentRepository.findById(customerNumber)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        // Update fields (add more as needed)
        existingPayment.setCheckNumber(payment.getCheckNumber());
        existingPayment.setPaymentDate(payment.getPaymentDate());
        existingPayment.setAmount(payment.getAmount());
        return paymentRepository.save(existingPayment);
    }
    @Override
    public void deletePayment(Long customerNumber) {
        paymentRepository.deleteById(customerNumber);
    }
}
