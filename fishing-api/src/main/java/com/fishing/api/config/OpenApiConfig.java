package com.fishing.api.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI fishingApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Fishing API")
                        .description("API for managing fishing activities")
                        .version("1.0.0"));
    }
}
