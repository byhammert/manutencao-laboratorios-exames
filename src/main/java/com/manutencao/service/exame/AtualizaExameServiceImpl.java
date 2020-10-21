package com.manutencao.service.exame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.exceptionhandler.NotFoundExcetion;
import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.model.exame.Exame;
import com.manutencao.service.laboratorio.ValidaLaboratorioService;

@Service
public class AtualizaExameServiceImpl implements AtualizaExameService {
	
	private ExameRepository exameRepository;
	private ValidaLaboratorioService validaLaboratorioService;
	
	@Autowired
	public AtualizaExameServiceImpl(ExameRepository exameRepository,
			ValidaLaboratorioService validaLaboratorioService) {
		this.exameRepository = exameRepository;
		this.validaLaboratorioService = validaLaboratorioService;
	}

	@Override
	public Exame atualizar(Exame exame) {
		verificarExameExistente(exame.getId());
		Exame exameSalvo = Exame.clone(exame);
		List<String> laboratoriosValidos = validaLaboratorioService.obterLaboratoriosValidos(exame.getLaboratorios());
		boolean laboratorioInvalido = laboratoriosValidos.size() != exameSalvo.getLaboratorios().size();
		if (laboratorioInvalido) 
			throw new IllegalArgumentException("Um exame só pode ser associado à um laboratório ativo.");
		exameRepository.save(exameSalvo);
		return exameSalvo;
	}
	
	private void verificarExameExistente(String id) {
		Exame exame = exameRepository.getBy(id);
		if (null == exame) {
			throw new NotFoundExcetion();
		}
	}

}
