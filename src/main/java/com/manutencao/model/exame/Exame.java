package com.manutencao.model.exame;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.manutencao.model.Status;
import com.manutencao.util.IDUtil;

public class Exame {
	
	private String id;
	private String nome;
	private TipoExame tipoExame;
	private Status status;
	private List<String> laboratorios;
	
	private Exame() {}
	
	public Exame(String nome, TipoExame tipoExame, Status status, List<String> laboratorios) {
		super();
		this.id = IDUtil.gerarID();
		this.nome = nome;
		this.tipoExame = tipoExame;
		this.status = status;
		this.laboratorios = laboratorios;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public List<String> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<String> laboratorios) {
		this.laboratorios = laboratorios;
	}
	
	public static Exame clone(Exame exame) {
		Exame target = new Exame();
		BeanUtils.copyProperties(exame, target);
		return target;
	}

	@Override
	public String toString() {
		return "Exame [id=" + id + ", nome=" + nome + ", tipoExame=" + tipoExame + ", status=" + status + ", laboratorios="
				+ laboratorios + "]";
	}
	
}
