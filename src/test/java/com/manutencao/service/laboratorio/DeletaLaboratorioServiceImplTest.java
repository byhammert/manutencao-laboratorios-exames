package com.manutencao.service.laboratorio;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.LaboratorioRepository;

public class DeletaLaboratorioServiceImplTest {
	
	private LaboratorioRepository laboratorioRepository;
	private DeletaLaboratorioService service;
	
	@BeforeEach
	public void setup() {	
		laboratorioRepository = mock(LaboratorioRepository.class);
		service = new DeletaLaboratorioServiceImpl(laboratorioRepository);
	}
	
	@Test
	public void deve_deletar_laboratorio() {
		doNothing().when(laboratorioRepository).delete(anyString());
		service.remover("teste");
	}

}
