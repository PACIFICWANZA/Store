package com.example.Store.Modules;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_number")
    private Long customerNumber;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String customerName;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String customerLastName;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String customerFirstName;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private Long phone;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String addressLine1;

    @Column(nullable = true)
    @Size(max = 50, message = "Do not exceed 50 characters")
    private String addressLine2;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String city;

    @Column(nullable = true)
    @Size(max = 50, message = "Do not exceed 50 characters")
    private String state;

    @Column(nullable = true)
    @Size(max = 15, message = "Do not exceed 15 characters")
    private String postalCode;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String country;

    @ManyToOne
    @JoinColumn(name = "sales_rep_employee_number", referencedColumnName = "employeeNumber", nullable = true)
    private Employee salesRepEmployeeNumber;

    @Column(precision = 10, scale = 2, nullable = true)
    private BigDecimal creditLimit;


}
