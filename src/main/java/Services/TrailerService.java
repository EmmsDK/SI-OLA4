package Services;

import Entities.Trailer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/trailers")
public class TrailerService {
    private Map<String, Trailer> trailers = new HashMap<>();

    public TrailerService() {
        // Sample trailers
        trailers.put("T1", new Trailer("T1", "LocA"));
        trailers.put("T2", new Trailer("T2", "LocB"));
    }

    @GetMapping("/available")
    public Map<String, Trailer> getAvailableTrailers() {
        Map<String, Trailer> availableTrailers = new HashMap<>();
        for (Map.Entry<String, Trailer> entry : trailers.entrySet()) {
            if (entry.getValue().isAvailable()) {
                availableTrailers.put(entry.getKey(), entry.getValue());
            }
        }
        return availableTrailers;
    }

    @PostMapping("/book/{trailerId}")
    public String bookTrailer(@PathVariable String trailerId) {
        Trailer trailer = trailers.get(trailerId);
        if (trailer == null || !trailer.isAvailable()) {
            return "Trailer not available!";
        }

        trailer.setAvailable(false); // Mark trailer as booked
        return "Trailer " + trailerId + " booked successfully.";
    }

    @PostMapping("/return/{trailerId}")
    public String returnTrailer(@PathVariable String trailerId) {
        Trailer trailer = trailers.get(trailerId);
        if (trailer == null) {
            return "Trailer not found!";
        }

        trailer.setAvailable(true); // Mark trailer as available
        return "Trailer " + trailerId + " returned successfully.";
    }
}
