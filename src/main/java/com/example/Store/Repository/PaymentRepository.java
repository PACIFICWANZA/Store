package com.example.Store.Repository;

import com.example.Store.Modules.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
