package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerByName(String name);
    boolean createNewCustomer(Customer customer);
    boolean updateCustomer(Customer customer);

}
