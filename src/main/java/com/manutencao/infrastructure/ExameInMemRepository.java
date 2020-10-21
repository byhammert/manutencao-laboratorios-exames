package com.manutencao.infrastructure;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import java.util.stream.Collectors;

import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;
import com.manutencao.model.laboratorio.Laboratorio;

public class ExameInMemRepository extends Observable implements ExameRepository, Observer{
	
	private final Map<String, Exame> map = new LinkedHashMap<>();

	@Override
	public void save(Exame exame) {
		map.put(exame.getId(), exame);
		mudarEstado(exame);
	}

	@Override
	public Exame getBy(String id) {
		return map.get(id);
	}

	@Override
	public List<Exame> list() {
		return map.values().stream().collect(Collectors.toList());
	}
	
	@Override
	public List<Exame> listByStatus(Status status) {
		return map.values().stream()
							.filter(exame -> exame.getStatus().equals(status))
							.collect(Collectors.toList());
	}

	@Override
	public void delete(String id) {
		Exame exame = getBy(id);
		exame.setStatus(Status.INATIVO);
		mudarEstado(exame);
		map.remove(id);		
	}
	
	public List<Exame> obterExamesValidos(List<Exame> exames) {
		List<Exame> examesAtivos = listByStatus(Status.ATIVO);
		return examesAtivos.stream()
						   .flatMap(exameAtivo -> exames.stream()
														.filter(exame -> exame.getId().equals(exameAtivo.getId())))
						   .collect(Collectors.toList());
																				
																			
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Laboratorio laboratorio = (Laboratorio) arg;
		
		listByStatus(Status.ATIVO)
				.stream()
				.map(exameAtivo -> laboratorio.getExames()
						.stream()
						.filter(exame -> exameAtualizado(getBy(exame), exameAtivo.getId(), laboratorio))
						.collect(Collectors.toList()))
				.collect(Collectors.toList());
	}
	
	private boolean exameAtualizado(Exame exame, String idExame, Laboratorio laboratorioParam) {
		boolean exameEncontrado = false;
		if(exame.getId().equals(idExame)) {
			exameEncontrado = true;
			if (Status.ATIVO.equals(laboratorioParam.getStatus())) {
				addLaboratorio(exame, laboratorioParam.getId());
			} else {
				removerLaboratorio(exame, laboratorioParam.getId());
			}
		}							
		
		return exameEncontrado;
	}
	
	private void addLaboratorio(Exame exame, String laboratorioParam) {
		Optional<String> hasLaboratorio = exame.getLaboratorios().stream()
															.filter(laboratorio -> laboratorio.equals(laboratorioParam))
															.findAny();
		if (!hasLaboratorio.isPresent()) {
			exame.getLaboratorios().add(laboratorioParam);
		}
	}
	
	private void removerLaboratorio(Exame exame, String idLaboratorio) {
		Optional<String> hasLaboratorio = exame.getLaboratorios()
												.stream()
												.filter(laboratorio -> laboratorio.equals(idLaboratorio))
												.findAny();
		if (hasLaboratorio.isPresent()) {
			exame.getLaboratorios().remove(hasLaboratorio.get());
		}
	}
	
	public void mudarEstado(Exame exame) {
		setChanged();
		notifyObservers(exame);
	}

}
