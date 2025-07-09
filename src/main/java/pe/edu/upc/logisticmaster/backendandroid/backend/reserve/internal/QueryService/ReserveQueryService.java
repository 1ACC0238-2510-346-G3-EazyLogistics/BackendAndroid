package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.internal.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.repositories.ReserveRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReserveQueryService {
    private final ReserveRepository repo;

    public ReserveQueryService(ReserveRepository repo) {
        this.repo = repo;
    }

    public List<ReserveAggregate> findAll() {
        return repo.findAll();
    }

    public ReserveAggregate findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada: " + id));
    }
}
