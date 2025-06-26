package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveService;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.internal.QueryService.ReserveQueryService;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.interfaces.rest.transform.ReserveDto;

import java.util.List;

@RestController
@RequestMapping("/api/reserves")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @Autowired
    private ReserveQueryService reserveQueryService;

    /**
     * GET /api/reserves/{id}
     * – 200 OK con ReserveDto (incluye datos de UserDto)
     * – 404 Not Found si no existe
     * – 500 Internal Server Error en errores inesperados
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            ReserveDto dto = reserveQueryService.getReserveById(id);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException notFound) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(notFound.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al obtener la reserva");
        }
    }

    /**
     * POST /api/reserves
     * – 201 Created con ReserveDto
     * – 400 Bad Request si faltan datos
     * – 500 Internal Server Error en excepciones
     */
    @PostMapping
    public ResponseEntity<?> createReserve(@RequestBody ReserveCommand cmd) {
        if (cmd.getUserId() == null
                || cmd.getRoomId() == null
                || cmd.getStatus() == null || cmd.getStatus().isBlank()
                || cmd.getStartTime() == null || cmd.getStartTime().isBlank()
                || cmd.getEndTime() == null || cmd.getEndTime().isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("Faltan campos obligatorios: userId, roomId, status, startTime, endTime");
        }
        try {
            var created = reserveService.createReserve(cmd);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ReserveDto(created));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al crear la reserva");
        }
    }

    /**
     * GET /api/reserves
     * – 200 OK con lista de ReserveDto
     * – 500 Internal Server Error en excepciones
     */
    @GetMapping
    public ResponseEntity<?> listAll() {
        try {
            List<ReserveDto> list = reserveQueryService.getAllReserves();
            return ResponseEntity.ok(list);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al listar reservas");
        }
    }

    /**
     * DELETE /api/reserves/{id}
     * – 200 OK si se elimina
     * – 404 Not Found si no existe
     * – 500 Internal Server Error en excepciones
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            reserveService.getReserveById(id); // arroja RuntimeException si no existe
            reserveService.deleteReserve(id);
            return ResponseEntity.ok("Reserva eliminada correctamente");
        } catch (RuntimeException notFound) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(notFound.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al eliminar la reserva");
        }
    }

    /**
     * PUT /api/reserves/{id}
     * – 200 OK con ReserveDto
     * – 400 Bad Request si faltan datos
     * – 404 Not Found si no existe
     * – 500 Internal Server Error en excepciones
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReserve(
            @PathVariable Integer id,
            @RequestBody ReserveCommand cmd
    ) {
        if (cmd.getUserId() == null
                || cmd.getRoomId() == null
                || cmd.getStatus() == null || cmd.getStatus().isBlank()
                || cmd.getStartTime() == null || cmd.getStartTime().isBlank()
                || cmd.getEndTime() == null || cmd.getEndTime().isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("Faltan campos obligatorios: userId, roomId, status, startTime, endTime");
        }
        try {
            var updated = reserveService.updateReserve(id, cmd);
            return ResponseEntity.ok(new ReserveDto(updated));
        } catch (RuntimeException notFound) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(notFound.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al actualizar la reserva");
        }
    }
}
