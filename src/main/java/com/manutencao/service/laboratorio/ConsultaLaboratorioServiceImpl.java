package com.manutencao.service.laboratorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;

@Service
public class ConsultaLaboratorioServiceImpl implements ConsultaLaboratorioService {

	private LaboratorioRepository laboratorioRepository;
	
	@Autowired
	public ConsultaLaboratorioServiceImpl(LaboratorioRepository laboratorioRepository) {
		this.laboratorioRepository = laboratorioRepository;
	}
	
	@Override
	public Laboratorio obter(String id) {
		return laboratorioRepository.getBy(id);
	}

	@Override
	public List<Laboratorio> obterLaboratoriosAtivos() {
		return laboratorioRepository.listByStatus(Status.ATIVO);
	}
	
}
