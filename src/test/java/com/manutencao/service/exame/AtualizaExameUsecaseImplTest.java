package com.manutencao.service.exame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.exceptionhandler.NotFoundExcetion;
import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.mock.ExameMock;
import com.manutencao.model.exame.Exame;
import com.manutencao.service.laboratorio.ValidaLaboratorioUsecase;

public class AtualizaExameUsecaseImplTest {
	
	private ExameRepository exameRepository;
	private AtualizaExameUsecase service;
	private ValidaLaboratorioUsecase validaLaboratorioService;
	
	@BeforeEach
	public void setup() {
		exameRepository = mock(ExameRepository.class);
		validaLaboratorioService = mock(ValidaLaboratorioUsecase.class);
		service = new AtualizaExameUsecaseImpl(exameRepository, validaLaboratorioService);
	}
	
	@Test
	public void deve_editar_exame() {
		final Exame exame = ExameMock.obterExameAtivo();
		doNothing().when(exameRepository).save(exame);
		when(exameRepository.getBy(anyString())).thenReturn(exame);
		
		final Exame exameAlterado = service.executar(exame);
		
		assertThat(exameAlterado).isNotNull();
		assertThat(exameAlterado.toString()).isEqualTo(exame.toString());
	}
	
	@Test
	public void deve_lancar_exception_quando_exame_nao_existe() {
		assertThatThrownBy(() -> {
			Exame exame = ExameMock.obterExameInativo();
			service.executar(exame);
		})
		.isExactlyInstanceOf(NotFoundExcetion.class);
	}
	
}
