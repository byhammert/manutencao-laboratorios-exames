package com.manutencao.service.exame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.mock.ExameMock;
import com.manutencao.model.exame.Exame;

public class CadastroExameServiceImplTest {
	
	private ExameRepository exameRepository;
	private CadastroExameService service;
	
	@BeforeEach
	public void setup() {
		exameRepository = mock(ExameRepository.class);
		service = new CadastroExameServiceImpl(exameRepository);
	}
	
	@Test
	public void deve_cadastrar_exame() {
		final Exame exame = ExameMock.obterExame();
		doNothing().when(exameRepository).save(exame);
		final Exame exameSalvo = service.salvar(exame);
		
		assertThat(exameSalvo).isNotNull();
		assertThat(exameSalvo.toString()).isEqualTo(exame.toString());
	}
	
}
