package space.best.kettik.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.best.kettik.models.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
