package space.best.kettik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import space.best.kettik.dto.TourRequest;
import space.best.kettik.models.TourModel;
import space.best.kettik.servises.TourService;

import java.util.List;


@RestController
@RequestMapping("/tours")
@CrossOrigin(origins = "http://localhost:3000/")
public class TourController {
    private final TourService tourService;
    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }
    @GetMapping
    public List<TourModel> getAllTours() {
        return tourService.getAllTours();
    }

    @GetMapping("/{id}") // New method to get tours by ID
    public TourModel getTourById(@PathVariable("id") Long id) {
        return tourService.getTourById(id);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public TourModel createTour(@ModelAttribute TourRequest tourRequest) {
        return tourService.createTour(tourRequest);
    }

    @GetMapping("/sorted")
    public List<TourModel> getSortedTours(@RequestParam("sortBy") String sortBy) {
        return tourService.getSortedTours(sortBy);
    }

    //    http://localhost:8081/tours/sortedByCategory?category=MULTIDAY
    @GetMapping("/sortedByCategory")
    public List<TourModel> getToursSortedByCategory(@RequestParam("category") TourModel.Category category) {
        return tourService.getToursSortedByCategory(category);
    }

    //    search in all info
    @GetMapping("/search")
    public List<TourModel> searchTours(@RequestParam("keyword") String keyword) {
        return tourService.searchTours(keyword);
    }
}
