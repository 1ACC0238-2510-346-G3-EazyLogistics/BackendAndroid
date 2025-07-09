package pe.edu.upc.logisticmaster.backendandroid.backend.user.interfaces.rest.resources;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.internal.commandService.UserCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.internal.queryService.UserQueryService;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.transform.UserDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.UserAggregate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserCommandService command;
    private final UserQueryService query;

    public UserController(UserCommandService command, UserQueryService query) {
        this.command = command;
        this.query = query;
    }

    private UserDto toDto(UserAggregate u) {
        return new UserDto(
                u.getId(),
                u.getNombre(),
                u.getApellido(),
                u.getUsuario(),
                u.getEmail(),
                u.getContraseña()
        );
    }

    private UserAggregate toEntity(UserDto dto) {
        return new UserAggregate(
                dto.getId(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getUsuario(),
                dto.getEmail(),
                dto.getContraseña()
        );
    }

    @GetMapping
    public List<UserDto> list() {
        return query.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        return toDto(query.findById(id));
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {
        UserAggregate saved = command.create(toEntity(dto));
        return toDto(saved);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto dto) {
        UserAggregate updated = command.update(id, toEntity(dto));
        return toDto(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        command.delete(id);
    }
}
