// src/main/java/pe/edu/upc/logisticmaster/backendandroid/backend/user/service/UserService.java
package pe.edu.upc.logisticmaster.backendandroid.backend.user.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.internal.commandService.UserCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.internal.queryService.UserQueryService;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.transform.UserDto;

import java.util.List;

@Service
public class UserService {

    private final UserQueryService  querySvc;
    private final UserCommandService commandSvc;

    public UserService(UserQueryService querySvc, UserCommandService commandSvc) {
        this.querySvc = querySvc;
        this.commandSvc = commandSvc;
    }

    public UserDto create(UserDto dto) {
        return commandSvc.create(dto);
    }

    public List<UserDto> listAll() {
        return querySvc.listAll();
    }

    public UserDto getById(Long id) {
        return querySvc.getById(id);
    }

    public UserDto getByUsuario(String usuario) {
        return querySvc.getByUsuario(usuario);
    }

    public UserDto getByEmail(String email) {
        return querySvc.getByEmail(email);
    }

    public UserDto updateById(UserDto dto) {
        return commandSvc.updateById(dto);
    }

    public UserDto updateByEmail(UserDto dto) {
        return commandSvc.updateByEmail(dto);
    }

    public void delete(Long id) {
        commandSvc.delete(id);
    }
}
