package com.manutencao.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {
	
	@Bean
	public LaboratorioRepository createLaboratorioRepository() {
		return new LaboratorioInMemRepository();
	}
	
	@Bean
	public ExameRepository createExameRepository() {
		return new ExameInMemRepository();
	}

}
