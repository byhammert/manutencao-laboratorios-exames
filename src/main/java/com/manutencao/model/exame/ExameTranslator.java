package com.manutencao.model.exame;

public class ExameTranslator {
	
	public static Exame translate(CadastroExameRequest cadastroExameRequest) {
		return ExameBuilder.builder()
							.comNome(cadastroExameRequest.getNome())
							.comStatus(cadastroExameRequest.getStatus())
							.comTipoExame(cadastroExameRequest.getTipoExame())
							.addAllLaboratorio(cadastroExameRequest.getLaboratorios())
							.build();
	}

}
