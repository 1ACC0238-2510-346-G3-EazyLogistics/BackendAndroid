package pe.edu.upc.logisticmaster.backendandroid.backend.task.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.TaskAggregate;

public interface TaskRepository extends JpaRepository<TaskAggregate, Long> {
    List<TaskAggregate> findByWorkerId(Long workerId);
}
