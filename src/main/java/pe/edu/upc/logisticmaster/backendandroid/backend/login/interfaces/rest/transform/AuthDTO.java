package pe.edu.upc.logisticmaster.backendandroid.backend.login.interfaces.rest.transform;

import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthAggregate;

@Setter
@Getter
public class AuthDTO {
    // Getters y Setters
    private String email;
    private String password;

    // Constructor para transformar un AuthAggregate en AuthDTO
    public AuthDTO(AuthAggregate authAggregate) {
        this.email = authAggregate.getEmail();  // Este método es generado por Lombok
        this.password = authAggregate.getPassword();  // Este método es generado por Lombok
    }

}
