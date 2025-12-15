package fr.epita.timeoutairline.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @ManyToOne
    @JoinColumn(name = "flight_number")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Enumerated(EnumType.STRING)
    private SeatType typeOfSeat;

    private LocalDateTime bookingDate;

    // Enum for seat types
    public enum SeatType {
        FIRST_CLASS,
        PREMIUM,
        BUSINESS,
        ECONOMICS
    }

    // Default constructor
    public Booking() {
        this.bookingDate = LocalDateTime.now();
    }

    // Constructor with fields
    public Booking(Flight flight, Client client, SeatType typeOfSeat) {
        this.flight = flight;
        this.client = client;
        this.typeOfSeat = typeOfSeat;
        this.bookingDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public SeatType getTypeOfSeat() {
        return typeOfSeat;
    }

    public void setTypeOfSeat(SeatType typeOfSeat) {
        this.typeOfSeat = typeOfSeat;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
}