package pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.transform.BookItemDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.services.BookItemCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.services.BookItemQueryService;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.repositories.BookItemRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookItemController {

    private final BookItemCommandService command;
    private final BookItemQueryService query;

    // — CRUD estándar por usuario
    @GetMapping("/users/{userId}/bookings")
    public List<BookItemDto> getByUser(@PathVariable Long userId) {
        return query.findByUserId(userId);
    }

    @GetMapping("/users/{userId}/bookings/{id}")
    public BookItemDto getById(@PathVariable Long userId, @PathVariable Long id) {
        // validar userId ≡ dto.getUserId() si quieres
        return query.findById(id);
    }

    @PostMapping("/users/{userId}/bookings")
    public ResponseEntity<BookItemDto> create(
            @PathVariable Long userId,
            @RequestBody BookItemDto dto
    ) {
        dto.setUserId(userId);
        return ResponseEntity.ok(command.create(dto));
    }

    @PutMapping("/users/{userId}/bookings/{id}")
    public ResponseEntity<BookItemDto> update(
            @PathVariable Long userId,
            @PathVariable Long id,
            @RequestBody BookItemDto dto
    ) {
        dto.setUserId(userId);
        return ResponseEntity.ok(command.update(id, dto));
    }

    @DeleteMapping("/users/{userId}/bookings/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long userId,
            @PathVariable Long id
    ) {
        command.delete(id);
        return ResponseEntity.noContent().build();
    }

    // — Nuevos endpoints globales (sin userId)

    /** Listar todas las reservas del sistema */
    @GetMapping("/bookings")
    public List<BookItemDto> getAll() {
        return query.findAll();
    }

    /** Listar reservas de un hotel concreto */
    @GetMapping("/bookings/hotel/{hotelId}")
    public List<BookItemDto> getByHotel(@PathVariable Long hotelId) {
        return query.findByHotelId(hotelId);
    }

    /** Listar reservas entre dos fechas (check-inDate) */
    @GetMapping("/bookings/search")
    public List<BookItemDto> findByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        return query.findByCheckInBetween(
                from.atStartOfDay(),
                to.atTime(23, 59, 59)
        );
    }


    /** Marcar como pagada */
    @PatchMapping("/users/{userId}/bookings/{id}/pay")
    public ResponseEntity<BookItemDto> markAsPaid(
            @PathVariable Long userId,
            @PathVariable Long id
    ) {
        BookItemDto dto = query.findById(id);
        dto.setIsPaid(true);
        return ResponseEntity.ok(command.update(id, dto));
    }

    /** Actualizar solo el estado */
    @PatchMapping("/users/{userId}/bookings/{id}/status")
    public ResponseEntity<BookItemDto> updateStatus(
            @PathVariable Long userId,
            @PathVariable Long id,
            @RequestParam String status
    ) {
        BookItemDto dto = query.findById(id);
        dto.setStatus(status);
        return ResponseEntity.ok(command.update(id, dto));
    }
}
