package pe.edu.upc.logisticmaster.backendandroid.backend.resena.repositories;

import pe.edu.upc.logisticmaster.backendandroid.backend.resena.domain.model.ReviewAggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewAggregate, Long> {
    List<ReviewAggregate> findByHotelId(Long hotelId);
    List<ReviewAggregate> findByRatingGreaterThanEqual(Integer minRating);
    List<ReviewAggregate> findByRatingDateBetween(LocalDateTime from, LocalDateTime to);
    List<ReviewAggregate> findByCommentContainingIgnoreCase(String text);

    @Query("SELECT AVG(r.rating) FROM ReviewAggregate r WHERE r.hotelId = :hotelId")
    Double findAverageRatingByHotelId(Long hotelId);
}
