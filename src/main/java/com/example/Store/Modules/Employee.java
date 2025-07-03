package com.example.Store.Modules;




import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeNumber;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String lastName;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String firstName;

    @Column
    @Size(max = 20, message = "Do not exceed 20 characters")
    @NotBlank(message = "No null entries")
    private String extension;

    @Column
    @Size(max = 100, message = "Do not exceed 100 characters")
    @NotBlank(message = "No null entries")
    private String email;

    @ManyToOne
    @JoinColumn(name = "reports_to", referencedColumnName = "employeeNumber")
    @JsonIgnore
    private Employee reportsTo;


    @ManyToOne
    @JoinColumn(name = "officeCode", referencedColumnName = "officeCode", nullable = false)
    private Office officeCode;


    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String jobTitle;


    }
