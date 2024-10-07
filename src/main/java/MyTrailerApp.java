import Entities.Customer;
import org.joda.time.LocalDateTime;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class MyTrailerApp {

    private static final String TRAILER_SERVICE_URL = "http://localhost:8081/trailers";
    private static final String RENTAL_SERVICE_URL = "http://localhost:8082/rentals";
    private static final String CUSTOMER_SERVICE_URL = "http://localhost:8083/customers";
    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        // Step 1: Create a customer
        Customer customer = new Customer("C1", "John Doe", "john@example.com");
        String createCustomerResponse = createCustomer(customer);
        System.out.println(createCustomerResponse);

        // Step 2: Get available trailers from the Trailer Service
        Map<String, String> availableTrailers = getAvailableTrailers();
        System.out.println("Available trailers: " + availableTrailers.keySet());

        // Step 3: Book a trailer via Rental Service
        LocalDateTime rentalStart = LocalDateTime.now();
        LocalDateTime rentalEnd = rentalStart.plusHours(3);
        String trailerId = availableTrailers.keySet().iterator().next(); // Select the first available trailer
        String rentalId = bookTrailer(trailerId, customer.getCustomerId(), rentalStart, rentalEnd);
        System.out.println("Rental created: " + rentalId);

        // Step 4: Show available trailers after booking
        availableTrailers = getAvailableTrailers();
        System.out.println("Available trailers after booking: " + availableTrailers.keySet());

        // Step 5: Return the trailer via Rental Service
        String returnMessage = returnTrailer(trailerId);
        System.out.println(returnMessage);

        // Step 6: Show available trailers after return
        availableTrailers = getAvailableTrailers();
        System.out.println("Available trailers after return: " + availableTrailers.keySet());
    }

    // Method to create a customer via Customer Service
    private static String createCustomer(Customer customer) {
        ResponseEntity<String> response = restTemplate.postForEntity(CUSTOMER_SERVICE_URL + "/create", customer, String.class);
        return response.getBody();
    }

    // Method to get available trailers from Trailer Service
    private static Map<String, String> getAvailableTrailers() {
        ResponseEntity<Map> response = restTemplate.getForEntity(TRAILER_SERVICE_URL + "/available", Map.class);
        return response.getBody();
    }

    // Method to book a trailer via Rental Service
    private static String bookTrailer(String trailerId, String customerId, LocalDateTime rentalStart, LocalDateTime rentalEnd) {
        Map<String, Object> rentalRequest = new HashMap<>();
        rentalRequest.put("trailerId", trailerId);
        rentalRequest.put("customerId", customerId);
        rentalRequest.put("rentalStart", rentalStart.toString());
        rentalRequest.put("rentalEnd", rentalEnd.toString());

        ResponseEntity<String> response = restTemplate.postForEntity(RENTAL_SERVICE_URL + "/create", rentalRequest, String.class);
        return response.getBody();
    }

    // Method to return a trailer via Trailer Service
    private static String returnTrailer(String trailerId) {
        restTemplate.postForLocation(TRAILER_SERVICE_URL + "/return/" + trailerId, null);
        return "Trailer returned successfully.";
    }
}
