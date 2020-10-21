package com.manutencao.service.exame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.model.exame.Exame;
import com.manutencao.service.laboratorio.ValidaLaboratorioService;

@Service
public class CadastroExameServiceImpl implements CadastroExameService {

	private ExameRepository exameRepository;
	private ValidaLaboratorioService validaLaboratorioService;
	
	@Autowired
	public CadastroExameServiceImpl(ExameRepository exameRepository,
			ValidaLaboratorioService validaLaboratorioService) {
		this.exameRepository = exameRepository;
		this.validaLaboratorioService = validaLaboratorioService;
	}
	
	@Override
	public Exame salvar(Exame exame) {
		Exame exameSalvo = Exame.clone(exame);
		List<String> laboratoriosValidos = validaLaboratorioService.obterLaboratoriosValidos(exame.getLaboratorios());
		boolean laboratorioInvalido = laboratoriosValidos.size() != exameSalvo.getLaboratorios().size();
		if (laboratorioInvalido) 
			throw new IllegalArgumentException("Um exame só pode ser associado à um laboratório ativo.");
		exameRepository.save(exameSalvo);
		return exameSalvo;
	}

}
