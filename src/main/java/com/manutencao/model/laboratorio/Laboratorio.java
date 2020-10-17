package com.manutencao.model.laboratorio;

import java.util.List;

import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;
import com.manutencao.util.IDUtil;

public class Laboratorio {
	
	private final String id;
	private String nome;
	private String endereco;
	private Status status;
	private List<Exame> exames;
	
	public Laboratorio(String nome, String endereco, Status status, List<Exame> exames) {
		super();
		this.id = IDUtil.gerarID();
		this.nome = nome;
		this.endereco = endereco;
		this.status = status;
		this.exames = exames;
	}
	
	public String getId() {
		return id;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	@Override
	public String toString() {
		return "Laboratorio [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", status=" + status
				+ ", exames=" + exames + "]";
	}

}
