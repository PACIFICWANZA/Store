package com.example.Store.Modules;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Productline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productLine;

    @Column(nullable = true)
    @Size(max = 4000, message = "Do not exceed limit")
    private String textDescription;

    @Column
    private String htmlDescription;

    @Column
    private byte[] image;


}
