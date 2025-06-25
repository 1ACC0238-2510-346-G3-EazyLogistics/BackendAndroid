package pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.User;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Crear o actualizar un usuario
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Obtener un usuario por su email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Eliminar un usuario por ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
