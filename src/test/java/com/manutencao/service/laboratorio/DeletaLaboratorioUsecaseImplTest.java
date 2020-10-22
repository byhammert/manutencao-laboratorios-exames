package com.manutencao.service.laboratorio;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.mock.LaboratorioMock;
import com.manutencao.model.laboratorio.Laboratorio;

public class DeletaLaboratorioUsecaseImplTest {
	
	private LaboratorioRepository laboratorioRepository;
	private DeletaLaboratorioUsecase service;
	
	@BeforeEach
	public void setup() {	
		laboratorioRepository = mock(LaboratorioRepository.class);
		service = new DeletaLaboratorioUsecaseImpl(laboratorioRepository);
	}
	
	@Test
	public void deve_deletar_laboratorio() {
		Laboratorio laboratorio = LaboratorioMock.obterLaboratorioAtivo();
		when(laboratorioRepository.getBy(anyString())).thenReturn(laboratorio);
		doNothing().when(laboratorioRepository).delete(anyString());
		service.executar("teste");
	}

}
