package pe.edu.upc.logisticmaster.backendandroid.backend.resena.transform;

import lombok.*;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ReviewDto {
    private Long id;
    private Long hotelId;
    private Integer rating;
    private String comment;
    private LocalDateTime ratingDate;
    private String username;
}
