package com.backendChallenge.config;

import java.util.function.Predicate;
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
public class PowerConfig {
	 @Bean 
	 public Docket api() { 
	     return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
	             .select()
	             .apis(RequestHandlerSelectors.any())
	             .paths(PathSelectors.any())
	             .paths(Predicate.not(PathSelectors.regex("/error.*")))
	             .build();
	 }
    
	 
	 private ApiInfo apiInfo() {
		 return new ApiInfoBuilder().title("Virtual Power Plant").description("API documentation using Swagger").build();
	 }

}