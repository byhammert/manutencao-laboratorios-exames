package com.manutencao.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {
	
	private LaboratorioInMemRepository laboratorioInMemRepository = new LaboratorioInMemRepository();
	private ExameInMemRepository exameInMemRepository = new ExameInMemRepository();
	
	@Bean
	public LaboratorioRepository createLaboratorioRepository() {
		laboratorioInMemRepository.addObserver(exameInMemRepository);
		return laboratorioInMemRepository;
	}
	
	@Bean
	public ExameRepository createExameRepository() {
		exameInMemRepository.addObserver(laboratorioInMemRepository);
		return exameInMemRepository;
	}

}
