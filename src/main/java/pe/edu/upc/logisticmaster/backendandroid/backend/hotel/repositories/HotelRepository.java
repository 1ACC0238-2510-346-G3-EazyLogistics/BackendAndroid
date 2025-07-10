package pe.edu.upc.logisticmaster.backendandroid.backend.hotel.repositories;

import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.domain.model.HotelAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<HotelAggregate, Long> {
    List<HotelAggregate> findByCity(String city);
    List<HotelAggregate> findByIsPremiumTrue();
    List<HotelAggregate> findByNameContainingIgnoreCase(String namePart);
}
