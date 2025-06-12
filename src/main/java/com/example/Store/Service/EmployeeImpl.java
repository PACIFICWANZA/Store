package com.example.Store.Service;

import com.example.Store.Modules.Employee;
import com.example.Store.Modules.Office;
import com.example.Store.Repository.EmployeeRepository;
import com.example.Store.Repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeImpl implements EmployeeServiceI{

    public final EmployeeRepository employeeRepository;
    public final OfficeRepository officeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
            Office office = officeRepository.findById(employee.getOfficeCode().getOfficeCode())
                .orElseThrow(() -> new RuntimeException("Office not found"));
            employee.setOfficeCode(office);

        return employeeRepository.save(employee);
    }


    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Integer employeeNumber, Employee employee){
        Employee existingEmployee = employeeRepository.findById(employeeNumber)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        // Update fields (add more as needed)
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setExtension(employee.getExtension());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setJobTitle(employee.getJobTitle());
        // Remove manager logic
        // existingEmployee.setReportsTo(employee.getReportsTo());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Integer employeeNumber) {
        employeeRepository.deleteById(employeeNumber);
    }






}
