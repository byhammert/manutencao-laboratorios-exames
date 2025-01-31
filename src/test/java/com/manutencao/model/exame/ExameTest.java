package com.manutencao.model.exame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.manutencao.model.Status;

public class ExameTest {
	
	@Test
	public void test_construtor() {
		obterExameValido();
	}
	
	@Test
	public void test_get_set() {		
		final Exame exame = obterExameValido();
		
		final String novoNome = "Exame Teste Set";
		final TipoExame novoTipoExame = TipoExame.IMAGEM;
		final Status novoStatus = Status.INATIVO;
		
		exame.setNome(novoNome);
		exame.setTipoExame(novoTipoExame);
		exame.setStatus(novoStatus);
		
		assertThat(exame.getNome()).isEqualTo(novoNome);
		assertThat(exame.getTipoExame()).isEqualTo(novoTipoExame);
		assertThat(exame.getStatus()).isEqualTo(novoStatus);
	}
	
	@Test
	public void test_toString() {
		final String nome = "Exame Teste";
		final TipoExame tipoExame = TipoExame.ANALISE_CLINICA;
		final Status status = Status.ATIVO;
		final List<String> laboratorios = obterLaboratorios();
		
		final Exame exame = new Exame(null, nome, tipoExame, status, laboratorios);
		final String valorEsperado = "Exame [id=" + exame.getId() + ", nome=" + nome + ", tipoExame=" + tipoExame + ", status=" + status + ", laboratorios="
				+ laboratorios + "]";
		
		assertThat(exame.toString()).isEqualTo(valorEsperado);
	}
	
	private Exame obterExameValido() {
		final String nome = "Exame Teste";
		final TipoExame tipoExame = TipoExame.ANALISE_CLINICA;
		final Status status = Status.ATIVO;
		
		final List<String> laboratorios = obterLaboratorios();
		
		final Exame exame = new Exame(null, nome, tipoExame, status, laboratorios);
		
		assertThat(exame.getNome()).isEqualTo(nome);
		assertThat(exame.getTipoExame()).isEqualTo(tipoExame);
		assertThat(exame.getStatus()).isEqualTo(status);
		assertThat(exame.getLaboratorios()).isNotNull().isNotEmpty();
		
		final String laboratorio = exame.getLaboratorios().get(0);
		
		assertThat(laboratorio).isEqualTo("teste");
		
		return exame;
	}
	
	private List<String> obterLaboratorios() {
		final List<String> laboratorios = new ArrayList<>();
		laboratorios.add("teste");
		return laboratorios;
	}

}
