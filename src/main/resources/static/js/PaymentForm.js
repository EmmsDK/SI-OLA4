import React, { useState } from 'react';

const PaymentForm = ({ onPaymentSuccess }) => {
    const [cardNumber, setCardNumber] = useState('');
    const [cardHolder, setCardHolder] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [isProcessing, setIsProcessing] = useState(false);

    const handleSubmit = async (event) => {
        event.preventDefault();
        setIsProcessing(true);  // Disable the button during processing

        // Simple validation (checks if card number is 16 digits)
        if (cardNumber.length !== 16) {
            setErrorMessage('Invalid card number. Must be 16 digits.');
            setIsProcessing(false);
            return;
        }

        // Simulating API call to the backend
        try {
            const response = await fetch('http://localhost:8080/api/payments/charge', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    cardNumber: cardNumber,
                    cardHolder: cardHolder,
                }),
            });

            if (response.ok) {
                const result = await response.text();  // Assuming the backend returns a string message
                console.log('Payment Result:', result);
                onPaymentSuccess();  // You can navigate the user or display a success message
            } else {
                const error = await response.text();
                setErrorMessage(`Payment failed: ${error}`);
            }
        } catch (error) {
            setErrorMessage('An error occurred. Please try again.');
        } finally {
            setIsProcessing(false);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Card Number:</label>
                <input
                    type="text"
                    value={cardNumber}
                    onChange={(e) => setCardNumber(e.target.value)}
                    placeholder="Enter 16-digit card number"
                    required
                />
            </div>
            <div>
                <label>Card Holder Name:</label>
                <input
                    type="text"
                    value={cardHolder}
                    onChange={(e) => setCardHolder(e.target.value)}
                    placeholder="Enter card holder name"
                    required
                />
            </div>
            <button type="submit" disabled={isProcessing}>
                {isProcessing ? 'Processing...' : 'Pay'}
            </button>
            {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
        </form>
    );
};

export default PaymentForm;
