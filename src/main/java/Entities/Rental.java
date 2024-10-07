package Entities;

import java.time.LocalDateTime;

public class Rental {
    private String rentalId;
    private Trailer trailer;
    private Customer customer;
    private LocalDateTime rentalStart;
    private LocalDateTime rentalEnd;

    public Rental(String rentalId, Trailer trailer, Customer customer, LocalDateTime rentalStart, LocalDateTime rentalEnd) {
        this.rentalId = rentalId;
        this.trailer = trailer;
        this.customer = customer;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
    }

    public String getRentalId() { return rentalId; }
    public Trailer getTrailer() { return trailer; }
    public Customer getCustomer() { return customer; }
    public LocalDateTime getRentalStart() { return rentalStart; }
    public LocalDateTime getRentalEnd() { return rentalEnd; }
}
