package pe.edu.upc.logisticmaster.backendandroid.backend.hotel.transform;

import lombok.*;

import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class HotelDto {
    private Long id;
    private String name;
    private String description;
    private String features;
    private Boolean isPremium;
    private Double latitude;
    private Double longitude;
    private String imageUrl;
    private String city;
    private String country;
    private String address;
    private BigDecimal pricePerNight;
    private BigDecimal rating;
}
