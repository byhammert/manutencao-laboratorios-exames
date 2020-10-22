package com.manutencao.service.laboratorio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.exceptionhandler.NotFoundExcetion;
import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.mock.LaboratorioMock;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.service.exame.ValidaExameUsecase;

public class AtualizaLaboratorioUsecaseImplTest {
	
	private LaboratorioRepository laboratorioRepository;
	private AtualizaLaboratorioUsecase service;
	private ValidaExameUsecase validaExameService;
	
	@BeforeEach
	public void setup() {
		laboratorioRepository = mock(LaboratorioRepository.class);
		validaExameService = mock(ValidaExameUsecase.class);
		service = new AtualizaLaboratorioUsecaseImpl(laboratorioRepository, validaExameService);
	}
	
	@Test
	public void deve_editar_laboratorio() {
		final Laboratorio laboratorio = LaboratorioMock.obterLaboratorioAtivo();
		doNothing().when(laboratorioRepository).save(laboratorio);
		when(laboratorioRepository.getBy(anyString())).thenReturn(laboratorio);
		
		final Laboratorio laboratorioAlterado = service.executar(laboratorio);
		
		assertThat(laboratorioAlterado).isNotNull();
		assertThat(laboratorioAlterado.toString()).isEqualTo(laboratorio.toString());
	}
	
	@Test
	public void deve_lancar_exception_quando_laboratorio_nao_existe() {
		assertThatThrownBy(() -> {
			service.executar(LaboratorioMock.obterLaboratorioInativo());
		})
		.isExactlyInstanceOf(NotFoundExcetion.class);
	}
	
}
