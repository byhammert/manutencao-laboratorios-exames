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

public class ValidaLaboratorioServiceImplTest {
	
	private LaboratorioRepository laboratorioRepository;
	private ValidaLaboratorioService validaLaboratorioService;
	
	@BeforeEach
	public void setup() {
		laboratorioRepository = mock(LaboratorioRepository.class);
		validaLaboratorioService = new ValidaLaboratorioServiceImpl(laboratorioRepository);
	}
	
	@Test
	public void deve_obter_laboratorios_validos_e_ativos() {
		Laboratorio laboratorioValido = LaboratorioMock.obterLaboratorioAtivo();
		Laboratorio laboratorioInativo = LaboratorioMock.obterLaboratorioInativo();
		Laboratorio laboratorioIvalido = LaboratorioMock.obterLaboratorioInativo();
		Laboratorio laboratorioValidoNaBase = LaboratorioMock.obterLaboratorioAtivo();
			
		List<Laboratorio> laboratoriosDaBase = new ArrayList<>();
		laboratoriosDaBase.add(laboratorioValido);
		laboratoriosDaBase.add(laboratorioValidoNaBase);
		
		List<String> laboratoriosParam = new ArrayList<>();
		laboratoriosParam.add(laboratorioValido.getId());
		laboratoriosParam.add(laboratorioInativo.getId());
		laboratoriosParam.add(laboratorioIvalido.getId());
		
		when(laboratorioRepository.listByStatus(Status.ATIVO)).thenReturn(laboratoriosDaBase);
		
		List<String> retorno = validaLaboratorioService.obterLaboratoriosValidos(laboratoriosParam);
		
		assertThat(retorno).isNotNull().isNotEmpty().hasSize(1);
		assertThat(retorno.get(0)).isEqualTo(laboratorioValido.getId());
	}

}
