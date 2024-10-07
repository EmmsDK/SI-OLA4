import Entities.Customer;
import Entities.Trailer;
import Services.RentalService;

import java.time.LocalDateTime;
import java.util.Map;

public class MyTrailerApp {
    public static void main(String[] args) {
        RentalService rentalService = new RentalService();

        // Create a customer
        Customer customer = new Customer("C1", "John Doe", "john@example.com");

        // Show available trailers
        Map<String, Trailer> availableTrailers = rentalService.findAvailableTrailers();
        System.out.println("Available trailers: " + availableTrailers.keySet());

        // Book a trailer
        LocalDateTime rentalStart = LocalDateTime.now();
        LocalDateTime rentalEnd = rentalStart.plusHours(3);
        String rentalId = rentalService.bookTrailer("T1", customer, rentalStart, rentalEnd);
        System.out.println(rentalId);

        // Show available trailers after booking
        availableTrailers = rentalService.findAvailableTrailers();
        System.out.println("Available trailers after booking: " + availableTrailers.keySet());

        // Return the trailer
        String returnMessage = rentalService.returnTrailer(rentalId);
        System.out.println(returnMessage);

        // Show available trailers after return
        availableTrailers = rentalService.findAvailableTrailers();
        System.out.println("Available trailers after return: " + availableTrailers.keySet());
    }
}
