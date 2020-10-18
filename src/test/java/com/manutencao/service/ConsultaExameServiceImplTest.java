package com.manutencao.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.mock.ExameMock;
import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;

public class ConsultaExameServiceImplTest {
	private ExameRepository exameRepository;
	private ConsultaExameService service;
	
	@BeforeEach
	public void setup() {	
		exameRepository = mock(ExameRepository.class);
		service = new ConsultaExameServiceImpl(exameRepository);
	}
	
	@Test
	public void deve_obter_exame() {
		Exame exame = ExameMock.obterExame();
		
		when(exameRepository.getBy(anyString())).thenReturn(exame);
		
		Exame retorno = service.obter("test");
		
		assertThat(retorno).isNotNull();
		assertThat(retorno.toString()).isEqualTo(exame.toString());
	}
	
	@Test
	public void deve_obter_exames_ativos() {
		Exame exame = ExameMock.obterExame();
		List<Exame> exames = new ArrayList<>();
		exames.add(exame);
		
		when(exameRepository.listByStatus(Status.ATIVO)).thenReturn(exames);
		
		List<Exame> retorno = service.obterExamesAtivos();
		
		assertThat(retorno).isNotNull().isNotEmpty().hasSize(1);
	}
	
	
}
