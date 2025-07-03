package com.example.Store.Modules;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_number")
    private Long orderNumber;

    @Column
    @NotBlank(message = "No null entries")
    private Date orderDate;

    @Column
    @NotBlank(message = "No null entries")
    private Date requiredDate;

    @Column
    @NotBlank(message = "No null entries")
    private Date shippedDate;

    @Column
    @NotBlank(message = "No null entries")
    @Size(max = 15, message = "Do not exceed 15 characters")
    private String status;

    @Column
    private String comments;

    @ManyToOne
    @JoinColumn(name = "customer_number", referencedColumnName = "customer_number")
    private Customer customerNumber;
}
