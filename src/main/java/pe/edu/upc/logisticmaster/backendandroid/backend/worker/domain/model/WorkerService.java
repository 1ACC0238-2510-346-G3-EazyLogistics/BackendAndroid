package pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.repositories.WorkerRepository;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    // Crear un trabajador
    public WorkerAggregate createWorker(WorkerCommand command) {
        WorkerAggregate worker = new WorkerAggregate(command.getName(), command.getPosition(), command.getEmail(), command.isActive());
        return workerRepository.save(worker);
    }

    // Obtener un trabajador por su ID
    public WorkerAggregate getWorkerById(Long id) {
        return workerRepository.findById(id).orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));
    }

    // Obtener todos los trabajadores
    public List<WorkerAggregate> getAllWorkers() {
        return workerRepository.findAll(); // Método findAll de JPA para obtener todos los trabajadores
    }

    // Actualizar un trabajador
    public WorkerAggregate updateWorker(Long id, WorkerCommand command) {
        WorkerAggregate worker = workerRepository.findById(id).orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));
        worker.setName(command.getName());
        worker.setPosition(command.getPosition());
        worker.setEmail(command.getEmail());
        worker.setActive(command.isActive());
        return workerRepository.save(worker);
    }

    // Eliminar un trabajador
    public void deleteWorker(Long id) {
        WorkerAggregate worker = workerRepository.findById(id).orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));
        workerRepository.delete(worker);
    }
}
