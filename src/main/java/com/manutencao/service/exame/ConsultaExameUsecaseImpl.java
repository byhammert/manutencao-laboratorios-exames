package com.manutencao.service.exame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;
import com.manutencao.service.laboratorio.ValidaLaboratorioUsecase;

@Service
public class ConsultaExameUsecaseImpl implements ConsultaExameUsecase {

	private ExameRepository exameRepository;
	private ValidaLaboratorioUsecase validaLaboratorioService;
	
	@Autowired
	public ConsultaExameUsecaseImpl(ExameRepository exameRepository,
			ValidaLaboratorioUsecase validaLaboratorioService) {
		this.exameRepository = exameRepository;
		this.validaLaboratorioService = validaLaboratorioService;
	}

	@Override
	public List<Exame> executar() {
		List<Exame> exames = exameRepository.listByStatus(Status.ATIVO);
		exames.forEach(exame -> exame.setLaboratorios(validaLaboratorioService.executar(exame.getLaboratorios())));
		return exames;
	}
	
}
