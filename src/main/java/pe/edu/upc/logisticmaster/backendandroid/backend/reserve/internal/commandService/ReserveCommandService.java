package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.internal.commandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.repositories.ReserveRepository;

@Service
public class ReserveCommandService {
    private final ReserveRepository repo;

    public ReserveCommandService(ReserveRepository repo) {
        this.repo = repo;
    }

    public ReserveAggregate create(ReserveAggregate r) {
        return repo.save(r);
    }

    public ReserveAggregate update(Long id, ReserveAggregate r) {
        r.setId(id);
        return repo.save(r);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}