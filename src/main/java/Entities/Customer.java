package Entities;

// Entities.Customer.java
public class Customer {
    private String customerId;
    private String name;
    private String contactDetails;

    public Customer(String customerId, String name, String contactDetails) {
        this.customerId = customerId;
        this.name = name;
        this.contactDetails = contactDetails;
    }

    // Getters and Setters
    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
}
