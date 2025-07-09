package pe.edu.upc.logisticmaster.backendandroid.backend.user.interfaces.rest.resources;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.internal.queryService.UserQueryService;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.internal.commandService.UserCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.transform.UserDto;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserQueryService    querySvc;
    private final UserCommandService  cmdSvc;

    public UserController(
            UserQueryService querySvc,
            UserCommandService cmdSvc
    ) {
        this.querySvc = querySvc;
        this.cmdSvc   = cmdSvc;
    }

    @GetMapping
    public List<UserDto> getAll() {
        return querySvc.getAll();
    }

    @GetMapping("/{id:\\d+}")
    public UserDto getById(@PathVariable Long id) {
        return querySvc.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto dto) {
        return cmdSvc.create(dto);
    }

    @PutMapping("/{id}")
    public UserDto update(
            @PathVariable Long id,
            @RequestBody UserDto dto
    ) {
        return cmdSvc.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cmdSvc.delete(id);
    }

    /** Login: recupera el usuario por 'usuario' para comparar contraseña */
    @GetMapping("/username/{usuario}")
    public UserDto getByUsuario(@PathVariable String usuario) {
        return querySvc.getByUsuario(usuario);
    }
}
