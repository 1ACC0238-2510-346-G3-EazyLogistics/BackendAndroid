package pe.edu.upc.logisticmaster.backendandroid.backend.worker.internal.commandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.repositories.WorkerRepository;


@Service
public class WorkerCommandService {

    private final WorkerRepository repo;

    public WorkerCommandService(WorkerRepository repo) {
        this.repo = repo;
    }

    public WorkerAggregate create(WorkerAggregate w) {
        return repo.save(w);
    }

    public WorkerAggregate update(Long id, WorkerAggregate w) {
        w.setId(id);
        return repo.save(w);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}