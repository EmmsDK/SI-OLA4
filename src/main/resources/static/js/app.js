// static/js/app.js




// Example: Simple client-side validation for the Shipment Acceptance form
function validateShipmentForm() {
    let ticketNumber = document.getElementById('ticket').value;
    if (ticketNumber === "") {
        alert("Ticket number is required!");
        return false;
    }
    return true;
}

// Example: Form submission for chemical movements (could be extended for AJAX)
function validateChemicalMovementForm() {
    let chemicalName = document.getElementById('chemical').value;
    let origin = document.getElementById('origin').value;
    let destination = document.getElementById('destination').value;

    if (chemicalName === "" || origin === "" || destination === "") {
        alert("All fields are required!");
        return false;
    }
    return true;
}
