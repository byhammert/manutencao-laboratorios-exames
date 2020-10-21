package com.manutencao.service.exame;

import java.util.List;

public interface ValidaExameService {
	
	List<String> obterExamesValidos(List<String> exames);
	
}
