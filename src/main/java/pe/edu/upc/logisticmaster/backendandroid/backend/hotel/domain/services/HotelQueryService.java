package pe.edu.upc.logisticmaster.backendandroid.backend.hotel.domain.services;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.domain.model.HotelAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.repositories.HotelRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.transform.HotelDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelQueryService {

    private final HotelRepository repo;

    public HotelQueryService(HotelRepository repo) {
        this.repo = repo;
    }

    public HotelDto findById(Long id) {
        HotelAggregate agg = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found: " + id));
        return toDto(agg);
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
        HotelDto dto = new HotelDto();
        dto.setId(agg.getId());
        dto.setName(agg.getName());
        dto.setDescription(agg.getDescription());
        dto.setFeatures(agg.getFeatures());
        dto.setIsPremium(agg.getIsPremium());
        dto.setLatitude(agg.getLatitude());
        dto.setLongitude(agg.getLongitude());
        dto.setImageUrl(agg.getImageUrl());
        dto.setCity(agg.getCity());
        dto.setCountry(agg.getCountry());
        dto.setAddress(agg.getAddress());
        dto.setPricePerNight(agg.getPricePerNight());
        dto.setRating(agg.getRating());
        return dto;
    }
}
