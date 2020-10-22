package com.manutencao.service.exame;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.mock.ExameMock;
import com.manutencao.model.exame.Exame;

public class DeletaExameUsecaseImplTest {
	
	private ExameRepository exameRepository;
	private DeletaExameUsecase service;
	
	@BeforeEach
	public void setup() {	
		exameRepository = mock(ExameRepository.class);
		service = new DeletaExameUsecaseImpl(exameRepository);
	}
	
	@Test
	public void deve_deletar_exame() {
		Exame exame = ExameMock.obterExameAtivo();
		when(exameRepository.getBy(anyString())).thenReturn(exame);
		doNothing().when(exameRepository).delete(anyString());
		service.executar("teste");
	}

}
