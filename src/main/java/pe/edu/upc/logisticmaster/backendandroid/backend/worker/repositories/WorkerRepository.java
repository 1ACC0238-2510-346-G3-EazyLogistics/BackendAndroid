package pe.edu.upc.logisticmaster.backendandroid.backend.worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;


public interface WorkerRepository extends JpaRepository<WorkerAggregate, Long> {
}
