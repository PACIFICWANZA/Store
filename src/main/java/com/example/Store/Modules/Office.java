package com.example.Store.Modules;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long officeCode;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String city;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private Long phone;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String addressLine1;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String addressLine2;

    @Column(nullable = true)
    @Size(max = 50, message = "Do not exceed 50 characters")
    private String state;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String country;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String postalCode;

    @Column
    @Size(max = 50, message = "Do not exceed 50 characters")
    @NotBlank(message = "No null entries")
    private String territory;

    // Add a list of employees for bidirectional mapping if not present
    // @OneToMany(mappedBy = "officeCode", fetch = FetchType.LAZY)
    // @JsonManagedReference
    // private List<Employee> employees;

}
