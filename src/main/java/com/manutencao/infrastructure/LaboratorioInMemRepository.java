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

public class LaboratorioInMemRepository extends Observable implements LaboratorioRepository, Observer {
		
	private final Map<String, Laboratorio> map = new LinkedHashMap<>();

	@Override
	public void save(Laboratorio laboratorio) {
		map.put(laboratorio.getId(), laboratorio);
		mudarEstado(laboratorio);
	}

	@Override
	public Laboratorio getBy(String id) {
		return map.get(id);
	}

	@Override
	public List<Laboratorio> list() {
		return map.values().stream().collect(Collectors.toList());
	}
	
	@Override
	public List<Laboratorio> listByStatus(Status status) {
		return map.values().stream()
							.filter(laboratoio -> laboratoio.getStatus().equals(status))
							.collect(Collectors.toList());
	}

	@Override
	public void delete(String id) {
		Laboratorio laboratorio = getBy(id);
		laboratorio.setStatus(Status.INATIVO);
		mudarEstado(laboratorio);
		map.remove(id);		
	}

	@Override
	public void update(Observable o, Object arg) {
		Exame exame = (Exame) arg;
		
		listByStatus(Status.ATIVO)
				.stream()
				.map(laboratorioAtivo -> exame.getLaboratorios().stream()
						.filter(laboratorio -> laboratorioAtualizado(getBy(laboratorio), laboratorioAtivo.getId(), exame))
						.collect(Collectors.toList()))
				.collect(Collectors.toList());
	}
	
	private boolean laboratorioAtualizado(Laboratorio laboratorio, String idLaboratorio, Exame exameParam) {
		boolean laboratorioEncontrado = false;
		if(laboratorio.getId().equals(idLaboratorio)) {
			laboratorioEncontrado = true;
			if (Status.ATIVO.equals(exameParam.getStatus())) {
				addExame(laboratorio, exameParam.getId());
			} else {
				removerExame(laboratorio, exameParam.getId());
			}
		}							
		
		return laboratorioEncontrado;
	}
	
	private void addExame(Laboratorio laboratorio, String exameParam) {
		Optional<String> hasExame = laboratorio.getExames().stream()
															.filter(exame -> exame.equals(exameParam))
															.findAny();
		if (!hasExame.isPresent()) {
			laboratorio.getExames().add(exameParam);
		}
	}
	
	private void removerExame(Laboratorio laboratorio, String idExame) {
		Optional<String> hasExame = laboratorio.getExames().stream()
												.filter(exame -> exame.equals(idExame))
												.findAny();
		if (hasExame.isPresent()) {
			laboratorio.getExames().remove(hasExame.get());
		}
	}
	
	public void mudarEstado(Laboratorio laboratorio) {
		setChanged();
		notifyObservers(laboratorio);
	}


}
