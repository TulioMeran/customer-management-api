package com.example.customer.service.impl;

import com.example.customer.exception.CustomerNoFoundException;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByName(String name) {
        return customerRepository.findByName(name)
                .orElseThrow( () -> new CustomerNoFoundException(String.format("Customer with name: %s not found",name)) );
    }

    @Override
    public boolean createNewCustomer(Customer customer) {
        var newCustomer = customerRepository.save(customer);

        return !newCustomer.getCustomerId().toString().isEmpty();
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        boolean isUpdated = false;
        customerRepository.findById(customer.getCustomerId())
                .orElseThrow(() ->
                        new CustomerNoFoundException(String.format("Customer with id: %s not found",
                                customer.getCustomerId())));
        customerRepository.save(customer);
        isUpdated = true;

        return isUpdated;
    }
}
