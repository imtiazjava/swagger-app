package com.itc.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ProductConfig {

	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.itc.main"))
				.paths(PathSelectors.any())//
				.build()
				.apiInfo(apiinfo());
	}

	private ApiInfo apiinfo() {
		// TODO Auto-generated method stub
		return new ApiInfo("SPRINGBOOT-WITH-RESTAPI-SWAGGER", 
				"This is my first Swagger Application", 
				"Swagger 1.0v", 
				"http://localhost:1111/api/products", 
				new Contact("IMTIAZ","http://localhost:1111/api/products","IMTIAZ@GMAIL.COM"), 
				"Apache 2.0", 
				"https://www.apache.org");
	}
}
