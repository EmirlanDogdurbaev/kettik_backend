package space.best.kettik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.best.kettik.dto.IndividualBookingRequest;
import space.best.kettik.models.IndividualBooking;
import space.best.kettik.servises.IndividualBookingService;

@RestController
@RequestMapping("/indi")
@CrossOrigin(origins = "http://localhost:3000/")
public class IndividualBookingController {
    private IndividualBookingService bookingService;

    @Autowired
    public IndividualBookingController(IndividualBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/individual")
    public ResponseEntity<String> bookIndividual(@RequestBody IndividualBookingRequest request) {
        IndividualBooking booking = bookingService.createIndividualBooking(request);
        if (booking != null) {
            System.out.println("Booking saved successfully: " + booking.getId());
            return ResponseEntity.status(HttpStatus.OK).body("Booking successful");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save booking");
        }
    }
}
