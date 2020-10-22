package com.manutencao.service.laboratorio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.mock.LaboratorioMock;
import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.service.exame.ValidaExameUsecase;

public class ConsultaLaboratorioUsecaseImplTest {
	private LaboratorioRepository laboratorioRepository;
	private ConsultaLaboratorioUsecase service;
	private ValidaExameUsecase validaExameService;
	
	@BeforeEach
	public void setup() {
		laboratorioRepository = mock(LaboratorioRepository.class);
		validaExameService = mock(ValidaExameUsecase.class);
		service = new ConsultaLaboratorioUsecaseImpl(laboratorioRepository, validaExameService);
	}
	
	@Test
	public void deve_obter_laboratorios_ativos() {
		Laboratorio laboratorio = LaboratorioMock.obterLaboratorioAtivo();
		List<Laboratorio> laboratorios = new ArrayList<>();
		laboratorios.add(laboratorio);
		
		when(laboratorioRepository.listByStatus(Status.ATIVO)).thenReturn(laboratorios);
		
		List<Laboratorio> retorno = service.executar();
		
		assertThat(retorno).isNotNull().isNotEmpty().hasSize(1);
	}
}
