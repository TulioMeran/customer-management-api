package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "REST APIs for Customer Management",
        description = "CRUD REST APIs to CREATE, UPDATE AND FETCH customers"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerController {

    private final ICustomerService iCustomerService;

    public CustomerController(ICustomerService customerService) {
        this.iCustomerService = customerService;
    }

    @Operation(
            summary = "Get All Customers",
            description = "REST API to fetch all Customers"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )
    @GetMapping("/get/all")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        var customers = this.iCustomerService.getAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @Operation(
            summary = "Get one Customer",
            description = "REST API to fetch one customer by name"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status NOT FOUND"
            )
    })

    @GetMapping("/get/customer")
    public ResponseEntity<Customer> getCustomerByName(@RequestParam String name){
        var customer = this.iCustomerService.getCustomerByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @Operation(
            summary = "Create Customer",
            description = "REST API to create new Customer"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL SERVER ERROR"
            )
    })
    @PostMapping("/new/customer")
    public ResponseEntity<String> postCreateCustomer(@RequestBody Customer customer){
        var isInserted = this.iCustomerService.createNewCustomer(customer);
        if (isInserted){
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer inserted!");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something wrong happen!!!");

    }

    @Operation(
            summary = "Update Customer",
            description = "REST API to update existing Customer"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status NOT FOUND"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL SERVER ERROR"
            )
    })
    @PutMapping("/update/customer")
    public ResponseEntity<String> putUpdateCustomer(@RequestBody Customer customer){
        var isUpdated = this.iCustomerService.updateCustomer(customer);
        if (isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body("Customer updated!");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something wrong happen!!!");

    }


}
