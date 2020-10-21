package com.manutencao.service.exame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.mock.ExameMock;
import com.manutencao.model.exame.Exame;
import com.manutencao.service.laboratorio.ValidaLaboratorioService;

public class AtualizaExameServiceImplTest {
	
	private ExameRepository exameRepository;
	private AtualizaExameService service;
	private ValidaLaboratorioService validaLaboratorioService;
	
	@BeforeEach
	public void setup() {
		exameRepository = mock(ExameRepository.class);
		validaLaboratorioService = mock(ValidaLaboratorioService.class);
		service = new AtualizaExameServiceImpl(exameRepository, validaLaboratorioService);
	}
	
	@Test
	public void deve_editar_exame() {
		final Exame exame = ExameMock.obterExameAtivo();
		doNothing().when(exameRepository).save(exame);
		when(exameRepository.getBy(anyString())).thenReturn(exame);
		
		final Exame exameAlterado = service.atualizar(exame);
		
		assertThat(exameAlterado).isNotNull();
		assertThat(exameAlterado.toString()).isEqualTo(exame.toString());
	}
	
	@Test
	public void deve_lancar_exception_quando_exame_nao_existe() {
		assertThatThrownBy(() -> {
			service.atualizar(ExameMock.obterExameAtivo());
		})
		.isExactlyInstanceOf(IllegalArgumentException.class);
	}
	
}
