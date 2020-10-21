package com.manutencao.service.exame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;
import com.manutencao.service.laboratorio.ValidaLaboratorioService;

@Service
public class ConsultaExameServiceImpl implements ConsultaExameService {

	private ExameRepository exameRepository;
	private ValidaLaboratorioService validaLaboratorioService;
	
	@Autowired
	public ConsultaExameServiceImpl(ExameRepository exameRepository,
			ValidaLaboratorioService validaLaboratorioService) {
		this.exameRepository = exameRepository;
		this.validaLaboratorioService = validaLaboratorioService;
	}
	
	@Override
	public Exame obter(String id) {
		Exame exame = exameRepository.getBy(id);
		exame.setLaboratorios(validaLaboratorioService.obterLaboratoriosValidos(exame.getLaboratorios()));
		return exame;
	}

	@Override
	public List<Exame> obterExamesAtivos() {
		List<Exame> exames = exameRepository.listByStatus(Status.ATIVO);
		exames.forEach(exame -> exame.setLaboratorios(validaLaboratorioService.obterLaboratoriosValidos(exame.getLaboratorios())));
		return exames;
	}
	
}
