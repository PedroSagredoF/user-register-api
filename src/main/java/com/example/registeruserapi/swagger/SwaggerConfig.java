package com.example.registeruserapi.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info().title("Api API RESTful de Creación de Usuarios ").version("1.0 SNAPSHOT")
                .contact(new Contact().name("Pedro Sagredo").url("https://github.com/PedroSagredoF/user-register-api/"). email("pedro.sagredof@gmail.com"))
                .description("Esta aplicación expone una API RESTful para la creación de usuarios"));
    }
}
