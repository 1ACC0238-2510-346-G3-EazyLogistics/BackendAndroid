package pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.transform.FavoriteHotelDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.services.FavoriteHotelCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.favoritehotel.domain.services.FavoriteHotelQueryService;

import java.net.URI;
import java.util.List;

@RestController
public class FavoriteHotelController {

    private final FavoriteHotelCommandService command;
    private final FavoriteHotelQueryService query;

    public FavoriteHotelController(
            FavoriteHotelCommandService command,
            FavoriteHotelQueryService query
    ) {
        this.command = command;
        this.query = query;
    }

    // ------------------------------------------------------------------------
    // —— Operaciones en contexto de usuario (/users/{userId}/favorites) ——
    // ------------------------------------------------------------------------

    /**
     * Listar todos los favoritos de un usuario.
     *
     * @param userId Identificador del usuario.
     * @return Lista de favoritos del usuario.
     */
    @GetMapping("/api/users/{userId}/favorites")
    public List<FavoriteHotelDto> listByUser(@PathVariable Long userId) {
        return query.findByUserId(userId);
    }

    /**
     * Obtener un favorito concreto de un usuario.
     *
     * @param userId Identificador del usuario.
     * @param id     Identificador del registro favorito.
     * @return DTO del favorito.
     */
    @GetMapping("/api/users/{userId}/favorites/{id}")
    public FavoriteHotelDto getById(
            @PathVariable Long userId,
            @PathVariable Long id
    ) {
        return query.findById(id);
    }

    /**
     * Añadir un hotel a favoritos para un usuario.
     *
     * @param userId Identificador del usuario.
     * @param dto    Datos del favorito a crear.
     * @return Response con código 201 y DTO creado.
     */
    @PostMapping("/api/users/{userId}/favorites")
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

    /**
     * Actualizar un favorito existente de un usuario.
     *
     * @param userId Identificador del usuario.
     * @param id     Identificador del registro favorito.
     * @param dto    Nuevos datos para el favorito.
     * @return DTO actualizado.
     */
    @PutMapping("/api/users/{userId}/favorites/{id}")
    public FavoriteHotelDto update(
            @PathVariable Long userId,
            @PathVariable Long id,
            @RequestBody FavoriteHotelDto dto
    ) {
        dto.setUserId(userId);
        return command.update(id, dto);
    }

    /**
     * Eliminar un favorito de un usuario.
     *
     * @param userId Identificador del usuario.
     * @param id     Identificador del registro favorito.
     */
    @DeleteMapping("/api/users/{userId}/favorites/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long userId,
            @PathVariable Long id
    ) {
        command.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Comprobar si un hotel está marcado como favorito por un usuario.
     *
     * @param userId  Identificador del usuario.
     * @param hotelId Identificador del hotel.
     * @return true si existe el favorito, false en caso contrario.
     */
    @GetMapping("/api/users/{userId}/favorites/hotel/{hotelId}/exists")
    public ResponseEntity<Boolean> existsByUserAndHotel(
            @PathVariable Long userId,
            @PathVariable Long hotelId
    ) {
        boolean exists = query.existsByUserAndHotel(userId, hotelId);
        return ResponseEntity.ok(exists);
    }

    /**
     * Eliminar un favorito por par (usuario, hotel).
     *
     * @param userId  Identificador del usuario.
     * @param hotelId Identificador del hotel.
     */
    @DeleteMapping("/api/users/{userId}/favorites/hotel/{hotelId}")
    public ResponseEntity<Void> deleteByUserAndHotel(
            @PathVariable Long userId,
            @PathVariable Long hotelId
    ) {
        command.deleteByUserAndHotel(userId, hotelId);
        return ResponseEntity.noContent().build();
    }

    // ------------------------------------------------------------------------
    // —— Operaciones globales (/favorites) ——
    // ------------------------------------------------------------------------

    /**
     * Listar todos los favoritos del sistema (todos los usuarios).
     *
     * @return Lista completa de favoritos.
     */
    @GetMapping("/api/favorites")
    public List<FavoriteHotelDto> listAll() {
        return query.findAll();
    }

    /**
     * Obtener un registro favorito por su ID.
     *
     * @param id Identificador del registro favorito.
     * @return DTO del favorito.
     */
    @GetMapping("/api/favorites/{id}")
    public FavoriteHotelDto getGlobalById(@PathVariable Long id) {
        return query.findById(id);
    }

    /**
     * Listar todos los usuarios que han marcado un hotel como favorito.
     *
     * @param hotelId Identificador del hotel.
     * @return Lista de favoritos filtrada por hotel.
     */
    @GetMapping("/api/favorites/hotel/{hotelId}")
    public List<FavoriteHotelDto> listByHotel(@PathVariable Long hotelId) {
        return query.findByHotelId(hotelId);
    }
}
