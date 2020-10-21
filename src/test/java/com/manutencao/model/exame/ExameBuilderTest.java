package com.manutencao.model.exame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.manutencao.model.Status;

public class ExameBuilderTest {
	
	@Test
	public void deve_construir_exame() {
		final String nome = "Exame Teste";
		final TipoExame tipoExame = TipoExame.ANALISE_CLINICA;
		final Status status = Status.ATIVO;
		
		final Exame exame = ExameBuilder.builder()
										.comNome(nome)
										.comStatus(status)
										.comTipoExame(tipoExame)
										.addLaboratorio("teste")
										.build();
		
		assertThat(exame).isNotNull();
		assertThat(exame.getNome()).isEqualTo(nome);
		assertThat(exame.getStatus()).isEqualTo(status);
		assertThat(exame.getTipoExame()).isEqualTo(tipoExame);
		assertThat(exame.getLaboratorios()).isNotNull().isNotEmpty();
		
		final String laboratorio = exame.getLaboratorios().get(0);
		assertThat(laboratorio).isEqualTo("teste");
	}

}
