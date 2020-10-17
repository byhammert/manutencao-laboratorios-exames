package com.manutencao.model.exame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;

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
		final List<Laboratorio> laboratorios = obterLaboratorios();
		
		final String valorEsperado = "Exame [nome=" + nome + ", tipoExame=" + tipoExame + ", status=" + status + ", laboratorios="
				+ laboratorios + "]";
		
		final Exame exame = new Exame(nome, tipoExame, status, laboratorios);
		
		assertThat(exame.toString()).isEqualTo(valorEsperado);
	}
	
	private Exame obterExameValido() {
		final String nome = "Exame Teste";
		final TipoExame tipoExame = TipoExame.ANALISE_CLINICA;
		final Status status = Status.ATIVO;
		
		final List<Laboratorio> laboratorios = obterLaboratorios();
		
		final Exame exame = new Exame(nome, tipoExame, status, laboratorios);
		
		assertThat(exame.getNome()).isEqualTo(nome);
		assertThat(exame.getTipoExame()).isEqualTo(tipoExame);
		assertThat(exame.getStatus()).isEqualTo(status);
		assertThat(exame.getLaboratorios()).isNotNull().isNotEmpty();
		
		final Laboratorio laboratorio = exame.getLaboratorios().get(0);
		
		assertThat(laboratorio.getNome()).isEqualTo("Laboratório Teste");
		assertThat(laboratorio.getEndereco()).isEqualTo("Endereço Laboratório");
		assertThat(laboratorio.getStatus()).isEqualTo(Status.ATIVO);
		assertThat(laboratorio.getExames()).isNotNull().isEmpty();
		
		return exame;
	}
	
	private List<Laboratorio> obterLaboratorios() {
		final List<Laboratorio> laboratorios = new ArrayList<>();
		laboratorios.add(obterLaboratorio());
		return laboratorios;
	}
	
	private Laboratorio obterLaboratorio() {
		return new Laboratorio("Laboratório Teste", "Endereço Laboratório", Status.ATIVO, new ArrayList<>());
	}

}
