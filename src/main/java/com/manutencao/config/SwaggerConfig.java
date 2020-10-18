package com.manutencao.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.manutencao.controller"))
					.paths(PathSelectors.any())
					.build()
					.apiInfo(apiInfo())
					.tags(
						new Tag("laboratorio", "Gerenciamento de Laboratório"),
						new Tag("exame", "Gerenciamento de Exame")
					);
	}
	
	private static ApiInfo apiInfo() {
		return new ApiInfo("API para manutenção de laboratórios e exames.", 
							"API para manutenção de laboratórios e exames.", 
							"0.0.1-SNAPSHOT", 
							"Terms of service", 
							new Contact("Luiz Jones", "", "luiz@ljones.com.br"), 
							"License of API", 
							"API license URL",
							Collections.emptyList());
	}

}
