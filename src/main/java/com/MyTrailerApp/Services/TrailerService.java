package com.MyTrailerApp.Services;

import com.MyTrailerApp.Entities.Trailer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TrailerService {

    private Map<String, Trailer> trailers = new HashMap<>();

    public TrailerService() {
        trailers.put("T1", new Trailer("T1", "LocA"));
        trailers.put("T2", new Trailer("T2", "LocB"));
    }

    public Map<String, Trailer> getAvailableTrailers() {
        Map<String, Trailer> availableTrailers = new HashMap<>();
        for (Map.Entry<String, Trailer> entry : trailers.entrySet()) {
            if (entry.getValue().isAvailable()) {
                availableTrailers.put(entry.getKey(), entry.getValue());
            }
        }
        return availableTrailers;
    }

    public String bookTrailer(String trailerId) {
        Trailer trailer = trailers.get(trailerId);
        if (trailer == null || !trailer.isAvailable()) {
            return "Trailer not available!";
        }
        trailer.setAvailable(false);
        return "Trailer " + trailerId + " booked successfully.";
    }

    public String returnTrailer(String trailerId) {
        Trailer trailer = trailers.get(trailerId);
        if (trailer == null) {
            return "Trailer not found!";
        }
        trailer.setAvailable(true);
        return "Trailer " + trailerId + " returned successfully.";
    }
}
