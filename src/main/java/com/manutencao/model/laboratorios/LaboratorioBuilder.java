package com.manutencao.model.laboratorios;

import java.util.ArrayList;
import java.util.List;

import com.manutencao.model.Status;
import com.manutencao.model.exames.Exame;

public class LaboratorioBuilder {
	
	private String nome;
	private String endereco;
	private Status status;
	private List<Exame> exames = new ArrayList<>();
	
	private LaboratorioBuilder() {}
	
	public static LaboratorioBuilder builder() {
		return new LaboratorioBuilder();
	}
	
	public LaboratorioBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public LaboratorioBuilder comEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}
	
	public LaboratorioBuilder comStatus(Status status) {
		this.status = status;
		return this;
	}
	
	public LaboratorioBuilder addExame(Exame exame) {
		this.exames.add(exame);
		return this;
	}
	
	public Laboratorio build() {
		return new Laboratorio(nome, endereco, status, exames);
	}
}
