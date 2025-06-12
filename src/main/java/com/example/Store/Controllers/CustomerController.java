package com.example.Store.Controllers;


import com.example.Store.Modules.Customer;
import com.example.Store.Service.CustomerServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    public final CustomerServiceI customerServiceI;

    @PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        try{
            customerServiceI.createCustomer(customer);
            return ResponseEntity.ok("Customer created successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/viewCustomers")
    public ResponseEntity<List<Customer>> viewCustomers(){
        try{
            List<Customer> customers = customerServiceI.getAllCustomers();
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PutMapping("/updateCustomer/{customerNumber}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long customerNumber, @RequestBody Customer customer) {
        try {
            Customer updatedCustomer = customerServiceI.updateCustomer(customerNumber, customer);
            return ResponseEntity.ok(updatedCustomer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the customer.");
        }
    }
    @DeleteMapping("/deleteCustomer/{customerNumber}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerNumber) {
        try {
            customerServiceI.deleteCustomer(customerNumber);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
