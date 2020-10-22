package com.manutencao.service.laboratorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.exceptionhandler.NotFoundExcetion;
import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.service.exame.ValidaExameUsecase;

@Service
public class AtualizaLaboratorioUsecaseImpl implements AtualizaLaboratorioUsecase {
	
	private LaboratorioRepository laboratorioRepository;
	private ValidaExameUsecase validaExameService;
	
	@Autowired
	public AtualizaLaboratorioUsecaseImpl(LaboratorioRepository laboratorioRepository,
			ValidaExameUsecase validaExameService) {
		this.laboratorioRepository = laboratorioRepository;
		this.validaExameService = validaExameService;
	}

	@Override
	public Laboratorio executar(Laboratorio laboratorio) {
		verificarLaboratorioExistente(laboratorio.getId());
		Laboratorio laboratorioSalvo = Laboratorio.clone(laboratorio);
		List<String> examesValidos = validaExameService.executar(laboratorioSalvo.getExames());
		boolean examesInvalido = examesValidos.size() != laboratorioSalvo.getExames().size();
		if (examesInvalido) 
			throw new IllegalArgumentException("Um Laboratório só pode ser associado à um exame ativo.");
		laboratorioRepository.save(laboratorioSalvo);
		return laboratorioSalvo;
	}
	
	private void verificarLaboratorioExistente(String id) {
		Laboratorio laboratorio = laboratorioRepository.getBy(id);
		if (null == laboratorio) {
			throw new NotFoundExcetion();
		}
	}

}
