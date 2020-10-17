package com.manutencao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.util.IDUtil;

@Service
public class CadastroLaboratorioServiceImpl implements CadastroLaboratorioService {

	private LaboratorioRepository laboratorioRepository;
	
	@Autowired
	public CadastroLaboratorioServiceImpl(LaboratorioRepository laboratorioRepository) {
		this.laboratorioRepository = laboratorioRepository;
	}
	
	@Override
	public Laboratorio cadastrar(Laboratorio laboratorio) {
		laboratorio.setId(IDUtil.gerarID());
		laboratorioRepository.save(laboratorio);
		return laboratorio;
	}

}
