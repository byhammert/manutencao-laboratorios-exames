package com.manutencao.infrastructure;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;

public class ExameInMemRepository implements ExameRepository{
	
	private final Map<String, Exame> map = new LinkedHashMap<>();

	@Override
	public void save(Exame exame) {
		map.put(exame.getId(), exame);
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
		map.remove(id);		
	}

}
