// src/main/java/pe/edu/upc/logisticmaster/backendandroid/backend/user/interfaces/rest/resources/UserController.java
package pe.edu.upc.logisticmaster.backendandroid.backend.user.interfaces.rest.resources;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.service.UserService;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.transform.UserDto;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService svc;

    public UserController(UserService svc) {
        this.svc = svc;
    }

    /** CREATE */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto dto) {
        return svc.create(dto);
    }

    /** READ ALL */
    @GetMapping
    public List<UserDto> listAll() {
        return svc.listAll();
    }

    /** READ BY ID */
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return svc.getById(id);
    }

    /** READ BY USERNAME */
    @GetMapping("/username/{usuario}")
    public UserDto getByUsuario(@PathVariable String usuario) {
        return svc.getByUsuario(usuario);
    }

    /** READ BY EMAIL */
    @GetMapping("/email/{email}")
    public UserDto getByEmail(@PathVariable String email) {
        return svc.getByEmail(email);
    }

    /** UPDATE BY ID */
    @PutMapping("/{id}")
    public UserDto updateById(@PathVariable Long id, @RequestBody UserDto dto) {
        dto.setId(id);
        return svc.updateById(dto);
    }

    /** UPDATE BY EMAIL */
    @PutMapping("/email/{email}")
    public UserDto updateByEmail(@PathVariable String email, @RequestBody UserDto dto) {
        dto.setEmail(email);
        return svc.updateByEmail(dto);
    }

    /** DELETE BY ID */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        svc.delete(id);
    }
}
