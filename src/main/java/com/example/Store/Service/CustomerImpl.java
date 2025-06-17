package com.example.Store.Service;

import com.example.Store.Modules.Customer;
import com.example.Store.Modules.Employee;
import com.example.Store.Repository.CustomerRepository;
import com.example.Store.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerImpl implements CustomerServiceI {

    public final CustomerRepository customerRepository;
    public final EmployeeRepository employeeRepository;

    @Override
    public Customer createCustomer(Customer customer){
        Employee employee = employeeRepository.findById(customer.getSalesRepEmployeeNumber().getEmployeeNumber())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        customer.setSalesRepEmployeeNumber(employee);
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long customerNumber, Customer customer){
        Customer existingCustomer = customerRepository.findById(customerNumber)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        // Update fields (add more as needed)
        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setCustomerLastName(customer.getCustomerLastName());
        existingCustomer.setCustomerFirstName(customer.getCustomerFirstName());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setAddressLine1(customer.getAddressLine1());
        existingCustomer.setAddressLine2(customer.getAddressLine2());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setState(customer.getState());
        existingCustomer.setPostalCode(customer.getPostalCode());
        existingCustomer.setCountry(customer.getCountry());
        existingCustomer.setCreditLimit(customer.getCreditLimit());
        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(Long customerNumber) {
        customerRepository.deleteById(customerNumber);
    }

    @Override
    public long countCustomers() {
        return customerRepository.count();
    }
}
