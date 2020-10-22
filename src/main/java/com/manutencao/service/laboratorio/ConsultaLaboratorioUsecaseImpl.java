package com.manutencao.service.laboratorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.service.exame.ValidaExameUsecase;

@Service
public class ConsultaLaboratorioUsecaseImpl implements ConsultaLaboratorioUsecase {

	private LaboratorioRepository laboratorioRepository;
	private ValidaExameUsecase validaExameService;
	
	@Autowired
	public ConsultaLaboratorioUsecaseImpl(LaboratorioRepository laboratorioRepository,
			ValidaExameUsecase validaExameService) {
		this.laboratorioRepository = laboratorioRepository;
		this.validaExameService = validaExameService;
	}

	@Override
	public List<Laboratorio> executar() {
		List<Laboratorio> laboratorios = laboratorioRepository.listByStatus(Status.ATIVO);
		laboratorios.forEach(laboratorio -> laboratorio.setExames(validaExameService.executar(laboratorio.getExames())));
		return laboratorios;
	}
	
}
