package com.MyTrailerApp.Services;

import com.MyTrailerApp.Entities.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService {

    private Map<String, Customer> customers = new HashMap<>();

    public CustomerService() {
        customers.put("C1", new Customer("C1", "john Doe", "john.doe“@example.com"));
        customers.put("C2", new Customer("C2", "Bob Snyder", "bob.Snyder@example.com"));
    }

    public String createCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
        return "Customer created successfully.";
    }

    public Customer getCustomer(String customerId) {
        return customers.get(customerId);
    }
}
