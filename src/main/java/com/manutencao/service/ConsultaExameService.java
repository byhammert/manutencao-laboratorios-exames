package com.manutencao.service;

import java.util.List;

import com.manutencao.model.exame.Exame;

public interface ConsultaExameService {
	
	Exame obter(String id);
	List<Exame> obterExamesAtivos();

}
