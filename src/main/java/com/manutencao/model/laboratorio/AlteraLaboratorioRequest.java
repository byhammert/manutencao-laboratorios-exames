package com.manutencao.model.laboratorio;

import java.util.List;

import org.springframework.util.StringUtils;

import com.google.common.base.Preconditions;
import com.manutencao.model.Status;

public class AlteraLaboratorioRequest {
	
	private final String id;
	private final String nome;
	private final String endereco;
	private final Status status;
	private final List<String> exames;
	
	public AlteraLaboratorioRequest(String id, String nome, String endereco, Status status, List<String> exames) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.status = status;
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
	
	public String getId() {
		return id;
	}

	public Status getStatus() {
		return status;
	}
	
	public void validarCampos() {
		Preconditions.checkArgument(!StringUtils.isEmpty(id), "ID deve ser informador.");
		Preconditions.checkArgument(!StringUtils.isEmpty(nome), "Nome deve ser informador.");
		Preconditions.checkArgument(null != status, "Status deve ser informador.");
	}

	@Override
	public String toString() {
		return "AlteraLaboratorioRequest [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", status=" + status
				+ ", exames=" + exames + "]";
	}

}
