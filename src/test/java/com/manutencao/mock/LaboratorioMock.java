package com.manutencao.mock;

import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.model.laboratorio.LaboratorioBuilder;

public class LaboratorioMock {

	public static Laboratorio obterLaboratorio() {
		final String nome = "Laboratório Teste";
		final String endereco = "Endereço Teste";
		final Status status = Status.ATIVO;
		
		final Laboratorio laboratorio = LaboratorioBuilder.builder()
															.comNome(nome)
															.comEndereco(endereco)
															.comStatus(status)
															.build();
		return laboratorio;
	}
	
}
