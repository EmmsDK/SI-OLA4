package com.MyTrailerApp.Controller;

import com.MyTrailerApp.Entities.Rental;
import com.MyTrailerApp.Services.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rentals")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin as per your frontend URL
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRental(@RequestBody Rental rental) {
        String result = rentalService.createRental(rental);
        if (result.equals("Success")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @DeleteMapping("/cancel/{rentalId}")
    public ResponseEntity<String> cancelRental(@PathVariable String rentalId) {
        String result = rentalService.cancelRental(rentalId);
        if (result.equals("Success")) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @GetMapping("/{rentalId}")
    public ResponseEntity<Rental> getRental(@PathVariable String rentalId) {
        Rental rental = rentalService.getRental(rentalId);
        if (rental != null) {
            return ResponseEntity.status(HttpStatus.OK).body(rental);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // New endpoint to get all rentals
    @GetMapping
    public Collection<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }
}



