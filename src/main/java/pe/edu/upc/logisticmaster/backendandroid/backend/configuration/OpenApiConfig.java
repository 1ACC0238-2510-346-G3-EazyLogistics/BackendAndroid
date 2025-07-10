package pe.edu.upc.logisticmaster.backendandroid.backend.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Backend Eazy Logistic",
                version = "1.0.0",
                description = "API REST para gestionar reservas, hoteles, favoritos y métodos de pago de Eazy Logistic",
                contact = @Contact(name = "Eazy Logistic Team", email = "soporte@eazylogistic.com")
        ),
        servers = @Server(url = "/", description = "Servidor local")
)
public class OpenApiConfig {
    // opcionalmente puedes definir un bean OpenAPI si quieres más control
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Backend Eazy Logistic")
                        .version("1.0.0")
                        .description("API REST para gestionar reservas, hoteles, favoritos y métodos de pago de Eazy Logistic")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
