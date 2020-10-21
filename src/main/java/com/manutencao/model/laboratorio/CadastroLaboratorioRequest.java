package com.manutencao.model.laboratorio;

import java.util.List;

public class CadastroLaboratorioRequest {
	
	private String nome;
	private String endereco;
	private List<String> exames;
	
	public CadastroLaboratorioRequest(String nome, String endereco,List<String> exames) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.exames = exames;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<String> getExames() {
		return exames;
	}

	public void setExames(List<String> exames) {
		this.exames = exames;
	}

	@Override
	public String toString() {
		return "CadastroLaboratorioRequest [nome=" + nome + ", endereco=" + endereco + ", exames=" + exames + "]";
	}
	
}
