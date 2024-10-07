package com.MyTrailerApp.Services;

import com.MyTrailerApp.Entities.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService {

    private Map<String, Customer> customers = new HashMap<>();

    public String createCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
        return "Customer created successfully.";
    }

    public Customer getCustomer(String customerId) {
        return customers.get(customerId);
    }
}
