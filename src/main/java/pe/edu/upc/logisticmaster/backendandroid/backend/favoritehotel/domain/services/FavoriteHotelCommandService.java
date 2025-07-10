package pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.model.FavoriteHotelAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.repositories.FavoriteHotelRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.transform.FavoriteHotelDto;

@Service
@RequiredArgsConstructor
public class FavoriteHotelCommandService {

    private final FavoriteHotelRepository repo;

    @Transactional
    public FavoriteHotelDto create(FavoriteHotelDto dto) {
        FavoriteHotelAggregate agg = FavoriteHotelAggregate.builder()
                .userId(dto.getUserId())
                .hotelId(dto.getHotelId())
                .hotelName(dto.getHotelName())
                .hotelImage(dto.getHotelImage())
                .hotelLocation(dto.getHotelLocation())
                .hotelRating(dto.getHotelRating())
                .hotelPrice(dto.getHotelPrice())
                .build();
        agg = repo.save(agg);
        dto.setId(agg.getId());
        return dto;
    }

    @Transactional
    public FavoriteHotelDto update(Long id, FavoriteHotelDto dto) {
        FavoriteHotelAggregate agg = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FavoriteHotel not found: " + id));
        agg.setHotelName(dto.getHotelName());
        agg.setHotelImage(dto.getHotelImage());
        agg.setHotelLocation(dto.getHotelLocation());
        agg.setHotelRating(dto.getHotelRating());
        agg.setHotelPrice(dto.getHotelPrice());
        repo.save(agg);
        return dto;
    }

    @Transactional
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public void deleteByUserAndHotel(Long userId, Long hotelId) {
        repo.deleteByUserIdAndHotelId(userId, hotelId);
    }
}
