package pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.model.FavoriteHotelAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.repositories.FavoriteHotelRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.transform.FavoriteHotelDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteHotelQueryService {

    private final FavoriteHotelRepository repo;

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
        return FavoriteHotelDto.builder()
                .id(agg.getId())
                .userId(agg.getUserId())
                .hotelId(agg.getHotelId())
                .hotelName(agg.getHotelName())
                .hotelImage(agg.getHotelImage())
                .hotelLocation(agg.getHotelLocation())
                .hotelRating(agg.getHotelRating())
                .hotelPrice(agg.getHotelPrice())
                .build();
    }
}
