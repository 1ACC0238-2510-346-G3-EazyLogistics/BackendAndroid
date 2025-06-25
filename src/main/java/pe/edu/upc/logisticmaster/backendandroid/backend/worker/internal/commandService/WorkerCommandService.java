package pe.edu.upc.logisticmaster.backendandroid.backend.worker.internal.commandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerService;

@Service
public class WorkerCommandService {

    @Autowired
    private WorkerService workerService;

    // Método para crear un nuevo trabajador
    public void executeCreateWorker(WorkerCommand workerCommand) {
        workerService.createWorker(workerCommand);
    }

    // Método para actualizar un trabajador
    public void executeUpdateWorker(Long id, WorkerCommand workerCommand) {
        workerService.updateWorker(id, workerCommand);
    }

    // Método para eliminar un trabajador
    public void executeDeleteWorker(Long id) {
        workerService.deleteWorker(id);
    }
}
