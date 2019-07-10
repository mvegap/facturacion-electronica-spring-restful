package com.miguelvega.apifacturaelectronica.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build();
    }

    // Describe your apis
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("[Microservice] - API Facturación Electrónica")
                .description("This page lists all the RESTful for Facturación Electrónica API")
                .version("1.0")
                .license("MIT")
                .build();
    }

    // Only select apis that matches the given Predicates.
    private Predicate<String> paths() {
        // Match all paths except /error
        return (Predicate<String>) Predicates.and(
                PathSelectors.regex("/.*"),
                Predicates.not(PathSelectors.regex("/error.*"))
        );
    }
}
