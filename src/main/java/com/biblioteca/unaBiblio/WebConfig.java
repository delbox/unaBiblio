package com.biblioteca.unaBiblio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite todas las rutas y subrutas
                        .allowedOrigins(
                            "https://unabiblio-front-production.up.railway.app",
                            "http://localhost:4200"
                        ) //permite los dos al mismo tiempo si es que pones por separado nose pq no funca
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                        .allowedHeaders("*") // Permite todos los headers
                        .allowCredentials(true); // Permite envío de cookies si es necesario
            }
        };
    }
}
