package pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.transform;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BookItemDto {
    private Long id;
    private Long userId;
    private Long hotelId;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private Integer adults;
    private Integer children;
    private Integer infants;
    private Integer nights;
    private Boolean isPaid;
    private LocalDateTime bookingDate;
    private String hotelName;
    private String hotelImage;
    private String location;
    private BigDecimal pricePerNight;
    private BigDecimal taxes;
    private BigDecimal totalPrice;
    private String paymentMethod;
    private String status;
}
