package com.manutencao.model.laboratorio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.manutencao.model.Status;

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
															.addExame("teste")
															.build();
		
		assertThat(laboratorio).isNotNull();
		assertThat(laboratorio.getNome()).isEqualTo(nome);
		assertThat(laboratorio.getEndereco()).isEqualTo(endereco);
		assertThat(laboratorio.getStatus()).isEqualTo(status);
		assertThat(laboratorio.getExames()).isNotNull().isNotEmpty();
		
		final String exame = laboratorio.getExames().get(0);
		assertThat(exame).isEqualTo("teste");
		
	}
	
	

}
