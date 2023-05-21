package space.best.kettik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import space.best.kettik.models.TourModel;
import space.best.kettik.servises.TourService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/tours")
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

    @PostMapping
    public TourModel createTour(@RequestBody TourModel tourModel) {
        return tourService.createTour(tourModel);
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
