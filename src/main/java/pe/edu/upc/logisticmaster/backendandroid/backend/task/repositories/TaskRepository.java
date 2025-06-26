package pe.edu.upc.logisticmaster.backendandroid.backend.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTitle(String title);
}
