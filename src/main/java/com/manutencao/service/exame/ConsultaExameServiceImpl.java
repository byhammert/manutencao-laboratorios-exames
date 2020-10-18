package com.manutencao.service.exame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;

@Service
public class ConsultaExameServiceImpl implements ConsultaExameService {

	private ExameRepository exameRepository;
	
	@Autowired
	public ConsultaExameServiceImpl(ExameRepository exameRepository) {
		this.exameRepository = exameRepository;
	}
	
	@Override
	public Exame obter(String id) {
		return exameRepository.getBy(id);
	}

	@Override
	public List<Exame> obterExamesAtivos() {
		return exameRepository.listByStatus(Status.ATIVO);
	}
	
}
