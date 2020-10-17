package com.manutencao.model.laboratorio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.manutencao.mock.ExameMock;
import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;
import com.manutencao.model.exame.TipoExame;

public class LaboratorioBuilderTest {
	
	@Test
	public void deve_construir_laboratorio() {
		final String nome = "Laboratório Teste";
		final String endereco = "Endereço Teste";
		final Status status = Status.ATIVO;
		
		final Laboratorio laboratorio = LaboratorioBuilder.builder()
															.comNome(nome)
															.comEndereco(endereco)
															.comStatus(status)
															.addExame(ExameMock.obterExame())
															.build();
		
		assertThat(laboratorio).isNotNull();
		assertThat(laboratorio.getNome()).isEqualTo(nome);
		assertThat(laboratorio.getEndereco()).isEqualTo(endereco);
		assertThat(laboratorio.getStatus()).isEqualTo(status);
		assertThat(laboratorio.getExames()).isNotNull().isNotEmpty();
		
		final Exame exame = laboratorio.getExames().get(0);
		assertThat(exame.getNome()).isEqualTo("Nome Exame");
		assertThat(exame.getStatus()).isEqualTo(Status.ATIVO);
		assertThat(exame.getTipoExame()).isEqualTo(TipoExame.IMAGEM);
		assertThat(exame.getLaboratorios()).isNotNull().isEmpty();
		
	}
	
	

}
