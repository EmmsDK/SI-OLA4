package com.MyTrailerApp.Services;

import com.MyTrailerApp.Entities.Rental;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RentalService {

    private Map<String, Rental> rentals = new HashMap<>();

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
