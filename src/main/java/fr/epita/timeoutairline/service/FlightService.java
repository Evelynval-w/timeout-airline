package fr.epita.timeoutairline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.epita.timeoutairline.model.Flight;
import fr.epita.timeoutairline.repository.FlightRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Create
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Read all
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Read one by flight number
    public Optional<Flight> getFlightByNumber(String flightNumber) {
        return flightRepository.findById(flightNumber);
    }

    // Search flights (Feature #6 from project requirements)
    public List<Flight> searchFlights(String departureCity, String arrivalCity, LocalDate departureDate) {
        return flightRepository.findByDepartureCityAndArrivalCityAndDepartureDate(
            departureCity, arrivalCity, departureDate
        );
    }

    // Update
    public Flight updateFlight(String flightNumber, Flight flightDetails) {
        Flight flight = flightRepository.findById(flightNumber)
            .orElseThrow(() -> new RuntimeException("Flight not found with number: " + flightNumber));
        
        flight.setDepartureCity(flightDetails.getDepartureCity());
        flight.setArrivalCity(flightDetails.getArrivalCity());
        flight.setDepartureHour(flightDetails.getDepartureHour());
        flight.setArrivalHour(flightDetails.getArrivalHour());
        flight.setDepartureDate(flightDetails.getDepartureDate());
        flight.setNumberOfSeat(flightDetails.getNumberOfSeat());
        flight.setFirstClassSeatPrice(flightDetails.getFirstClassSeatPrice());
        flight.setPremiumSeatPrice(flightDetails.getPremiumSeatPrice());
        flight.setBusinessClassPrice(flightDetails.getBusinessClassPrice());
        flight.setEconomicsClassPrice(flightDetails.getEconomicsClassPrice());
        flight.setPlane(flightDetails.getPlane());
        flight.setDepartureAirport(flightDetails.getDepartureAirport());
        flight.setArrivalAirport(flightDetails.getArrivalAirport());
        
        return flightRepository.save(flight);
    }

    // Delete
    public void deleteFlight(String flightNumber) {
        Flight flight = flightRepository.findById(flightNumber)
            .orElseThrow(() -> new RuntimeException("Flight not found with number: " + flightNumber));
        flightRepository.delete(flight);
    }
}
