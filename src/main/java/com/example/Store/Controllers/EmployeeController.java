package com.example.Store.Controllers;

import com.example.Store.Modules.Employee;
import com.example.Store.Service.EmployeeServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    public final EmployeeServiceI employeeServiceI;

    @PostMapping("/saveEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
        try {
            employeeServiceI.createEmployee(employee);
            return ResponseEntity.ok("Employee saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @GetMapping("/viewEmployees")
    public ResponseEntity<List<Employee>> viewAllEmployees() {
        try {
            List<Employee> all = employeeServiceI.getAllEmployees();
            return ResponseEntity.ok(all);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/updateEmployee/{employeeNumber}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer employeeNumber, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeServiceI.updateEmployee(employeeNumber, employee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the employee.");
        }
    }

    @DeleteMapping("/deleteEmployee/{employeeNumber}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer employeeNumber) {
        try {
            employeeServiceI.deleteEmployee(employeeNumber);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
