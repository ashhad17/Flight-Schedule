package com.day10.Airport_management.controller;




import com.day10.Airport_management.entity.Flight;
import com.day10.Airport_management.service.FlightService;
//package com.airport.flightschedule.controller;
//
//import com.airport.flightschedule.entity.Flight;
//import com.airport.flightschedule.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {

        List<Flight> flights = flightService.getFlights(source, destination, departureDate);
        return ResponseEntity.ok(flights);
    }
}
