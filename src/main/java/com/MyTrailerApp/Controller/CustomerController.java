package com.MyTrailerApp.Controller;

import com.MyTrailerApp.Entities.Customer;
import com.MyTrailerApp.Services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public String createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable String customerId) {
        return customerService.getCustomer(customerId);
    }

    // New endpoint to get all customers
    @GetMapping
    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
