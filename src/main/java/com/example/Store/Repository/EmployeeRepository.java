package com.example.Store.Repository;


import com.example.Store.Modules.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
