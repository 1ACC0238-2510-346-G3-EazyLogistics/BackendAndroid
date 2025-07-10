package pe.edu.upc.logisticmaster.backendandroid.backend.hotel.domain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.domain.model.HotelAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.repositories.HotelRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.transform.HotelDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelQueryService {

    private final HotelRepository repo;

    public HotelDto findById(Long id) {
        return repo.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found: " + id));
    }

    public List<HotelDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<HotelDto> findByCity(String city) {
        return repo.findByCity(city).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<HotelDto> findPremium() {
        return repo.findByIsPremiumTrue().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<HotelDto> searchByName(String namePart) {
        return repo.findByNameContainingIgnoreCase(namePart).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private HotelDto toDto(HotelAggregate agg) {
        return HotelDto.builder()
                .id(agg.getId())
                .name(agg.getName())
                .description(agg.getDescription())
                .features(agg.getFeatures())
                .isPremium(agg.getIsPremium())
                .latitude(agg.getLatitude())
                .longitude(agg.getLongitude())
                .imageUrl(agg.getImageUrl())
                .city(agg.getCity())
                .country(agg.getCountry())
                .address(agg.getAddress())
                .pricePerNight(agg.getPricePerNight())
                .rating(agg.getRating())
                .build();
    }
}
