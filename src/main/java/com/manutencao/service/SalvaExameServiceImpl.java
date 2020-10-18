package com.manutencao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.model.exame.Exame;

@Service
public class SalvaExameServiceImpl implements SalvaExameService {

	private ExameRepository exameRepository;
	
	@Autowired
	public SalvaExameServiceImpl(ExameRepository exameRepository) {
		this.exameRepository = exameRepository;
	}
	
	@Override
	public Exame salvar(Exame exame) {
		Exame exameSalvo = Exame.clone(exame); 
		exameRepository.save(exameSalvo);
		return exameSalvo;
	}

}
