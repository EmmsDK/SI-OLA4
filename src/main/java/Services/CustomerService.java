package Services;

import Entities.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerService {
    private Map<String, Customer> customers = new HashMap<>();

    @PostMapping("/create")
    public String createCustomer(@RequestBody Customer customer) {
        customers.put(customer.getCustomerId(), customer);
        return "Customer created successfully.";
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable String customerId) {
        return customers.get(customerId);
    }
}
