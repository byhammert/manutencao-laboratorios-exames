package com.manutencao.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.laboratorio.Laboratorio;

public class ObterLaboratorioServiceImpl implements ObterLaboratorioService {

	private LaboratorioRepository laboratorioRepository;
	
	@Autowired
	public ObterLaboratorioServiceImpl(LaboratorioRepository laboratorioRepository) {
		this.laboratorioRepository = laboratorioRepository;
	}
	
	@Override
	public Laboratorio obter(String id) {
		return laboratorioRepository.getBy(id);
	}

}
