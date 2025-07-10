package pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.transform.FavoriteHotelDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.services.FavoriteHotelCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.services.FavoriteHotelQueryService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users/{userId}/favorites")
@RequiredArgsConstructor
public class FavoriteHotelController {

    private final FavoriteHotelCommandService command;
    private final FavoriteHotelQueryService query;

    // — CRUD por usuario
    @GetMapping
    public List<FavoriteHotelDto> listByUser(@PathVariable Long userId) {
        return query.findByUserId(userId);
    }

    @GetMapping("/{id}")
    public FavoriteHotelDto get(@PathVariable Long userId, @PathVariable Long id) {
        return query.findById(id);
    }

    @PostMapping
    public ResponseEntity<FavoriteHotelDto> create(
            @PathVariable Long userId,
            @RequestBody FavoriteHotelDto dto
    ) {
        dto.setUserId(userId);
        FavoriteHotelDto created = command.create(dto);
        return ResponseEntity
                .created(URI.create("/users/" + userId + "/favorites/" + created.getId()))
                .body(created);
    }

    @PutMapping("/{id}")
    public FavoriteHotelDto update(
            @PathVariable Long userId,
            @PathVariable Long id,
            @RequestBody FavoriteHotelDto dto
    ) {
        dto.setUserId(userId);
        return command.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long userId,
            @PathVariable Long id
    ) {
        command.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // — Operaciones globales

    /** Listar todos los favoritos */
    @GetMapping(path = "/../../favorites")
    public List<FavoriteHotelDto> listAll() {
        return query.findAll();
    }

    /** Listar favoritos de un hotel */
    @GetMapping(path = "/../../favorites/hotel/{hotelId}")
    public List<FavoriteHotelDto> listByHotel(@PathVariable Long hotelId) {
        return query.findByHotelId(hotelId);
    }

    // — Operaciones user+hotel

    /** Comprobar si el usuario marcó favorito este hotel */
    @GetMapping("/hotel/{hotelId}/exists")
    public ResponseEntity<Boolean> exists(
            @PathVariable Long userId,
            @PathVariable Long hotelId
    ) {
        return ResponseEntity.ok(query.existsByUserAndHotel(userId, hotelId));
    }

    /** Borrar favorito por (userId, hotelId) */
    @DeleteMapping("/hotel/{hotelId}")
    public ResponseEntity<Void> deleteByUserAndHotel(
            @PathVariable Long userId,
            @PathVariable Long hotelId
    ) {
        command.deleteByUserAndHotel(userId, hotelId);
        return ResponseEntity.noContent().build();
    }
}
