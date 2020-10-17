package com.manutencao.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.mock.LaboratorioMock;
import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;

public class SalvaLaboratorioServiceImplTest {
	
	private LaboratorioRepository laboratorioRepository;
	private SalvaLaboratorioService service;
	
	@BeforeEach
	public void setup() {
		laboratorioRepository = mock(LaboratorioRepository.class);
		service = new SalvaLaboratorioServiceImpl(laboratorioRepository);
	}
	
	@Test
	public void deve_cadastrar_laboratorio() {
		final Laboratorio laboratorio = LaboratorioMock.obterLaboratorio();
		doNothing().when(laboratorioRepository).save(laboratorio);
		final Laboratorio laboratorioSalvo = service.salvar(laboratorio);
		
		assertThat(laboratorioSalvo).isNotNull();
		assertThat(laboratorioSalvo.toString()).isEqualTo(laboratorio.toString());
	}
	
	@Test
	public void deve_editar_laboratorio() {
		final Laboratorio laboratorio = LaboratorioMock.obterLaboratorio();
		doNothing().when(laboratorioRepository).save(laboratorio);
		final Laboratorio laboratorioSalvo = service.salvar(laboratorio);
		
		assertThat(laboratorioSalvo).isNotNull();
		assertThat(laboratorioSalvo.toString()).isEqualTo(laboratorio.toString());
		
		laboratorio.setStatus(Status.INATIVO);
		final Laboratorio laboratorioAlterado = service.salvar(laboratorio);
		
		assertThat(laboratorioAlterado).isNotNull();
		assertThat(laboratorioAlterado.toString()).isNotEqualTo(laboratorioSalvo.toString());
	}

}
