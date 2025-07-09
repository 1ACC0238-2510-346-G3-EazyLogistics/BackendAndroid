package pe.edu.upc.logisticmaster.backendandroid.backend.worker.internal.commandService;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.repositories.WorkerRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.transform.WorkerDto;

@Service
public class WorkerCommandService {

    private final WorkerRepository repository;

    public WorkerCommandService(WorkerRepository repository) {
        this.repository = repository;
    }

    /** Crea un nuevo Worker */
    public WorkerDto create(WorkerDto dto) {
        WorkerAggregate agg = new WorkerAggregate(
                null,
                dto.getNombre(),
                dto.getApellido(),
                dto.getEmail(),
                dto.getTelefono(),
                dto.getPuesto(),
                dto.getArea()
        );
        WorkerAggregate saved = repository.save(agg);
        return saved.toDto();
    }

    /** Actualiza un Worker existente */
    public WorkerDto update(Long id, WorkerDto dto) {
        WorkerAggregate existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Worker no encontrado: " + id));

        existing.setNombre(dto.getNombre());
        existing.setApellido(dto.getApellido());
        existing.setEmail(dto.getEmail());
        existing.setTelefono(dto.getTelefono());
        existing.setPuesto(dto.getPuesto());
        existing.setArea(dto.getArea());

        WorkerAggregate updated = repository.save(existing);
        return updated.toDto();
    }

    /** Elimina un Worker por ID */
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
