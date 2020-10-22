package com.manutencao.service.exame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.model.exame.Exame;
import com.manutencao.service.laboratorio.ValidaLaboratorioUsecase;

@Service
public class CadastroExameUsecaseImpl implements CadastroExameUsecase {

	private ExameRepository exameRepository;
	private ValidaLaboratorioUsecase validaLaboratorioService;
	
	@Autowired
	public CadastroExameUsecaseImpl(ExameRepository exameRepository,
			ValidaLaboratorioUsecase validaLaboratorioService) {
		this.exameRepository = exameRepository;
		this.validaLaboratorioService = validaLaboratorioService;
	}
	
	@Override
	public Exame executar(Exame exame) {
		Exame exameSalvo = Exame.clone(exame);
		List<String> laboratoriosValidos = validaLaboratorioService.executar(exame.getLaboratorios());
		boolean laboratorioInvalido = laboratoriosValidos.size() != exameSalvo.getLaboratorios().size();
		if (laboratorioInvalido) 
			throw new IllegalArgumentException("Um exame só pode ser associado à um laboratório ativo.");
		exameRepository.save(exameSalvo);
		return exameSalvo;
	}

}
