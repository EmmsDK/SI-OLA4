package com.MyTrailerApp.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @PostMapping("/charge")
    public ResponseEntity<String> processPayment(@RequestBody Map<String, String> paymentData) {
        String cardNumber = paymentData.get("cardNumber");
        String cardHolder = paymentData.get("cardHolder");

        // Basic validation logic
        if (cardNumber == null || cardNumber.length() != 16) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid card number. Must be 16 digits.");
        }

        // Simulate payment failure for a specific card number pattern
        if (cardNumber.startsWith("1234")) {
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body("Payment was declined.");
        }

        // Otherwise, simulate a successful payment
        return ResponseEntity.status(HttpStatus.OK).body("Payment successful.");
    }
}
