package com.manutencao.service.laboratorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.service.exame.ValidaExameService;

@Service
public class CadastroLaboratorioServiceImpl implements CadastroLaboratorioService {

	private LaboratorioRepository laboratorioRepository;
	private ValidaExameService validaExameService;
	
	@Autowired
	public CadastroLaboratorioServiceImpl(LaboratorioRepository laboratorioRepository,
			ValidaExameService validaExameService) {
		this.laboratorioRepository = laboratorioRepository;
		this.validaExameService = validaExameService;
	}
	
	@Override
	public Laboratorio salvar(Laboratorio laboratorio) {
		Laboratorio laboratorioSalvo = Laboratorio.clone(laboratorio); 
		List<String> examesValidos = validaExameService.obterExamesValidos(laboratorioSalvo.getExames());
		boolean examesInvalido = examesValidos.size() != laboratorioSalvo.getExames().size();
		if (examesInvalido) 
			throw new IllegalArgumentException("Um Laboratório só pode ser associado à um exame ativo.");
		laboratorioRepository.save(laboratorioSalvo);
		return laboratorioSalvo;
	}

}
