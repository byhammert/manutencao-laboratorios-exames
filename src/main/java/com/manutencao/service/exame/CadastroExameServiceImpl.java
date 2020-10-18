package com.manutencao.service.exame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.model.exame.Exame;

@Service
public class CadastroExameServiceImpl implements CadastroExameService {

	private ExameRepository exameRepository;
	
	@Autowired
	public CadastroExameServiceImpl(ExameRepository exameRepository) {
		this.exameRepository = exameRepository;
	}
	
	@Override
	public Exame salvar(Exame exame) {
		Exame exameSalvo = Exame.clone(exame); 
		exameRepository.save(exameSalvo);
		return exameSalvo;
	}

}
