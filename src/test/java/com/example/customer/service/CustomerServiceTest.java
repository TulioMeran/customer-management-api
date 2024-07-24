package com.example.customer.service;


import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.impl.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    private final String NAME = "Tulio Meran";
    private final String EMAIL = "rtulio007@gmail.com";
    private final Long CUSTOMER_ID = 1L;
    @Mock private CustomerRepository customerRepository;
    private CustomerService customerService;

    @BeforeEach
    public void setUp(){
        this.customerService = new CustomerService(customerRepository);
    }

    @Test
    public void shouldCreateNewCustomer(){
        when(customerRepository.save(any())).thenReturn(new Customer(CUSTOMER_ID, NAME, EMAIL));
        assertTrue(this.customerService.createNewCustomer(new Customer()));

    }

    @Test
    public void shouldFetchOneCustomer(){
        when(customerRepository.findByName(any()))
                .thenReturn(Optional
                        .of(new Customer(CUSTOMER_ID,NAME, EMAIL)));
        var customer = customerService.getCustomerByName(NAME);

        assertEquals(customer.getName(), NAME);
    }


}
