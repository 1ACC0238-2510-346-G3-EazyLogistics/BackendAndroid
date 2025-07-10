package pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.transform;

import lombok.*;

import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class FavoriteHotelDto {
    private Long id;
    private Long userId;
    private Long hotelId;
    private String hotelName;
    private String hotelImage;
    private String hotelLocation;
    private BigDecimal hotelRating;
    private BigDecimal hotelPrice;
}
