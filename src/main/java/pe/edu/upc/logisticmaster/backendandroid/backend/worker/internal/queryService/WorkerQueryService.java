package pe.edu.upc.logisticmaster.backendandroid.backend.worker.internal.queryService;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.repositories.WorkerRepository;

import java.util.List;

@Service
public class WorkerQueryService {

    private final WorkerRepository repo;

    public WorkerQueryService(WorkerRepository repo) {
        this.repo = repo;
    }

    public List<WorkerAggregate> findAll() {
        return repo.findAll();
    }

    public WorkerAggregate findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado: " + id));
    }
}
