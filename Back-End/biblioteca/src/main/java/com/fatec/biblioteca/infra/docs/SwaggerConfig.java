package com.fatec.biblioteca.infra.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Biblioteca API").description("""
				API Rest de um sistemas de biblioteca.
				Trabalho realizado para apredizagem da matéria de modelagem de Banco de Dados
				""")
				.version("1.0")
		);
	}

}