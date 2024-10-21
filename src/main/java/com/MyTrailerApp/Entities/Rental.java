package com.MyTrailerApp.Entities;

import java.time.LocalDateTime;

public class Rental {
    private String rentalId;
    private String trailerId;
    private String customerId;
    private String rentalStart;
    private String rentalEnd;

    public Rental(String rentalId, String trailerId, String customerId, String rentalStart, String rentalEnd) {
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
