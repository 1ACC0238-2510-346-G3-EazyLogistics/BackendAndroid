package pe.edu.upc.logisticmaster.backendandroid.backend.worker.internal.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerService;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.transform.WorkerDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerQueryService {

    @Autowired
    private WorkerService workerService;

    // Método para obtener un trabajador por ID y devolverlo como DTO
    public WorkerDto getWorkerById(Long id) {
        WorkerAggregate worker = workerService.getWorkerById(id);
        return new WorkerDto(worker);
    }

    // Método para obtener todos los trabajadores y devolverlos como una lista de DTOs
    public List<WorkerDto> getAllWorkers() {
        List<WorkerAggregate> workers = workerService.getAllWorkers();
        return workers.stream()
                .map(WorkerDto::new)
                .collect(Collectors.toList());
    }
}
