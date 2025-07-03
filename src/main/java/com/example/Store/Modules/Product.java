package com.example.Store.Modules;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @Size(max = 15, message = "Do not exceed 15 characters")
    @Column(name = "product_code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productCode;

    @Column
    @NotBlank(message = "Name can not be empty")
    private String productName;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_line_id", referencedColumnName = "productLine")
    private Productline productLine;



    @Column
    @NotBlank(message = "No null entries")
    @Size(max = 10, message = "Do not exceed 10 characters")
    private String productScale;

    @Column
    @NotBlank(message = "No null entries")
    @Size(max = 50, message = "Do not exceed 50 characters")
    private String productVendor;

    @Column
    @NotBlank(message = "No null entries")
    private String productDescription;

    @Column(length = 5, nullable = false)
    private int quantityInStock;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal buyPrice;

    @JsonProperty("MSRP")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal MSRP;
}
