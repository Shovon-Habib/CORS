package org.example.cors.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/*
    If you want to keep those Spring Boot MVC customizations and make more MVC customizations
    (interceptors, formatters, view controllers, and other features), you can add your own
    @Configuration class of type WebMvcConfigurer but without @EnableWebMvc.
*/

@Configuration
//@EnableWebMvc  --> See Readme
public class WebConfig implements WebMvcConfigurer {

    private final List<String> origins;

    public WebConfig(final @Value("${origins}") List<String> origins) {
        assert (origins != null);
        this.origins = origins;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**")
                .allowedOriginPatterns(origins.stream().toArray(String[]::new))
                .allowedMethods("*")
                .maxAge(3600);
    }
}
