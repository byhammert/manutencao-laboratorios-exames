package com.manutencao.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.mock.ExameMock;
import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;

public class SalvaExameServiceImplTest {
	
	private ExameRepository exameRepository;
	private SalvaExameService service;
	
	@BeforeEach
	public void setup() {
		exameRepository = mock(ExameRepository.class);
		service = new SalvaExameServiceImpl(exameRepository);
	}
	
	@Test
	public void deve_cadastrar_exame() {
		final Exame exame = ExameMock.obterExame();
		doNothing().when(exameRepository).save(exame);
		final Exame exameSalvo = service.salvar(exame);
		
		assertThat(exameSalvo).isNotNull();
		assertThat(exameSalvo.toString()).isEqualTo(exame.toString());
	}
	
	@Test
	public void deve_editar_exame() {
		final Exame exame = ExameMock.obterExame();
		doNothing().when(exameRepository).save(exame);
		final Exame exameSalvo = service.salvar(exame);
		
		assertThat(exameSalvo).isNotNull();
		assertThat(exameSalvo.toString()).isEqualTo(exame.toString());
		
		exame.setStatus(Status.INATIVO);
		final Exame exameAlterado = service.salvar(exame);
		
		assertThat(exameAlterado).isNotNull();
		assertThat(exameAlterado.toString()).isNotEqualTo(exameSalvo.toString());
	}
}
