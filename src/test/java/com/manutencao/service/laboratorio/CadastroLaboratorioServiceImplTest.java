package com.manutencao.service.laboratorio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.mock.LaboratorioMock;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.service.exame.ValidaExameService;

public class CadastroLaboratorioServiceImplTest {
	
	private LaboratorioRepository laboratorioRepository;
	private CadastroLaboratorioService service;
	private ValidaExameService validaExameService;
	
	@BeforeEach
	public void setup() {
		laboratorioRepository = mock(LaboratorioRepository.class);
		validaExameService = mock(ValidaExameService.class);
		service = new CadastroLaboratorioServiceImpl(laboratorioRepository, validaExameService);
	}
	
	@Test
	public void deve_cadastrar_laboratorio() {
		final Laboratorio laboratorio = LaboratorioMock.obterLaboratorioAtivo();
		doNothing().when(laboratorioRepository).save(laboratorio);
		final Laboratorio laboratorioSalvo = service.salvar(laboratorio);
		
		assertThat(laboratorioSalvo).isNotNull();
		assertThat(laboratorioSalvo.toString()).isEqualTo(laboratorio.toString());
	}

}
