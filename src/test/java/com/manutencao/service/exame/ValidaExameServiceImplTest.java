package com.manutencao.service.exame;

import static org.assertj.core.api.Assertions.assertThat;
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

public class ValidaExameServiceImplTest {
	
	private ExameRepository exameRepository;
	private ValidaExameService exameService;
	
	@BeforeEach
	public void setup() {
		exameRepository = mock(ExameRepository.class);
		exameService = new ValidaExameServiceImpl(exameRepository);
	}
	
	@Test
	public void deve_obter_exames_validos_e_ativos() {
		Exame exameValido = ExameMock.obterExameAtivo();
		Exame exameInativo = ExameMock.obterExameInativo();
		Exame exameIvalido = ExameMock.obterExameInativo();
		Exame exameValidoNaBase = ExameMock.obterExameAtivo();
			
		List<Exame> examesDaBase = new ArrayList<>();
		examesDaBase.add(exameValido);
		examesDaBase.add(exameValidoNaBase);
		
		List<String> examesParam = new ArrayList<>();
		examesParam.add(exameValido.getId());
		examesParam.add(exameInativo.getId());
		examesParam.add(exameIvalido.getId());
		
		when(exameRepository.listByStatus(Status.ATIVO)).thenReturn(examesDaBase);
		
		List<String> retorno = exameService.obterExamesValidos(examesParam);
		
		assertThat(retorno).isNotNull().isNotEmpty().hasSize(1);
		assertThat(retorno.get(0).toString()).isEqualTo(exameValido.getId());
	}	

}
