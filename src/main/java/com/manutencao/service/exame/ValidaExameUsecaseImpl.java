package com.manutencao.service.exame;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;

@Service
public class ValidaExameUsecaseImpl implements ValidaExameUsecase {
	
	private ExameRepository exameRepository;
	
	public ValidaExameUsecaseImpl(ExameRepository exameRepository) {
		this.exameRepository = exameRepository;
	}
	
	public List<String> executar(List<String> exames) {
		List<Exame> examesAtivos = exameRepository.listByStatus(Status.ATIVO);
		return examesAtivos.stream()
						   .flatMap(exameAtivo -> exames.stream()
														.filter(exame -> exame.equals(exameAtivo.getId())))
						   .collect(Collectors.toList());
	}

}
