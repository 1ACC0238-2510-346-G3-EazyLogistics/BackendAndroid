package pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "book_item")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BookItemAggregate {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // Campos desnormalizados para consulta rápida
    private String hotelName;
    private String hotelImage;
    private String location;

    private BigDecimal pricePerNight;
    private BigDecimal taxes;
    private BigDecimal totalPrice;

    private String paymentMethod;
    private String status;

    /** Calcula totalPrice = nights * pricePerNight + taxes */
    public void calculateTotal() {
        if (pricePerNight != null && nights != null && taxes != null) {
            this.totalPrice = pricePerNight.multiply(BigDecimal.valueOf(nights)).add(taxes);
        }
    }
}
