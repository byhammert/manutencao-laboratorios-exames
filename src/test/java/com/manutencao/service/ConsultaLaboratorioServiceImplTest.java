package com.manutencao.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.mock.LaboratorioMock;
import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;

public class ConsultaLaboratorioServiceImplTest {
	private LaboratorioRepository laboratorioRepository;
	private ConsultaLaboratorioService service;
	
	@BeforeEach
	public void setup() {
		laboratorioRepository = mock(LaboratorioRepository.class);
		service = new ConsultaLaboratorioServiceImpl(laboratorioRepository);
	}
	
	@Test
	public void deve_obter_laboratorio() {
		Laboratorio laboratorio = LaboratorioMock.obterLaboratorio();
		
		when(laboratorioRepository.getBy(anyString())).thenReturn(laboratorio);
		
		Laboratorio retorno = service.obter("test");
		
		assertThat(retorno).isNotNull();
		assertThat(retorno.toString()).isEqualTo(laboratorio.toString());
	}
	
	@Test
	public void deve_obter_laboratorios_ativos() {
		Laboratorio laboratorio = LaboratorioMock.obterLaboratorio();
		List<Laboratorio> laboratorios = new ArrayList<>();
		laboratorios.add(laboratorio);
		
		when(laboratorioRepository.listByStatus(Status.ATIVO)).thenReturn(laboratorios);
		
		List<Laboratorio> retorno = service.obterLaboratoriosAtivos();
		
		assertThat(retorno).isNotNull().isNotEmpty().hasSize(1);
	}
	
	
}
