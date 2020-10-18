package com.manutencao.service.exame;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.ExameRepository;

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
		doNothing().when(exameRepository).delete(anyString());
		service.remover("teste");
	}

}
