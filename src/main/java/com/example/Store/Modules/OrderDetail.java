package com.example.Store.Modules;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @MapsId("orderNumber")
    @ManyToOne
    @JoinColumn(name = "order_number", referencedColumnName = "order_number")
    private Order order;

    @MapsId("productCode")
    @ManyToOne
    @JoinColumn(name = "product_code", referencedColumnName = "product_code")
    private Product product;

    @Column(nullable = false)
    private int quantityOrdered;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal priceEach;

    @Column( nullable = false)
    @Size(max = 6, message = "Do not exceed 6 characters")
    private int orderLineNumber;
}
