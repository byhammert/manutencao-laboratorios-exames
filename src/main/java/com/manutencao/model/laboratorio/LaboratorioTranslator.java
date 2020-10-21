package com.manutencao.model.laboratorio;

import com.manutencao.model.Status;

public class LaboratorioTranslator {
	
	public static Laboratorio translate(CadastroLaboratorioRequest cadastroLaboratorioRequest) {
		return LaboratorioBuilder.builder()
							.comNome(cadastroLaboratorioRequest.getNome())
							.comEndereco(cadastroLaboratorioRequest.getEndereco())
							.comStatus(Status.ATIVO)
							.addAllExame(cadastroLaboratorioRequest.getExames())
							.build();
	}

}
