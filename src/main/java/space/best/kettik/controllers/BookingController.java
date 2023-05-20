package space.best.kettik.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.best.kettik.models.Booking;
import space.best.kettik.models.BookingRequest;
import space.best.kettik.servises.BookingService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping("/book")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest) {
        try {
            Booking booking = bookingService.createBooking(bookingRequest);
            return new ResponseEntity<>(booking, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
