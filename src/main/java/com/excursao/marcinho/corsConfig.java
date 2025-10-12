package com.excursao.marcinho;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class corsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // libera todas as rotas
                        .allowedOrigins("*") // permite qualquer origem
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // todos os métodos
                        .allowedHeaders("*") // todos os headers
                        .allowCredentials(false); // se quiser permitir cookies, mude pra true
            }
        };
    }
}
