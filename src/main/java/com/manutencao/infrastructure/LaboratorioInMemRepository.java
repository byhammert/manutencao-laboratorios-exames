package com.manutencao.infrastructure;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;

public class LaboratorioInMemRepository implements LaboratorioRepository{
	
	private final Map<String, Laboratorio> map = new LinkedHashMap<>();

	@Override
	public void save(Laboratorio laboratorio) {
		map.put(laboratorio.getId(), laboratorio);
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
		map.remove(id);		
	}

}
