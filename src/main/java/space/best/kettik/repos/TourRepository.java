package space.best.kettik.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.best.kettik.models.TourModel;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<TourModel, Long> {
    List<TourModel> findAllByOrderByTitle();
    List<TourModel> findAllByOrderByPrice();
    List<TourModel> findByTitleContainingIgnoreCaseOrFullDescriptionContainingIgnoreCase(String titleKeyword, String descriptionKeyword);
    List<TourModel> findByCategory(TourModel.Category category);
}
