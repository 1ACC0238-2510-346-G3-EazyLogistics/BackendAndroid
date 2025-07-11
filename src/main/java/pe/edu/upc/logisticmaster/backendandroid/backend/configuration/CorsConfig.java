package pe.edu.upc.logisticmaster.backendandroid.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configura CORS para todos los endpoints y permite cualquier origen
        registry.addMapping("/**") // Aplica CORS a todos los endpoints
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Permite todas las cabeceras
                .allowCredentials(true); // Permite enviar credenciales (como cookies)
    }
}
