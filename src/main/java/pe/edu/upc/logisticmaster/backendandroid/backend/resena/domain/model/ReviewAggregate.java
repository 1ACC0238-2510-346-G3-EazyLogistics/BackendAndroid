package pe.edu.upc.logisticmaster.backendandroid.backend.resena.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "review")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ReviewAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long hotelId;

    @Column(nullable = false)
    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Column(nullable = false)
    private LocalDateTime ratingDate;

    /** Nombre de usuario que hizo la reseña */
    @Column(length = 255, nullable = false)
    private String username;
}
