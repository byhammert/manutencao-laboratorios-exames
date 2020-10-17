package com.manutencao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.laboratorio.Laboratorio;

@Service
public class SalvaLaboratorioServiceImpl implements SalvaLaboratorioService {

	private LaboratorioRepository laboratorioRepository;
	
	@Autowired
	public SalvaLaboratorioServiceImpl(LaboratorioRepository laboratorioRepository) {
		this.laboratorioRepository = laboratorioRepository;
	}
	
	@Override
	public Laboratorio salvar(Laboratorio laboratorio) {
		Laboratorio laboratorioSalvo = Laboratorio.clone(laboratorio); 
		laboratorioRepository.save(laboratorioSalvo);
		return laboratorioSalvo;
	}

}
