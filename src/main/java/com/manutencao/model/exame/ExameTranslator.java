package com.manutencao.model.exame;

import com.manutencao.model.Status;

public class ExameTranslator {
	
	public static Exame translate(CadastroExameRequest cadastroExameRequest) {
		return ExameBuilder.builder()
							.comNome(cadastroExameRequest.getNome())
							.comStatus(Status.ATIVO)
							.comTipoExame(cadastroExameRequest.getTipoExame())
							.addAllLaboratorio(cadastroExameRequest.getLaboratorios())
							.build();
	}

}
