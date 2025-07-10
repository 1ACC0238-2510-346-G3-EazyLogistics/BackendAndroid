package pe.edu.upc.logisticmaster.backendandroid.backend.resena.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.resena.transform.ReviewDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.resena.domain.services.ReviewCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.resena.domain.services.ReviewQueryService;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService command;
    private final ReviewQueryService query;

    // — CRUD estándar

    @GetMapping("/reviews")
    public List<ReviewDto> listAll() {
        return query.findAll();
    }

    @GetMapping("/reviews/{id}")
    public ReviewDto get(@PathVariable Long id) {
        return query.findById(id);
    }

    @PostMapping("/hotels/{hotelId}/reviews")
    public ResponseEntity<ReviewDto> create(
            @PathVariable Long hotelId,
            @RequestBody ReviewDto dto
    ) {
        ReviewDto created = command.create(hotelId, dto);
        return ResponseEntity
                .created(URI.create("/reviews/" + created.getId()))
                .body(created);
    }

    @PutMapping("/reviews/{id}")
    public ReviewDto update(
            @PathVariable Long id,
            @RequestBody ReviewDto dto
    ) {
        return command.update(id, dto);
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        command.delete(id);
        return ResponseEntity.noContent().build();
    }

    // — Endpoints de conveniencia

    /** Listar reseñas de un hotel */
    @GetMapping("/hotels/{hotelId}/reviews")
    public List<ReviewDto> byHotel(@PathVariable Long hotelId) {
        return query.findByHotel(hotelId);
    }

    /** Reseñas con rating >= min */
    @GetMapping("/reviews/search/rating")
    public List<ReviewDto> byMinRating(@RequestParam Integer min) {
        return query.findByMinRating(min);
    }

    /** Reseñas entre dos fechas */
    @GetMapping("/reviews/search/date")
    public List<ReviewDto> byDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        LocalDateTime start = from.atStartOfDay();
        LocalDateTime end   = to.atTime(23,59,59);
        return query.findByDateRange(start, end);
    }

    /** Buscar por palabra en comentario */
    @GetMapping("/reviews/search/comment")
    public List<ReviewDto> searchComment(@RequestParam String text) {
        return query.searchByComment(text);
    }

    /** Promedio de rating de un hotel */
    @GetMapping("/hotels/{hotelId}/reviews/average")
    public ResponseEntity<Double> averageRating(@PathVariable Long hotelId) {
        Double avg = query.getAverageRating(hotelId);
        return ResponseEntity.ok(avg != null ? avg : 0.0);
    }
}
