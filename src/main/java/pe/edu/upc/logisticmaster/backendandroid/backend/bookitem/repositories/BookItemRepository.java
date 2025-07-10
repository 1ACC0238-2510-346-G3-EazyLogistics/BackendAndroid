package pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.repositories;

import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.model.BookItemAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookItemRepository extends JpaRepository<BookItemAggregate, Long> {
    List<BookItemAggregate> findByUserId(Long userId);

    List<BookItemAggregate> findByHotelId(Long hotelId);

    List<BookItemAggregate> findByCheckInDateBetween(LocalDateTime from, LocalDateTime to);
}
