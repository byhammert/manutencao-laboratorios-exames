package com.manutencao.service.laboratorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.common.base.Preconditions;
import com.manutencao.infrastructure.LaboratorioRepository;
import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;

@Service
public class DeletaLaboratorioUsecaseImpl implements DeletaLaboratorioUsecase {
	
	private LaboratorioRepository laboratorioRepository;
	
	@Autowired
	public DeletaLaboratorioUsecaseImpl(LaboratorioRepository laboratorioRepository) {
		this.laboratorioRepository = laboratorioRepository;
	}

	@Override
	public void executar(String id) {
		Preconditions.checkArgument(!StringUtils.isEmpty(id), "Id deve ser informador.");
		verificarStatusLaborato(id);
		laboratorioRepository.delete(id);
	}
	
	private void verificarStatusLaborato(String id) {
		Laboratorio laboratorio = laboratorioRepository.getBy(id);
		boolean laboratorioNaoEncontrado = laboratorio == null || laboratorio.getStatus().equals(Status.INATIVO);
		if (laboratorioNaoEncontrado) {
			throw new IllegalArgumentException("Só é possível deletar laboratórios ativos.");
		}
	}

}
