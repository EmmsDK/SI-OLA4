package Services;

import Entities.Rental;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rentals")
public class RentalService {
    private Map<String, Rental> rentals = new HashMap<>();

    @PostMapping("/create")
    public String createRental(@RequestBody Rental rental) {
        if (rentals.containsKey(rental.getRentalId())) {
            return "Rental already exists!";
        }

        // Assuming interaction with TrailerService to book a trailer
        // REST call to Trailer Service to book trailer
        // HttpResponse<String> response = Unirest.post("http://trailer-service/trailers/book/" + rental.getTrailerId()).asString();

        rentals.put(rental.getRentalId(), rental);
        return "Rental created successfully.";
    }

    @DeleteMapping("/cancel/{rentalId}")
    public String cancelRental(@PathVariable String rentalId) {
        if (!rentals.containsKey(rentalId)) {
            return "Rental not found!";
        }

        // Interaction with TrailerService to mark the trailer as available
        // REST call to Trailer Service to return trailer
        rentals.remove(rentalId);
        return "Rental cancelled and trailer returned.";
    }

    @GetMapping("/{rentalId}")
    public Rental getRental(@PathVariable String rentalId) {
        return rentals.get(rentalId);
    }
}
