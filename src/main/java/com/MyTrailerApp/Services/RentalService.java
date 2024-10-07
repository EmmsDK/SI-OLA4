package com.MyTrailerApp.Services;

import com.MyTrailerApp.Entities.Rental;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RentalService {

    private Map<String, Rental> rentals = new HashMap<>();

    public RentalService() {
        rentals.put("R1", new Rental("R1", "T1", "C1", "2021-01-01", "2021-01-02"));
        rentals.put("R2", new Rental("R2", "T2", "C2", "2021-01-01", "2021-01-02"));
    }

    /*
        this.rentalId = rentalId;
        this.trailerId = trailerId;
        this.customerId = customerId;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
     */
    public String createRental(Rental rental) {
        rentals.put(rental.getRentalId(), rental);
        return "Rental created successfully.";
    }

    public String cancelRental(String rentalId) {
        rentals.remove(rentalId);
        return "Rental canceled successfully.";
    }

    public Rental getRental(String rentalId) {
        return rentals.get(rentalId);
    }
}
