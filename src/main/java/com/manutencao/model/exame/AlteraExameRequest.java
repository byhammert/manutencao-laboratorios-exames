package com.manutencao.model.exame;

import java.util.List;

import org.springframework.util.StringUtils;

import com.google.common.base.Preconditions;
import com.manutencao.model.Status;

public class AlteraExameRequest {

	private final String id;
	private final String nome;
	private final TipoExame tipoExame;
	private final Status status;
	private final List<String> laboratorios;
	
	public AlteraExameRequest(String id, String nome, TipoExame tipoExame, Status status, List<String> laboratorios) {
		super();		
		this.id = id;
		this.nome = nome;
		this.tipoExame = tipoExame;
		this.status = status;
		this.laboratorios = laboratorios;
	}
	
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public TipoExame getTipoExame() {
		return tipoExame;
	}
	public Status getStatus() {
		return status;
	}
	public List<String> getLaboratorios() {
		return laboratorios;
	}
	
	public void validarCampos() {
		Preconditions.checkArgument(!StringUtils.isEmpty(id), "ID deve ser informador.");
		Preconditions.checkArgument(!StringUtils.isEmpty(nome), "Nome deve ser informador.");
		Preconditions.checkArgument(null != tipoExame, "TipoExame deve ser informador.");
		Preconditions.checkArgument(null != status, "Status deve ser informador.");
	}
	
	@Override
	public String toString() {
		return "AlterarExameRequest [id=" + id + ", nome=" + nome + ", tipoExame=" + tipoExame + ", status=" + status
				+ ", laboratorios=" + laboratorios + "]";
	}
	
}
