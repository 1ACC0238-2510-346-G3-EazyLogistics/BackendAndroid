package pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.resources;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.transform.BookItemDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.services.BookItemCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.services.BookItemQueryService;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping
public class BookItemController {

    private final BookItemCommandService command;
    private final BookItemQueryService query;

    // Constructor explícito para inyección de dependencias
    public BookItemController(
            BookItemCommandService command,
            BookItemQueryService query
    ) {
        this.command = command;
        this.query = query;
    }

    // — CRUD estándar por usuario
    @GetMapping("/api/users/{userId}/bookings")
    public List<BookItemDto> getByUser(@PathVariable Long userId) {
        return query.findByUserId(userId);
    }

    @GetMapping("/api/users/{userId}/bookings/{id}")
    public BookItemDto getById(
            @PathVariable Long userId,
            @PathVariable Long id
    ) {
        return query.findById(id);
    }

    @PostMapping("/api/users/{userId}/bookings")
    public ResponseEntity<BookItemDto> create(
            @PathVariable Long userId,
            @RequestBody BookItemDto dto
    ) {
        dto.setUserId(userId);
        BookItemDto created = command.create(dto);
        return ResponseEntity
                .created(URI.create("/users/" + userId + "/bookings/" + created.getId()))
                .body(created);
    }

    @PutMapping("/api/users/{userId}/bookings/{id}")
    public ResponseEntity<BookItemDto> update(
            @PathVariable Long userId,
            @PathVariable Long id,
            @RequestBody BookItemDto dto
    ) {
        dto.setUserId(userId);
        return ResponseEntity.ok(command.update(id, dto));
    }

    @DeleteMapping("/api/users/{userId}/bookings/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long userId,
            @PathVariable Long id
    ) {
        command.delete(id);
        return ResponseEntity.noContent().build();
    }

    // — Endpoints globales

    @GetMapping("/api/bookings")
    public List<BookItemDto> getAll() {
        return query.findAll();
    }

    @GetMapping("/api/bookings/hotel/{hotelId}")
    public List<BookItemDto> getByHotel(@PathVariable Long hotelId) {
        return query.findByHotelId(hotelId);
    }

    @GetMapping("/api/bookings/search")
    public List<BookItemDto> findByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        LocalDateTime start = from.atStartOfDay();
        LocalDateTime end = to.atTime(23, 59, 59);
        return query.findByCheckInBetween(start, end);
    }

    // — Acciones parciales

    @PatchMapping("/api/users/{userId}/bookings/{id}/pay")
    public ResponseEntity<BookItemDto> markAsPaid(
            @PathVariable Long userId,
            @PathVariable Long id
    ) {
        BookItemDto dto = query.findById(id);
        dto.setIsPaid(true);
        return ResponseEntity.ok(command.update(id, dto));
    }

    @PatchMapping("/api/users/{userId}/bookings/{id}/status")
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
