package com.manutencao.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.mock.LaboratorioMock;
import com.manutencao.model.laboratorio.Laboratorio;

public class ObterLaboratorioServiceImplTest {
	private LaboratorioRepository laboratorioRepository;
	private ObterLaboratorioService service;
	
	@BeforeEach
	public void setup() {
		laboratorioRepository = mock(LaboratorioRepository.class);
		service = new ObterLaboratorioServiceImpl(laboratorioRepository);
	}
	
	@Test
	public void deve_obter_laboratorio() {
		Laboratorio laboratorio = LaboratorioMock.obterLaboratorio();
		
		when(laboratorioRepository.getBy(anyString())).thenReturn(laboratorio);
		
		Laboratorio retorno = service.obter("test");
		
		assertThat(retorno).isNotNull();
		assertThat(retorno.toString()).isEqualTo(laboratorio.toString());
	}
	
	
}
