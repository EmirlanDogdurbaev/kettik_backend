package space.best.kettik.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.best.kettik.models.TourModel;
import space.best.kettik.repos.TourRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourService {
    private final TourRepository tourRepository;

    @Autowired
    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<TourModel> getAllTours() {
        return tourRepository.findAll();
    }

    public TourModel createTour(TourModel tourModel) {
        return tourRepository.save(tourModel);
    }

    public List<TourModel> getSortedTours(String sortBy) {
        switch (sortBy.toLowerCase()) {
            case "title":
                return tourRepository.findAllByOrderByTitle();
            case "price":
                return tourRepository.findAllByOrderByPrice();
            default:
                return tourRepository.findAll();
        }
    }

    public List<TourModel> getToursSortedByCategory(TourModel.Category category) {
        return tourRepository.findAll().stream()
                .filter(tour -> tour.getCategory() == category)
                .collect(Collectors.toList());
    }

    public List<TourModel> searchTours(String keyword) {
        return tourRepository.findByTitleContainingIgnoreCaseOrFullDescriptionContainingIgnoreCase(keyword, keyword);
    }
}
