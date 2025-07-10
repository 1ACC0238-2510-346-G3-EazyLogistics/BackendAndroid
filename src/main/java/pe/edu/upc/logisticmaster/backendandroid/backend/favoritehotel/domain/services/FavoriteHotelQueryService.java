package pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.services;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.model.FavoriteHotelAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.repositories.FavoriteHotelRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.transform.FavoriteHotelDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteHotelQueryService {

    private final FavoriteHotelRepository repo;

    public FavoriteHotelQueryService(FavoriteHotelRepository repo) {
        this.repo = repo;
    }

    public FavoriteHotelDto findById(Long id) {
        FavoriteHotelAggregate agg = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FavoriteHotel not found: " + id));
        return toDto(agg);
    }

    public List<FavoriteHotelDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<FavoriteHotelDto> findByUserId(Long userId) {
        return repo.findByUserId(userId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<FavoriteHotelDto> findByHotelId(Long hotelId) {
        return repo.findByHotelId(hotelId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public boolean existsByUserAndHotel(Long userId, Long hotelId) {
        return repo.existsByUserIdAndHotelId(userId, hotelId);
    }

    private FavoriteHotelDto toDto(FavoriteHotelAggregate agg) {
        FavoriteHotelDto dto = new FavoriteHotelDto();
        dto.setId(agg.getId());
        dto.setUserId(agg.getUserId());
        dto.setHotelId(agg.getHotelId());
        dto.setHotelName(agg.getHotelName());
        dto.setHotelImage(agg.getHotelImage());
        dto.setHotelLocation(agg.getHotelLocation());
        dto.setHotelRating(agg.getHotelRating());
        dto.setHotelPrice(agg.getHotelPrice());
        return dto;
    }
}
