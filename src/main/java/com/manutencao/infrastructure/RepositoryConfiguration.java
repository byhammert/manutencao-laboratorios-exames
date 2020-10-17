package com.manutencao.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {
	
	@Bean
	public LaboratorioRepository createRepository() {
		return new LaboratorioInMemRepository();
	}

}
