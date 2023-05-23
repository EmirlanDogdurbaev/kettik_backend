package space.best.kettik.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.best.kettik.dto.TourRequest;
import space.best.kettik.models.TourModel;
import space.best.kettik.repos.TourRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourService {
    private final TourRepository tourRepository;
    private final CloudinaryService cloudinaryService;


    @Autowired
    public TourService(TourRepository tourRepository, CloudinaryService cloudinaryService) {
        this.tourRepository = tourRepository;
        this.cloudinaryService = cloudinaryService;
    }

    public List<TourModel> getAllTours() {
        return tourRepository.findAll();
    }

    public TourModel createTour(TourRequest tourRequest) {
        return tourRepository.save(
                TourModel.builder()
                        .title(tourRequest.title())
                        .miniTitle(tourRequest.miniTitle())
                        .price(tourRequest.price())
                        .priceInclude(tourRequest.priceInclude())
                        .bring(tourRequest.bring())
                        .fullDescription(tourRequest.fullDescription())
                        .bringCharacteristics(tourRequest.bringCharacteristics())
                        .day(tourRequest.day())
                        .category(TourModel.Category.valueOf(tourRequest.category()))
                        .image(cloudinaryService.upload(tourRequest.image()))
                        .image2(cloudinaryService.upload(tourRequest.image2()))
                        .image3(cloudinaryService.upload(tourRequest.image3()))
                        .image4(cloudinaryService.upload(tourRequest.image4()))

                        .build());
    }

    public TourModel getTourById(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tour not found with ID: " + id));
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
