package pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "favorite_hotel")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class FavoriteHotelAggregate {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long hotelId;

    private String hotelName;
    private String hotelImage;
    private String hotelLocation;
    private BigDecimal hotelRating;
    private BigDecimal hotelPrice;
}
