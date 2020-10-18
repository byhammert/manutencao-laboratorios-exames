package com.manutencao.model.laboratorio;

public class LaboratorioTranslator {
	
	public static Laboratorio translate(CadastroLaboratorioRequest cadastroLaboratorioRequest) {
		return LaboratorioBuilder.builder()
							.comNome(cadastroLaboratorioRequest.getNome())
							.comStatus(cadastroLaboratorioRequest.getStatus())
							.addAllExame(cadastroLaboratorioRequest.getExames())
							.build();
	}

}
