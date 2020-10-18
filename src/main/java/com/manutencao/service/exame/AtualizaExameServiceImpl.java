package com.manutencao.service.exame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.model.exame.Exame;

@Service
public class AtualizaExameServiceImpl implements AtualizaExameService {
	
	private ExameRepository exameRepository;
	
	@Autowired
	public AtualizaExameServiceImpl(ExameRepository exameRepository) {
		this.exameRepository = exameRepository;
	}

	@Override
	public Exame atualizar(Exame exame) {
		verificarExameExistente(exame.getId());
		Exame exameSalvo = Exame.clone(exame); 
		exameRepository.save(exameSalvo);
		return exameSalvo;
	}
	
	private void verificarExameExistente(String id) {
		Exame exame = exameRepository.getBy(id);
		if (null == exame) {
			throw new IllegalArgumentException();
		}
	}

}
