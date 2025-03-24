package com.day10.Airport_management.service;


import com.day10.Airport_management.entity.Flight;
import com.day10.Airport_management.repository.FlightRepository;
//package com.airport.flightschedule.service;
//
//import com.airport.flightschedule.entity.Flight;
//import com.airport.flightschedule.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getFlights(String source, String destination, LocalDate departureDate) {
        LocalDateTime startOfDay = departureDate.atStartOfDay(); // 2025-11-17T00:00:00
        LocalDateTime endOfDay = departureDate.atTime(LocalTime.MAX); // 2025-11-17T23:59:59

        return flightRepository.findBySourceAndDestinationAndDepartureDateTimeBetween(
                source, destination, startOfDay, endOfDay);
    }
}

