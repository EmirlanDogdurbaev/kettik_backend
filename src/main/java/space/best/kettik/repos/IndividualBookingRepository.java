package space.best.kettik.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import space.best.kettik.models.IndividualBooking;

public interface IndividualBookingRepository extends JpaRepository<IndividualBooking, Long> {
}
