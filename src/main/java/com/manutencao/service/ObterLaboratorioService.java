package com.manutencao.service;

import java.util.List;

import com.manutencao.model.laboratorio.Laboratorio;

public interface ObterLaboratorioService {
	
	Laboratorio obter(String id);
	List<Laboratorio> obterLaboratoriosAtivos();

}
