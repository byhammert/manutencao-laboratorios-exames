package com.manutencao.service.exame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.common.base.Preconditions;
import com.manutencao.infrastructure.ExameRepository;
import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;

@Service
public class DeletaExameServiceImpl implements DeletaExameService {
	
	private ExameRepository exameRepository;
	
	@Autowired
	public DeletaExameServiceImpl(ExameRepository exameRepository) {
		this.exameRepository = exameRepository;
	}

	@Override
	public void remover(String id) {
		Preconditions.checkArgument(!StringUtils.isEmpty(id), "Id deve ser informador.");
		verificarStatusExame(id);
		exameRepository.delete(id);
	}
	
	private void verificarStatusExame(String id) {
		Exame exame = exameRepository.getBy(id);
		boolean exameNaoEncontrato = exame == null || exame.getStatus().equals(Status.INATIVO);
		if ( exameNaoEncontrato) {
			throw new IllegalArgumentException("Só é possível deletar exames ativos.");
		}
	}

}
