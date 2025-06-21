package pe.edu.utp.gestion_cochera.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Sistema de Gestion de Cochera")
                        .version("1.0")
                        .description("API REST para gestionar una cochera con Spring Boot y H2 DB"));
    }
}