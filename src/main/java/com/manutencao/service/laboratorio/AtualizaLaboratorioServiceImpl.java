package com.manutencao.service.laboratorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.service.exame.ValidaExameService;

@Service
public class AtualizaLaboratorioServiceImpl implements AtualizaLaboratorioService {
	
	private LaboratorioRepository laboratorioRepository;
	private ValidaExameService validaExameService;
	
	@Autowired
	public AtualizaLaboratorioServiceImpl(LaboratorioRepository laboratorioRepository,
			ValidaExameService validaExameService) {
		this.laboratorioRepository = laboratorioRepository;
		this.validaExameService = validaExameService;
	}

	@Override
	public Laboratorio atualizar(Laboratorio laboratorio) {
		verificarLaboratorioExistente(laboratorio.getId());
		Laboratorio laboratorioSalvo = Laboratorio.clone(laboratorio);
		List<String> examesValidos = validaExameService.obterExamesValidos(laboratorioSalvo.getExames());
		boolean examesInvalido = examesValidos.size() != laboratorioSalvo.getExames().size();
		if (examesInvalido) 
			throw new IllegalArgumentException("Um Laboratório só pode ser associado à um exame ativo.");
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
