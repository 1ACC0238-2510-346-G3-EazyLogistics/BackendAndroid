package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveAggregate;

public interface ReserveRepository extends JpaRepository<ReserveAggregate, Integer> {
    // Puedes agregar métodos personalizados si lo necesitas, por ejemplo, buscar reservas por userId
}
