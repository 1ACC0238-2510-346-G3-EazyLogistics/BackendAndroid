package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveAggregate;

public interface ReserveRepository extends JpaRepository<ReserveAggregate, Long> { }