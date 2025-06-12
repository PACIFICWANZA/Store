package com.example.Store.Modules;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Payment {

    @Id
    @Column(name = "customer_number")
    private Long customerNumber;

    @ManyToOne
    @JoinColumn(name = "customer_number", referencedColumnName = "customer_number", insertable = false ,updatable = false)
    private Customer customer;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    private String checkNumber;

    @Column
    @NotBlank(message = "No null entries")
    private String paymentDate;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

}
