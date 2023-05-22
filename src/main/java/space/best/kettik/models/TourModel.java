package space.best.kettik.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "tours")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TourModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String miniTitle;
    private int price;
    @ElementCollection
    private List<String> priceInclude;
    private String bring;
    private String fullDescription;
    private int day;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String image;

    public enum Category {
        MULTIDAY("Multiday"),
        MOUNTAINS("Mountains"),
        INDIVIDUAL("Individual");

        private String displayName;

        Category(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}
