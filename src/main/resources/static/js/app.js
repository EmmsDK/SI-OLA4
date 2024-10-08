// app.js

document.addEventListener('DOMContentLoaded', () => {
    // Customer Endpoints
    document.getElementById('create-customer-btn').addEventListener('click', () => {
        const customerData = {
            customerId: document.getElementById('customerId').value,
            name: document.getElementById('name').value,
            email: document.getElementById('email').value
        };

        fetch('/customers/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(customerData)
        })
            .then(response => response.text())
            .then(data => {
                alert('Customer created: ' + data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });

    document.getElementById('get-customer-btn').addEventListener('click', () => {
        const customerId = document.getElementById('getCustomerId').value;

        fetch(`/customers/${customerId}`)
            .then(response => response.json())
            .then(customer => {
                alert(`Customer ID: ${customer.customerId}, Name: ${customer.name}, Email: ${customer.email}`);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });

    document.getElementById('get-customers-btn').addEventListener('click', () => {
        fetch('/customers')
            .then(response => response.json())
            .then(customers => {
                const customersList = document.getElementById('customers-list');
                customersList.innerHTML = '';
                customers.forEach(customer => {
                    const customerDiv = document.createElement('div');
                    customerDiv.textContent = `ID: ${customer.customerId}, Name: ${customer.name}, Email: ${customer.email}`;
                    customersList.appendChild(customerDiv);
                });
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });

    // Rental Endpoints
    document.getElementById('create-rental-btn').addEventListener('click', () => {
        const rentalData = {
            rentalId: document.getElementById('rentalId').value,
            trailerId: document.getElementById('trailerId').value,
            customerId: document.getElementById('customerIdRental').value,
            rentalStart: document.getElementById('rentalStart').value,
            rentalEnd: document.getElementById('rentalEnd').value
        };

        fetch('/rentals/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(rentalData)
        })
            .then(response => response.text())
            .then(data => {
                alert('Rental created: ' + data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });

    document.getElementById('get-rental-btn').addEventListener('click', () => {
        const rentalId = document.getElementById('getRentalId').value;

        fetch(`/rentals/${rentalId}`)
            .then(response => response.json())
            .then(rental => {
                alert(`Rental ID: ${rental.rentalId}, Trailer ID: ${rental.trailerId}, Customer ID: ${rental.customerId}`);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });

    document.getElementById('get-rentals-btn').addEventListener('click', () => {
        fetch('/rentals')
            .then(response => response.json())
            .then(rentals => {
                const rentalsList = document.getElementById('rentals-list');
                rentalsList.innerHTML = '';
                rentals.forEach(rental => {
                    const rentalDiv = document.createElement('div');
                    rentalDiv.textContent = `ID: ${rental.rentalId}, Trailer ID: ${rental.trailerId}, Customer ID: ${rental.customerId}`;
                    rentalsList.appendChild(rentalDiv);
                });
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });

    document.getElementById('cancel-rental-btn').addEventListener('click', () => {
        const rentalId = document.getElementById('cancelRentalId').value;

        fetch(`/rentals/cancel/${rentalId}`, {
            method: 'DELETE'
        })
            .then(response => response.text())
            .then(data => {
                alert('Rental cancelled: ' + data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });

    // Trailer Endpoints
    document.getElementById('get-available-trailers-btn').addEventListener('click', () => {
        fetch('/trailers/available')
            .then(response => response.json())
            .then(trailers => {
                const trailersList = document.getElementById('available-trailers-list');
                trailersList.innerHTML = '';
                for (const trailerId in trailers) {
                    const trailerDiv = document.createElement('div');
                    trailerDiv.textContent = `Trailer ID: ${trailerId}, Location ID: ${trailers[trailerId].locationId}`;
                    trailersList.appendChild(trailerDiv);
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });

    document.getElementById('book-trailer-btn').addEventListener('click', () => {
        const trailerId = document.getElementById('bookTrailerId').value;

        fetch(`/trailers/book/${trailerId}`, {
            method: 'POST'
        })
            .then(response => response.text())
            .then(data => {
                alert('Trailer booked: ' + data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });

    document.getElementById('return-trailer-btn').addEventListener('click', () => {
        const trailerId = document.getElementById('returnTrailerId').value;

        fetch(`/trailers/return/${trailerId}`, {
            method: 'POST'
        })
            .then(response => response.text())
            .then(data => {
                alert('Trailer returned: ' + data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });
});