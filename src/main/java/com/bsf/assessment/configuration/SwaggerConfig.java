package com.bsf.assessment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.bsf.assessment.controller")).
                        paths(PathSelectors.ant("/api/v1/*/*")).build().apiInfo(apiInfo());
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "BSF REST API",
                "There are Two APIs for managing account operations",
                "V1",
                "Terms of service",
                new Contact("Youssif Tawfik", "https://github.com/YoussifTawfik/BSF-Assessment", "youssif.tawfik96@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
