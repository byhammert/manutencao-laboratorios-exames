package com.manutencao.service.laboratorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;

@Service
public class DeletaLaboratorioServiceImpl implements DeletaLaboratorioService {
	
	private LaboratorioRepository laboratorioRepository;
	
	@Autowired
	public DeletaLaboratorioServiceImpl(LaboratorioRepository laboratorioRepository) {
		this.laboratorioRepository = laboratorioRepository;
	}

	@Override
	public void remover(String id) {
		verificarStatusLaborato(id);
		laboratorioRepository.delete(id);
	}
	
	private void verificarStatusLaborato(String id) {
		Laboratorio laboratorio = laboratorioRepository.getBy(id);
		boolean laboratorioInativo = laboratorio.getStatus().equals(Status.INATIVO);
		if (null == laboratorio || laboratorioInativo) {
			throw new IllegalArgumentException();
		}
	}

}
