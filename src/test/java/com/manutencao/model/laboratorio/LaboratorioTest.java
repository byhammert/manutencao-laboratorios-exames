package com.manutencao.model.laboratorio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.manutencao.model.Status;

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
		
		assertThat(laboratorio.getId()).isNotNull();
		assertThat(laboratorio.getNome()).isEqualTo(novoNome);
		assertThat(laboratorio.getEndereco()).isEqualTo(novoEndereco);
		assertThat(laboratorio.getStatus()).isEqualTo(novoStatus);
	}
	
	@Test
	public void test_toString() {
		final String nome = "Laboratório Teste";
		final String endereco = "Endereço Teste";
		final Status status = Status.ATIVO;
		final List<String> exames = obterExames();
		
		final Laboratorio laboratorio = new Laboratorio(null, nome, endereco, status, exames);
		
		final String valorEsperado = "Laboratorio [id=" + laboratorio.getId() + ", nome=" + nome + ", endereco=" + endereco + ", status=" + status
				+ ", exames=" + exames + "]";
		
		assertThat(laboratorio.toString()).isEqualTo(valorEsperado);
	}
	
	private Laboratorio obterLaboratorioValido() {
		final String nome = "Laboratório Teste";
		final String endereco = "Endereço Teste";
		final Status status = Status.ATIVO;
		final List<String> exames = obterExames();
		
		final Laboratorio laboratorio = new Laboratorio(null, nome, endereco, status, exames);
		
		assertThat(laboratorio.getId()).isNotNull();
		assertThat(laboratorio.getNome()).isEqualTo(nome);
		assertThat(laboratorio.getEndereco()).isEqualTo(endereco);
		assertThat(laboratorio.getStatus()).isEqualTo(status);
		assertThat(laboratorio.getExames()).isNotNull().isNotEmpty();
		
		final String exame = laboratorio.getExames().get(0);
		
		assertThat(exame).isEqualTo("teste");
		
		return laboratorio;
	}
	
	private List<String> obterExames() {
		final List<String> exames = new ArrayList<>();
		exames.add("teste");
		return exames;
	}

}
