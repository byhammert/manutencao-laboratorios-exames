package com.manutencao.service.laboratorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.service.exame.ValidaExameService;

@Service
public class ConsultaLaboratorioServiceImpl implements ConsultaLaboratorioService {

	private LaboratorioRepository laboratorioRepository;
	private ValidaExameService validaExameService;
	
	@Autowired
	public ConsultaLaboratorioServiceImpl(LaboratorioRepository laboratorioRepository,
			ValidaExameService validaExameService) {
		this.laboratorioRepository = laboratorioRepository;
		this.validaExameService = validaExameService;
	}
	
	@Override
	public Laboratorio obter(String id) {
		Laboratorio laboratorio = laboratorioRepository.getBy(id);
		laboratorio.setExames(validaExameService.obterExamesValidos(laboratorio.getExames()));
		return laboratorio;
	}

	@Override
	public List<Laboratorio> obterLaboratoriosAtivos() {
		List<Laboratorio> laboratorios = laboratorioRepository.listByStatus(Status.ATIVO);
		laboratorios.forEach(laboratorio -> laboratorio.setExames(validaExameService.obterExamesValidos(laboratorio.getExames())));
		return laboratorios;
	}
	
}
