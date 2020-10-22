package com.manutencao.service.laboratorio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.mock.LaboratorioMock;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.service.exame.ValidaExameUsecase;

public class CadastroLaboratorioUsecaseImplTest {
	
	private LaboratorioRepository laboratorioRepository;
	private CadastroLaboratorioUsecase service;
	private ValidaExameUsecase validaExameService;
	
	@BeforeEach
	public void setup() {
		laboratorioRepository = mock(LaboratorioRepository.class);
		validaExameService = mock(ValidaExameUsecase.class);
		service = new CadastroLaboratorioUsecaseImpl(laboratorioRepository, validaExameService);
	}
	
	@Test
	public void deve_cadastrar_laboratorio() {
		final Laboratorio laboratorio = LaboratorioMock.obterLaboratorioAtivo();
		doNothing().when(laboratorioRepository).save(laboratorio);
		final Laboratorio laboratorioSalvo = service.executar(laboratorio);
		
		assertThat(laboratorioSalvo).isNotNull();
		assertThat(laboratorioSalvo.toString()).isEqualTo(laboratorio.toString());
	}

}
