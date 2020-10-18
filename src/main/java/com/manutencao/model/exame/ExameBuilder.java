package com.manutencao.model.exame;

import java.util.ArrayList;
import java.util.List;

import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;

public class ExameBuilder {
	
	private String nome;
	private TipoExame tipoExame;
	private Status status;
	private List<Laboratorio> laboratorios = new ArrayList<>();
	
	private ExameBuilder() {}
	
	public static ExameBuilder builder() {
		return new ExameBuilder();
	}
	
	public ExameBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public ExameBuilder comTipoExame(TipoExame tipoExame) {
		this.tipoExame = tipoExame;
		return this;
	}
	
	public ExameBuilder comStatus(Status status) {
		this.status = status;
		return this;
	}
	
	public ExameBuilder addLaboratorio(Laboratorio laboratorio) {
		this.laboratorios.add(laboratorio);
		return this;
	}
	
	public ExameBuilder addAllLaboratorio(List<Laboratorio> laboratorios) {
		this.laboratorios.addAll(laboratorios);
		return this;
	}
	
	public Exame build() {
		return new Exame(nome, tipoExame, status, laboratorios);
	}

}
