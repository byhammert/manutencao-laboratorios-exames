package com.manutencao.model.laboratorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.manutencao.model.Status;
import com.manutencao.model.exames.Exame;
import com.manutencao.model.exames.TipoExame;

public class LaboratorioTest {
	
	@Test
	public void test_construtor() {
		obterLaboratorioValido();
	}
	
	@Test
	public void test_get_set() {
		final Laboratorio laboratorio = obterLaboratorioValido();
		
		final String novoNome = "Laboratório Teste Set";
		final String novoEndereco = "Endereço Teste Set";
		final Status novoStatus = Status.INATIVO;
		
		laboratorio.setNome(novoNome);
		laboratorio.setEndereco(novoEndereco);
		laboratorio.setStatus(novoStatus);
		
		assertThat(laboratorio.getNome()).isEqualTo(novoNome);
		assertThat(laboratorio.getEndereco()).isEqualTo(novoEndereco);
		assertThat(laboratorio.getStatus()).isEqualTo(novoStatus);
	}
	
	@Test
	public void test_toString() {
		final String nome = "Laboratório Teste";
		final String endereco = "Endereço Teste";
		final Status status = Status.ATIVO;
		final List<Exame> exames = obterExames();
		final String valorEsperado = "Laboratorio [nome=" + nome + ", endereco=" + endereco + ", status=" + status + ", exames=" + exames
				+ "]";
		
		final Laboratorio laboratorio = new Laboratorio(nome, endereco, status, exames);
		
		assertThat(laboratorio.toString()).isEqualTo(valorEsperado);
	}
	
	private Laboratorio obterLaboratorioValido() {
		final String nome = "Laboratório Teste";
		final String endereco = "Endereço Teste";
		final Status status = Status.ATIVO;
		final List<Exame> exames = obterExames();
		
		final Laboratorio laboratorio = new Laboratorio(nome, endereco, status, exames);
		
		assertThat(laboratorio.getNome()).isEqualTo(nome);
		assertThat(laboratorio.getEndereco()).isEqualTo(endereco);
		assertThat(laboratorio.getStatus()).isEqualTo(status);
		assertThat(laboratorio.getExames()).isNotNull().isNotEmpty();
		
		final Exame exame = laboratorio.getExames().get(0);
		
		assertThat(exame.getNome()).isEqualTo("Exame Teste");
		assertThat(exame.getStatus()).isEqualTo(Status.ATIVO);
		assertThat(exame.getTipoExame()).isEqualTo(TipoExame.ANALISE_CLINICA);
		assertThat(exame.getLaboratorios()).isNotNull().isEmpty();
		
		return laboratorio;
	}
	
	private List<Exame> obterExames() {
		final List<Exame> exames = new ArrayList<>();
		exames.add(obterExame());
		return exames;
	}
	
	private Exame obterExame() {
		return new Exame("Exame Teste", TipoExame.ANALISE_CLINICA, Status.ATIVO, new ArrayList<>());
	}

}
