package com.manutencao.model.exame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.model.laboratorio.LaboratorioBuilder;

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
										.addLaboratorio(obterLaboratorio())
										.build();
		
		assertThat(exame).isNotNull();
		assertThat(exame.getNome()).isEqualTo(nome);
		assertThat(exame.getStatus()).isEqualTo(status);
		assertThat(exame.getTipoExame()).isEqualTo(tipoExame);
		assertThat(exame.getLaboratorios()).isNotNull().isNotEmpty();
		
		final Laboratorio laboratorio = exame.getLaboratorios().get(0);
		assertThat(laboratorio.getNome()).isEqualTo("Nome Laboratório");
		assertThat(laboratorio.getEndereco()).isEqualTo("Endereço Laboratório");
		assertThat(laboratorio.getStatus()).isEqualTo(Status.ATIVO);
		assertThat(laboratorio.getExames()).isNotNull().isEmpty();
	}
	
	private Laboratorio obterLaboratorio() {
		final Laboratorio laboratorio = LaboratorioBuilder.builder()
															.comNome("Nome Laboratório")
															.comEndereco("Endereço Laboratório")
															.comStatus(Status.ATIVO)
															.build();
		return laboratorio;
	}

}
