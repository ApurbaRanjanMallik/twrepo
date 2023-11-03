package com.tw.hms.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket configureDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.tw.hms.rest"))
				.paths(PathSelectors.regex("/v1/api.*"))
				.build();
	}
	private ApiInfo apiInfo() {
		return new ApiInfo("HOSPITAL MANAGEMENT SYSTEM APPLICATION", 
							"DEVELOPED BY TECHWISH JAVA DEVELOPEMENT TEAM",
							"3.2GA", "http://sample.com", 
							new Contact("APURBA", "http://sample.com/raghu", "mallikapurbaranjan@gmail.com"), 
							"Apache", "http://test.com", 
							Collections.emptyList());
	}
}
