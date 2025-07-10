package pe.edu.upc.logisticmaster.backendandroid.backend.hotel.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "hotel")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class HotelAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
    private String features;

    @Column(nullable = false)
    private Boolean isPremium;

    private Double latitude;
    private Double longitude;

    private String imageUrl;
    private String city;
    private String country;
    private String address;

    @Column(precision = 10, scale = 2)
    private BigDecimal pricePerNight;

    @Column(precision = 3, scale = 1)
    private BigDecimal rating;
}
