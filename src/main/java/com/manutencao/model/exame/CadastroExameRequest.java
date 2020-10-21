package com.manutencao.model.exame;

import java.util.List;

import org.springframework.util.StringUtils;

import com.google.common.base.Preconditions;

public class CadastroExameRequest {
	
	private final String nome;
	private final TipoExame tipoExame;
	private final List<String> laboratorios;
	
	public CadastroExameRequest(String nome, TipoExame tipoExame, List<String> laboratorios) {
		super();
		this.nome = nome;
		this.tipoExame = tipoExame;
		this.laboratorios = laboratorios;
	}

	public String getNome() {
		return nome;
	}

	public TipoExame getTipoExame() {
		return tipoExame;
	}

	public List<String> getLaboratorios() {
		return laboratorios;
	}

	public void validarCampos() {
		Preconditions.checkArgument(!StringUtils.isEmpty(nome), "Nome deve ser informador.");
		Preconditions.checkArgument(tipoExame != null, "TipoExame deve ser informador.");
	}
	
	@Override
	public String toString() {
		return "CadastroExameRequest [nome=" + nome + ", tipoExame=" + tipoExame + ", laboratorios=" + laboratorios + "]";
	}
	
}
