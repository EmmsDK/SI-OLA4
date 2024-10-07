package Services;

import Entities.Customer;
import Entities.Rental;
import Entities.Trailer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RentalService {
    private Map<String, Rental> rentals = new HashMap<>();
    private Map<String, Trailer> trailers = new HashMap<>();

    public RentalService() {
        // Initialize with some trailers
        trailers.put("T1", new Trailer("T1", "LocA"));
        trailers.put("T2", new Trailer("T2", "LocB"));
    }

    // Book a trailer
    public String bookTrailer(String trailerId, Customer customer, LocalDateTime rentalStart, LocalDateTime rentalEnd) {
        Trailer trailer = trailers.get(trailerId);
        if (trailer == null || !trailer.isAvailable()) {
            return "Trailer not available!";
        }

        trailer.setAvailable(false); // Mark as unavailable
        String rentalId = "R" + (rentals.size() + 1);
        Rental rental = new Rental(rentalId, trailer, customer, rentalStart, rentalEnd);
        rentals.put(rentalId, rental);

        return "Rental ID: " + rentalId + " created successfully.";
    }

    // Return a trailer
    public String returnTrailer(String rentalId) {
        Rental rental = rentals.get(rentalId);
        if (rental == null) {
            return "Rental not found!";
        }

        Trailer trailer = rental.getTrailer();
        trailer.setAvailable(true); // Mark as available

        // Remove rental
        rentals.remove(rentalId);

        return "Trailer returned successfully.";
    }

    // Find available trailers
    public Map<String, Trailer> findAvailableTrailers() {
        Map<String, Trailer> availableTrailers = new HashMap<>();
        for (Map.Entry<String, Trailer> entry : trailers.entrySet()) {
            if (entry.getValue().isAvailable()) {
                availableTrailers.put(entry.getKey(), entry.getValue());
            }
        }
        return availableTrailers;
    }
}
