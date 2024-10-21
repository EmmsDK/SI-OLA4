package com.MyTrailerApp.Controller;

import com.MyTrailerApp.Entities.Trailer;
import com.MyTrailerApp.Services.TrailerService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/trailers")
public class TrailerController {

    private final TrailerService trailerService;

    public TrailerController(TrailerService trailerService) {
        this.trailerService = trailerService;
    }

    @GetMapping("/available")
    public Map<String, Trailer> getAvailableTrailers() {
        return trailerService.getAvailableTrailers();
    }

    @PostMapping("/book/{trailerId}")
    public String bookTrailer(@PathVariable String trailerId) {
        return trailerService.bookTrailer(trailerId);
    }

    @PostMapping("/return/{trailerId}")
    public String returnTrailer(@PathVariable String trailerId) {
        return trailerService.returnTrailer(trailerId);
    }
}
