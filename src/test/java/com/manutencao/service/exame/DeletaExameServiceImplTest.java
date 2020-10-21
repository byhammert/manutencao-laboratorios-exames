package com.manutencao.service.exame;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.mock.ExameMock;
import com.manutencao.model.exame.Exame;

public class DeletaExameServiceImplTest {
	
	private ExameRepository exameRepository;
	private DeletaExameService service;
	
	@BeforeEach
	public void setup() {	
		exameRepository = mock(ExameRepository.class);
		service = new DeletaExameServiceImpl(exameRepository);
	}
	
	@Test
	public void deve_deletar_exame() {
		Exame exame = ExameMock.obterExameAtivo();
		when(exameRepository.getBy(anyString())).thenReturn(exame);
		doNothing().when(exameRepository).delete(anyString());
		service.remover("teste");
	}

}
