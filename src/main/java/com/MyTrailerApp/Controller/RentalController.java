package com.MyTrailerApp.Controller;

import com.MyTrailerApp.Entities.Rental;
import com.MyTrailerApp.Services.RentalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/create")
    public String createRental(@RequestBody Rental rental) {
        return rentalService.createRental(rental);
    }

    @DeleteMapping("/cancel/{rentalId}")
    public String cancelRental(@PathVariable String rentalId) {
        return rentalService.cancelRental(rentalId);
    }

    @GetMapping("/{rentalId}")
    public Rental getRental(@PathVariable String rentalId) {
        return rentalService.getRental(rentalId);
    }
}
