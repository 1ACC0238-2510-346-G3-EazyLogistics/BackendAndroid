package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.repositories.ReserveRepository;

import java.util.List;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository reserveRepository;

    // Método para crear una reserva
    public ReserveAggregate createReserve(ReserveCommand command) {
        // Convertir el comando en una entidad (Reserva)
        ReserveAggregate reserve = new ReserveAggregate(command.getUserId(), command.getRoomId(), command.getStatus(), command.getStartTime(), command.getEndTime());

        // Guardar la reserva en la base de datos utilizando el repositorio
        return reserveRepository.save(reserve);
    }

    // Método para obtener una reserva por su ID
    public ReserveAggregate getReserveById(Integer id) {
        // Buscar la reserva por ID en la base de datos
        return reserveRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    // Método para obtener todas las reservas
    public List<ReserveAggregate> getAllReserves() {
        // Recuperar todas las reservas desde el repositorio
        return reserveRepository.findAll();
    }

    // Método para actualizar una reserva
    public ReserveAggregate updateReserve(Integer id, ReserveCommand command) {
        // Buscar la reserva existente
        ReserveAggregate existingReserve = reserveRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        // Actualizar los campos de la reserva con los datos del comando
        existingReserve.setUserId(command.getUserId());
        existingReserve.setRoomId(command.getRoomId());
        existingReserve.setStatus(command.getStatus());
        existingReserve.setStartTime(command.getStartTime());
        existingReserve.setEndTime(command.getEndTime());

        // Guardar la reserva actualizada
        return reserveRepository.save(existingReserve);
    }

    // Método para eliminar una reserva
    public void deleteReserve(Integer id) {
        ReserveAggregate existingReserve = reserveRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reserveRepository.delete(existingReserve);
    }
}