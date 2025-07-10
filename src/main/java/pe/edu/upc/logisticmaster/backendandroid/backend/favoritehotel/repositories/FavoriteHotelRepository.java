package pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.repositories;

import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.model.FavoriteHotelAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteHotelRepository extends JpaRepository<FavoriteHotelAggregate, Long> {
    List<FavoriteHotelAggregate> findByUserId(Long userId);
    List<FavoriteHotelAggregate> findByHotelId(Long hotelId);
    boolean existsByUserIdAndHotelId(Long userId, Long hotelId);
    void deleteByUserIdAndHotelId(Long userId, Long hotelId);
}
