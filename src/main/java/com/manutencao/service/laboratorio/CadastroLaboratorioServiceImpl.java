package com.manutencao.service.laboratorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.laboratorio.Laboratorio;

@Service
public class CadastroLaboratorioServiceImpl implements CadastroLaboratorioService {

	private LaboratorioRepository laboratorioRepository;
	
	@Autowired
	public CadastroLaboratorioServiceImpl(LaboratorioRepository laboratorioRepository) {
		this.laboratorioRepository = laboratorioRepository;
	}
	
	@Override
	public Laboratorio salvar(Laboratorio laboratorio) {
		Laboratorio laboratorioSalvo = Laboratorio.clone(laboratorio); 
		laboratorioRepository.save(laboratorioSalvo);
		return laboratorioSalvo;
	}

}
