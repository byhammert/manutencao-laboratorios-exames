package com.manutencao.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.mock.LaboratorioMock;
import com.manutencao.model.laboratorio.Laboratorio;

public class CadastroLaboratorioServiceImplTest {
	
	private LaboratorioRepository laboratorioRepository;
	private CadastroLaboratorioService service;
	
	@BeforeEach
	public void setup() {
		laboratorioRepository = mock(LaboratorioRepository.class);
		service = new CadastroLaboratorioServiceImpl(laboratorioRepository);
	}
	
	@Test
	public void deve_salva_laboratorio() {
		final Laboratorio laboratorio = LaboratorioMock.obterLaboratorio();
		doNothing().when(laboratorioRepository).save(laboratorio);
		final Laboratorio laboratorioSalvo = service.cadastrar(laboratorio);
		
		assertThat(laboratorioSalvo).isNotNull();
		assertThat(laboratorioSalvo.toString()).isEqualTo(laboratorio.toString());
	}

}
