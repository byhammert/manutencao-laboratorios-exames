package com.manutencao.model.exame;

import java.util.List;

import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;

public class Exame {
	
	private String nome;
	private TipoExame tipoExame;
	private Status status;
	private List<Laboratorio> laboratorios;
	
	public Exame(String nome, TipoExame tipoExame, Status status, List<Laboratorio> laboratorios) {
		super();
		this.nome = nome;
		this.tipoExame = tipoExame;
		this.status = status;
		this.laboratorios = laboratorios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoExame getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(TipoExame tipoExame) {
		this.tipoExame = tipoExame;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}

	@Override
	public String toString() {
		return "Exame [nome=" + nome + ", tipoExame=" + tipoExame + ", status=" + status + ", laboratorios="
				+ laboratorios + "]";
	}
	
}
