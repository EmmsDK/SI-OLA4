package com.MyTrailerApp.Entities;

import java.time.LocalDateTime;

public class Rental {
    private String rentalId;
    private String trailerId;
    private String customerId;
    private LocalDateTime rentalStart;
    private LocalDateTime rentalEnd;

    public Rental(String rentalId, String trailerId, String customerId, LocalDateTime rentalStart, LocalDateTime rentalEnd) {
        this.rentalId = rentalId;
        this.trailerId = trailerId;
        this.customerId = customerId;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
    }

    public String getRentalId() { return rentalId; }
    public String getTrailerId() { return trailerId; }
    public String getCustomerId() { return customerId; }
}
