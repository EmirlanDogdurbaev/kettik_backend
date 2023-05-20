package space.best.kettik.servises;
import org.springframework.stereotype.Service;
import space.best.kettik.models.Booking;
import space.best.kettik.models.BookingRequest;
import space.best.kettik.repos.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(BookingRequest bookingRequest) throws Exception {
        Booking booking = new Booking();
        booking.setName(bookingRequest.getName());
        booking.setEmail(bookingRequest.getEmail());
        booking.setPhone(bookingRequest.getPhone());
        booking.setTourName(bookingRequest.getTourName());
        booking.setData(bookingRequest.getData());
        booking.setNumberOfPersons(bookingRequest.getNumberOfPersons());
        return bookingRepository.save(booking);
    }

}
