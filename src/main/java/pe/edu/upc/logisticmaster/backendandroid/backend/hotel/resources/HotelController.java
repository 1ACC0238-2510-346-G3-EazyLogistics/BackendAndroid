package pe.edu.upc.logisticmaster.backendandroid.backend.hotel.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.transform.HotelDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.domain.services.HotelCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.domain.services.HotelQueryService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelCommandService command;
    private final HotelQueryService query;

    public HotelController(HotelCommandService command, HotelQueryService query) {
        this.command = command;
        this.query = query;
    }

    // CRUD

    @GetMapping
    public List<HotelDto> listAll() {
        return query.findAll();
    }

    @GetMapping("/{id}")
    public HotelDto get(@PathVariable Long id) {
        return query.findById(id);
    }

    @PostMapping
    public ResponseEntity<HotelDto> create(@RequestBody HotelDto dto) {
        HotelDto created = command.create(dto);
        return ResponseEntity
                .created(URI.create("/hotels/" + created.getId()))
                .body(created);
    }

    @PutMapping("/{id}")
    public HotelDto update(@PathVariable Long id, @RequestBody HotelDto dto) {
        return command.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        command.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Conveniencia

    @GetMapping("/city/{city}")
    public List<HotelDto> byCity(@PathVariable String city) {
        return query.findByCity(city);
    }

    @GetMapping("/premium")
    public List<HotelDto> premium() {
        return query.findPremium();
    }

    @GetMapping("/search")
    public List<HotelDto> searchByName(@RequestParam String name) {
        return query.searchByName(name);
    }
}
