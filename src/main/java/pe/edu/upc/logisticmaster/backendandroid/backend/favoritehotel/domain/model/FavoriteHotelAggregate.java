package pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "favorite_hotel")
public class FavoriteHotelAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long hotelId;

    @Column(nullable = false)
    private String hotelName;

    private String hotelImage;
    private String hotelLocation;
    private BigDecimal hotelRating;
    private BigDecimal hotelPrice;

    public FavoriteHotelAggregate() {}

    // Getters & Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getHotelId() { return hotelId; }
    public void setHotelId(Long hotelId) { this.hotelId = hotelId; }

    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public String getHotelImage() { return hotelImage; }
    public void setHotelImage(String hotelImage) { this.hotelImage = hotelImage; }

    public String getHotelLocation() { return hotelLocation; }
    public void setHotelLocation(String hotelLocation) { this.hotelLocation = hotelLocation; }

    public BigDecimal getHotelRating() { return hotelRating; }
    public void setHotelRating(BigDecimal hotelRating) { this.hotelRating = hotelRating; }

    public BigDecimal getHotelPrice() { return hotelPrice; }
    public void setHotelPrice(BigDecimal hotelPrice) { this.hotelPrice = hotelPrice; }
}
