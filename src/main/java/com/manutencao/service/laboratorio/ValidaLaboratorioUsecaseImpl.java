package com.manutencao.service.laboratorio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;

@Service
public class ValidaLaboratorioUsecaseImpl implements ValidaLaboratorioUsecase {
	
	private LaboratorioRepository laboratorioRepository;
	
	public ValidaLaboratorioUsecaseImpl(LaboratorioRepository laboratorioRepository) {
		this.laboratorioRepository = laboratorioRepository;
	}
	
	public List<String> executar(List<String> laboratorios) {
		List<Laboratorio> laboratoriosAtivos = laboratorioRepository.listByStatus(Status.ATIVO);
		return laboratoriosAtivos.stream()
								 .flatMap(laboratorioAtivo -> laboratorios.stream()
																		  .filter(laboratorio -> laboratorio.equals(laboratorioAtivo.getId())))
								 .collect(Collectors.toList());
																				
																			
	}

}
