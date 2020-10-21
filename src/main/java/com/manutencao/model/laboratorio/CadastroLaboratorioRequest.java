package com.manutencao.model.laboratorio;

import java.util.List;

import org.springframework.util.StringUtils;

import com.google.common.base.Preconditions;

public class CadastroLaboratorioRequest {
	
	private final String nome;
	private final String endereco;
	private final List<String> exames;
	
	public CadastroLaboratorioRequest(String nome, String endereco, List<String> exames) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.exames = exames;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public List<String> getExames() {
		return exames;
	}
	
	public void validarCampos() {
		Preconditions.checkArgument(!StringUtils.isEmpty(nome), "Nome deve ser informador.");
	}

	@Override
	public String toString() {
		return "CadastroLaboratorioRequest [nome=" + nome + ", endereco=" + endereco + ", exames=" + exames + "]";
	}
	
}
