package com.manutencao.model.exame;

import java.util.List;

import com.manutencao.model.Status;

public class CadastroExameRequest {
	
	private String nome;
	private TipoExame tipoExame;
	private List<String> laboratorios;
	
	public CadastroExameRequest(String nome, TipoExame tipoExame, Status status, List<String> laboratorios) {
		super();
		this.nome = nome;
		this.tipoExame = tipoExame;
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

	public List<String> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<String> laboratorios) {
		this.laboratorios = laboratorios;
	}

	@Override
	public String toString() {
		return "CadastroExameRequest [nome=" + nome + ", tipoExame=" + tipoExame + ", laboratorios=" + laboratorios + "]";
	}
	
}
