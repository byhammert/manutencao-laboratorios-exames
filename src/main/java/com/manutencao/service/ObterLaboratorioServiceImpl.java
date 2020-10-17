package com.manutencao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.Status;
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

	@Override
	public List<Laboratorio> obterLaboratoriosAtivos() {
		return laboratorioRepository.listByStatus(Status.ATIVO);
	}
	
}
