package com.manutencao.mock;

import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;
import com.manutencao.model.exame.ExameBuilder;
import com.manutencao.model.exame.TipoExame;

public class ExameMock {
	
	public static Exame obterExame() {
		final Exame exame = ExameBuilder.builder()
										.comNome("Nome Exame")
										.comStatus(Status.ATIVO)
										.comTipoExame(TipoExame.IMAGEM)
										.build();
		return exame;
	}

}
