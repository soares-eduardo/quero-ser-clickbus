package com.eduardosoares.QueroSerClickbusBackend;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QueroSerClickbusBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueroSerClickbusBackendApplication.class, args);
    }

    @Bean
    public OpenAPI generateCustomOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Click Bus - Places API")
                .version("1.0")
                .termsOfService("http://swagger.io/terms")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
