package com.tw.springboot.config;

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
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.tw.springboot"))
				.paths(PathSelectors.regex("/bank.*"))
				.build();

	}
	private ApiInfo apiInfo() {
		return new ApiInfo("BANK APPLICATION", 
							"DEVELOPED BY TECHWISH JAVA DEVELOPEMENT TEAM",
							"3.2GA", "http://sample.com", 
							new Contact("APURBA", "http://sample.com/raghu", "mallikapurbaranjan@gmail.com"), 
							"Apache", "http://test.com", 
							Collections.emptyList());
	}
}
