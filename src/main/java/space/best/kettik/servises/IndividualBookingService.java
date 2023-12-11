package space.best.kettik.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.best.kettik.dto.IndividualBookingRequest;
import space.best.kettik.models.IndividualBooking;
import space.best.kettik.repos.IndividualBookingRepository;

@Service
public class IndividualBookingService {
    private final IndividualBookingRepository bookingRepository;

    @Autowired
    public IndividualBookingService(IndividualBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public IndividualBooking createIndividualBooking(IndividualBookingRequest request) {
        IndividualBooking booking = new IndividualBooking();
        booking.setName(request.getName());
        booking.setEmail(request.getEmail());
        booking.setPhone(request.getPhone());
        booking.setNote(request.getNote());

        return bookingRepository.save(booking);
    }
}
