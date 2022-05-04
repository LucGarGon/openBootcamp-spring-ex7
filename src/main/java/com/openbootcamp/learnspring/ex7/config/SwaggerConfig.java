package com.openbootcamp.learnspring.ex7.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Collections;

@Configuration
public class SwaggerConfig {


    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder().group("Spring boot api rest").pathsToMatch("/*").build();
    }

}
