package pe.edu.upc.logisticmaster.backendandroid.backend.worker.internal.commandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerService;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.transform.WorkerDto;

@Service
public class WorkerCommandService {

    @Autowired
    private WorkerService workerService;

    // Ejecutar el comando de crear un trabajador
    public WorkerDto executeCreateWorker(WorkerCommand command) {
        // Creamos el trabajador utilizando el servicio
        WorkerAggregate worker = workerService.createWorker(command);
        // Devolvemos un WorkerDto para el cliente
        return new WorkerDto(worker);
    }

    // Ejecutar el comando de actualizar un trabajador
    public WorkerDto executeUpdateWorker(Long id, WorkerCommand command) {
        // Actualizamos el trabajador utilizando el servicio
        WorkerAggregate worker = workerService.updateWorker(id, command);
        // Devolvemos el trabajador actualizado en un WorkerDto
        return new WorkerDto(worker);
    }

    // Ejecutar el comando de eliminar un trabajador
    public void executeDeleteWorker(Long id) {
        // Eliminamos el trabajador utilizando el servicio
        workerService.deleteWorker(id);
    }
}
