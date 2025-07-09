package pe.edu.upc.logisticmaster.backendandroid.backend.worker.internal.queryService;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.UserAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.transform.UserDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.transform.WorkerDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * Devuelve todos los empleados como WorkerDto
     */
    public List<WorkerDto> getAll() {
        return repo.findAll().stream()
                .map(WorkerAggregate::toDto)   // asume que toDto() devuelve WorkerDto
                .collect(Collectors.toList());
    }

    /**
     * Devuelve un empleado como WorkerDto por su ID
     */
    public WorkerDto getById(Long id) {
        WorkerAggregate agg = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado: " + id));
        return agg.toDto();
    }

}
