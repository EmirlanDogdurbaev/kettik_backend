package space.best.kettik.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record TourRequest(
        String title,
        String miniTitle,
        int price,
        List<String> priceInclude,
        String bring,
        List<String> bringCharacteristics,
        String fullDescription,
        String day,
        String category,

        MultipartFile image,

        MultipartFile image2,
        MultipartFile image3,
        MultipartFile image4

) {
}
