package com.manutencao.service.laboratorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.laboratorio.Laboratorio;

@Service
public class AtualizaLaboratorioServiceImpl implements AtualizaLaboratorioService {
	
	private LaboratorioRepository laboratorioRepository;
	
	@Autowired
	public AtualizaLaboratorioServiceImpl(LaboratorioRepository laboratorioRepository) {
		this.laboratorioRepository = laboratorioRepository;
	}

	@Override
	public Laboratorio atualizar(Laboratorio laboratorio) {
		verificarLaboratorioExistente(laboratorio.getId());
		Laboratorio laboratorioSalvo = Laboratorio.clone(laboratorio); 
		laboratorioRepository.save(laboratorioSalvo);
		return laboratorioSalvo;
	}
	
	private void verificarLaboratorioExistente(String id) {
		Laboratorio laboratorio = laboratorioRepository.getBy(id);
		if (null == laboratorio) {
			throw new IllegalArgumentException();
		}
	}

}
