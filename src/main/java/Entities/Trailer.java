package Entities;

public class Trailer {
    private String trailerId;
    private String locationId;
    private boolean isAvailable;

    public Trailer(String trailerId, String locationId) {
        this.trailerId = trailerId;
        this.locationId = locationId;
        this.isAvailable = true;
    }

    // Getters and Setters
    public String getTrailerId() { return trailerId; }
    public String getLocationId() { return locationId; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}


