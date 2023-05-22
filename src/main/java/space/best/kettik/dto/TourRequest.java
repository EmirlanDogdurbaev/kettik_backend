package space.best.kettik.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record TourRequest(
     String title,
     String miniTitle,
     int price,
     List<String> priceInclude,
     String bring,
     String fullDescription,
     int day,
     String category,
     MultipartFile image
) {
}
